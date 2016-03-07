package com.ktds.hskim.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.hskim.vo.MovieActorVO;

public class MovieActorDAO {
	
	public List<MovieActorVO> allList() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<MovieActorVO> movieActors = new ArrayList<MovieActorVO>();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			
			String query = " SELECT TITLE, ACTOR_NAME FROM ACTOR A, MOVIE M, ACTOR_LIST AL WHERE M.MOVIE_ID = AL.MOVIE_ID AND A.ACTOR_ID = AL.ACTOR_ID ";
			stmt = conn.prepareStatement(query);
			
			rs = stmt.executeQuery();
			
			MovieActorVO movieActor = null;
			
			while ( rs.next() ) {
				
				movieActor = new MovieActorVO();
				
				movieActor.setTitle(rs.getString("TITLE"));
				movieActor.setActorName(rs.getString("ACTOR_NAME"));
				
				movieActors.add(movieActor);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
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
		
		return movieActors;
	}
}
