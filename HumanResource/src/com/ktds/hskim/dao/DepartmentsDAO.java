package com.ktds.hskim.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.hskim.vo.DepartmentsVO;

public class DepartmentsDAO {
	
	public List<DepartmentsVO> allDepartment() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<DepartmentsVO> departments = new ArrayList<DepartmentsVO>();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			
			String query = " SELECT * FROM DEPARTMENTS ";
			stmt = conn.prepareStatement(query);
			
			rs = stmt.executeQuery();
			
			DepartmentsVO department = null;
			
			while ( rs.next() ) {
				department = new DepartmentsVO();
				
				department.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				department.setDepartmentName(rs.getNString("DEPARTMENT_NAME"));
				department.setManagerId(rs.getInt("MANAGER_ID"));
				department.setLocationId(rs.getInt("LOCATION_ID"));
				
				departments.add(department);
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
			if ( rs != null ) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
		}
		
		return departments;
		
	} // allDepartment end
	
} // class end 
