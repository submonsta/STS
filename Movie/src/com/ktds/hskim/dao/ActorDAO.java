package com.ktds.hskim.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.hskim.util.xml.XML;
import com.ktds.hskim.vo.ActorVO;
import com.ktds.hskim.vo.MovieVO;

public class ActorDAO extends MovieVO {
	
	public List<ActorVO> getActors ( int movieId ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ActorVO> actors = new ArrayList<ActorVO>();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//Query/actor/getActorInfo/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, movieId);
			
			rs = stmt.executeQuery();
			
			ActorVO actor = null;
			
			while ( rs.next() ) {
				
				actor = new ActorVO();
				actor.setActorName(rs.getString("ACTOR_NAME"));

				actors.add(actor);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
		return actors;
	}
	
	public List<ActorVO> getAllActors () {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ActorVO> actors = new ArrayList<ActorVO>();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//Query/actor/getAllActorInfo/text()");
			stmt = conn.prepareStatement(query);
			
			rs = stmt.executeQuery();
			
			ActorVO actor = null;
			
			while ( rs.next() ) {
				
				actor = new ActorVO();
				
				actor.setActorId(rs.getInt("ACTOR_ID"));
				actor.setActorName(rs.getString("ACTOR_NAME"));

				actors.add(actor);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
		return actors;
	}
	
	public boolean addNewActor( String actorName ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			
			String query = XML.getNodeString("//Query/actor/insertNewActor/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, actorName);
			
			int insertCount = stmt.executeUpdate();
			
			return insertCount > 0;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
		
	}
	
	public int insertNewActorOfNewMovie( ActorVO actor ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;		
		int insertCount = 0;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			
			String query = XML.getNodeString("//Query/actor/insertActorList/text()");
			stmt = conn.prepareStatement(query);
		
			stmt.setInt(1,actor.getMovieId());
			stmt.setInt(2, actor.getActorId());
		
			insertCount = stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
		
		return insertCount;
		
	}
	
	
	/**
	 * Oracle Driver
	 */
	private void loadOracleDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	/**
	 * Close DB
	 */
	private void closeDB(Connection conn, PreparedStatement stmt, ResultSet rs) {
		if ( rs != null ) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if ( stmt != null ) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
		if ( conn != null ) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
}
