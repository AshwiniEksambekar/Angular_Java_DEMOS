package com.app.sellerconsumer.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.app.sellerconsumer.model.User;

public class UserDaoImpl implements UserDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public int updateUserInfo(User user) {
    String sql = "insert into users values(?,?,?,?,?,?,?)";

    return jdbcTemplate.update(sql, new Object[] { user.getUserid(), user.getName(), user.getEmail(), user.getRole() });
  }

 

}

class UserMapper implements RowMapper {

  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();

    user.setUserid(rs.getInt("userid"));
    user.setName(rs.getString("name"));
    user.setEmail(rs.getString("email"));
   
    return user;
  }

@Override
public int[] getRowsForPaths(TreePath[] path) {
	// TODO Auto-generated method stub
	return null;
}



}