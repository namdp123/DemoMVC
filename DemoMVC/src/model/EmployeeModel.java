package model;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import object.Employee;

public class EmployeeModel {
	private static Connection getConnection() throws Exception {
		   return DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=DemoMVC;user=sa;password=sa2012");
		 }
	public int insert( Employee emp) throws SQLException {
		Connection c = null;
		PreparedStatement ps = null;
		   int cnt = 0;

		   try {
		     c = this.getConnection();
		     ps = c.prepareStatement("Them vao mot nhan vien(?, ?, ?, ?)");
		     int i = 0;
		 
		     ps.setNString(++i, emp.getMaSo());
		     ps.setNString(++i, emp.getHoTen());
		     ps.setNString(++i, emp.getGioiTinh());
		     ps.setNString(++i, emp.getNgaySinh());
		     ps.setNString(++i, emp.getDiaChi());
		     cnt = ps.executeUpdate(); 
		   } catch (Exception e) {
		      e.printStackTrace();
		   } finally {
		     if (ps != null) {
		       ps.close();
		     }
		     if (c != null) {
		       c.close();
		     }
		   } 
		    return cnt;
	}
	public Employee display (Employee valueObject) throws SQLException {
		Connection con = null;
		   PreparedStatement ps = null;
		   ResultSet rs = null;
		   Employee emp = null;
		   int cnt = 0;
		   try {
		    con = this.getConnection();
		    ps = con.prepareStatement("select * from employees where id = ?");
		    ps.setNString(1, valueObject.getMaSo());
		    rs = ps.executeQuery();
		    emp = new Employee();
		    while (rs.next()) {
		      emp.setMaSo(rs.getString("MaSo"));
		      emp.setHoTen(rs.getString("HoTen"));
		      emp.setGioiTinh(rs.getString("GioiTinh"));
		      emp.setNgaySinh(rs.getString("NgaySinh"));
		      emp.setDiaChi(rs.getString("DiaChi"));
		      cnt++;
		    }
		    if (cnt > 0)
		      return emp;
		 
		   } catch (Exception e) {
		     System.out.println(e);
		   } finally {
		     if (rs != null) {
		       rs.close();
		     }
		     if (ps != null) {
		       ps.close();
		     }
		     if (con != null) {
		       con.close();
		     }
		   }
		   return null;
	}
	

}
