package com.ktds.hskim.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.hskim.vo.EmployeesVO;

public class EmployeesDAO {
	
	public List<EmployeesVO> getAllEmployees() {
		
		// 구현체 지정
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<EmployeesVO> employees = new ArrayList<EmployeesVO>();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			
			// Query 실행할 준비
			String query = " SELECT * FROM EMPLOYEES ";
			stmt = conn.prepareStatement(query);
			
			// Query의 실행 결과를 가져옴
			// Select 쿼리 일 때만 사용
			rs = stmt.executeQuery();
			
			EmployeesVO employee = null;
			while ( rs.next() ) {
				employee = new EmployeesVO();
				employee.setEmployee_Id(rs.getInt("EMPLOYEE_ID"));
				employee.setFirstName(rs.getString("First_Name"));
				employee.setLastName(rs.getNString("LAST_NAME"));
				employee.setEmail(rs.getString("EMAIL"));
				employee.setPhoneNumber(rs.getNString("PHONE_NUMBER"));
				employee.setHireDate(rs.getNString("HIRE_DATE"));
				employee.setJobId(rs.getNString("JOB_ID"));
				employee.setSalary(rs.getInt("SALARY"));
				employee.setCommissionPct(rs.getDouble("COMMISSION_PCT"));
				employee.setManagerId(rs.getInt("MANAGER_ID"));
				employee.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				
				employees.add(employee);
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
		
		return employees;
	}
	
}
