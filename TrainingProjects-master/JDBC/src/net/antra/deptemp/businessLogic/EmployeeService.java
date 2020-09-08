package net.antra.deptemp.businessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import net.antra.deptemp.entity.Department;
import net.antra.deptemp.entity.Employee;
import net.antra.deptemp.utility.JdbcUtility;

public class EmployeeService {
	public List<Employee> addNewEmployee(String firstName, String lastName, String age, int deptId) throws SQLException{
		try(Connection conn = JdbcUtility.getConnection();
				PreparedStatement stmt = conn.prepareStatement("insert into employee (first_name, last_name, age, dept_id) values (?,?,?,?) ");) {
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			if(age != null && !"".equals(age.trim())){
				stmt.setInt(3, Integer.parseInt(age));
			}else{
				stmt.setNull(3, Types.INTEGER);
			}
			stmt.setInt(4, deptId);
			stmt.executeUpdate();
		} catch (Exception se) {
			se.printStackTrace();
		}
		return getEmployeeList();
	}
	public List<Employee> getEmployeeList() throws SQLException{
		List<Employee> resList = new ArrayList<Employee>();
		try(Connection conn = JdbcUtility.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from employee");
				PreparedStatement stmt2 = conn.prepareStatement("select dept_name, dept_email from department where dept_id = ?");) {
			while (rs.next()) {
				int id = rs.getInt("emp_id");
				String first = rs.getString("first_name");
				String last = rs.getString("last_name");
				Integer age = rs.getInt("age");
				if(rs.wasNull()){
					age = null;
				}
				Integer deptId = rs.getInt("dept_id");
				//load department
				stmt2.setInt(1, deptId);
				ResultSet rsDept = stmt2.executeQuery();
				Department department = new Department();
				department.setId(deptId);
				while(rsDept.next()){
					department.setName(rsDept.getString("dept_name"));
					department.setEmail(rsDept.getString("dept_email"));
				}
				resList.add(new Employee(id,first,last,age,department));
			}
		} catch (Exception se) {
			se.printStackTrace();
		}
		return resList;
	}
}
