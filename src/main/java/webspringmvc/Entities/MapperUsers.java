package webspringmvc.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperUsers implements RowMapper<Users>{

	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users user = new Users();
		user.setId(rs.getInt("id"));
		user.setHoTen(rs.getString("HoTen"));
		user.setDiaChi(rs.getString("DiaChi"));
		user.setSDT(rs.getInt("SDT"));
		user.setEmail(rs.getString("Email"));
		user.setUsername(rs.getString("Username"));
		user.setPassword(rs.getString("Password"));
		return user;
	}
	
}
