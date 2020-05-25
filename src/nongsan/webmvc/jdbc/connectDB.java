package nongsan.webmvc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import nongsan.webmvc.model.Catalog;

public class connectDB {
	public connectDB(){
		
	}
	public static Connection getConnect(){
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;user=sa;password=123");
			System.out.println("Kết nối DB thành công!");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Kết nối DB thất bại!"+e.getMessage());
		}
		return connection;
	}
	public static void main(String[] args) {
		System.out.println(getConnect());
	}
}
