package nongsan.webmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;
import nongsan.webmvc.model.User;
import nongsan.webmvc.dao.UserDao;
import nongsan.webmvc.jdbc.connectDB;

public class UserDaoImpl extends connectDB implements UserDao {
	
	@Override
	public void insert(User user) {
		String sql = "INSERT INTO users(id,name,email,phone,username,password,created) VALUES (?,?,?,?,?,?,?)";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getUsername());
			ps.setString(6, user.getPassword());
			ps.setString(7,user.getCreated());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		String sql = "DELETE FROM users where id = ?";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public User get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<User> getAll() {		
		List<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM users";
		Connection conn = connectDB.getConnect();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();

				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCreated(rs.getString("created"));
				users.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			
		}

		return users; 
	}

	@Override
	public void edit(User user) {
		// TODO Auto-generated method stub
		
	}
	
}

