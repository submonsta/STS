package com.ktds.hskim.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.cpdsadapter.DriverAdapterCPDS;

import com.ktds.hskim.vo.CountriesVO;

public class CountriesDAO {
	
	public List<CountriesVO> allCountries() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;	

		List<CountriesVO> countries = new ArrayList<CountriesVO>();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			
			String query = " SELECT * FROM COUNTRIES ";
			stmt = conn.prepareStatement(query);
			
			rs = stmt.executeQuery();
			
			CountriesVO country;
			
			while (rs.next()) {
				
				country = new CountriesVO();
				
				country.setCountryId(rs.getNString("COUNTRY_ID"));
				country.setCountryName(rs.getNString("COUNTRY_NAME"));
				country.setRegionId(rs.getInt("REGION_ID"));
				
				countries.add(country);
				
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
		
		return countries;
	}
}
