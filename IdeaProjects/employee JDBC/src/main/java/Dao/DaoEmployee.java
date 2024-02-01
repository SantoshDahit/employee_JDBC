package Dao;

import Employee.Employee;
import Query.SqlQuery;
import database.DataBase;

import java.sql.*;
import java.util.ArrayList;

public class DaoEmployee {

    public static void createEmployee(Employee employee) throws SQLException {
        Connection conn = DataBase.connect();
        String sqlQuery = SqlQuery.insert;
        PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery);
        preparedStatement.setInt(1, employee.getId());
        preparedStatement.setString(2, employee.getName());
        preparedStatement.setString(3, employee.getEmail());
        preparedStatement.setInt(4, employee.getSalary());

        System.out.println("\n ps = " + preparedStatement + "\n" + employee);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static ArrayList<Employee> readAllEmployee() throws SQLException {
        ArrayList<Employee> empList = new ArrayList<Employee>();
        Connection conn = DataBase.connect();
        String query = SqlQuery.select;
        Statement statement = conn.prepareStatement(query);
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            empList.add(emp);
        }
        statement.close();
        return empList;
    }
    public static void updateEmployee(int id, String name) throws SQLException{
        Connection conn = DataBase.connect();
        String sqlQuery = SqlQuery.update;
        PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery);
        preparedStatement.setInt(2, id);
        preparedStatement.setString(1, name);
        System.out.println("\n ps = " + preparedStatement);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static void deleteEmployee(int id) throws SQLException {
        Connection conn = DataBase.connect();
        String sqlQuery = SqlQuery.delete;
        PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery);
        preparedStatement.setInt(1, id);
        System.out.println("\n ps = " + preparedStatement);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
