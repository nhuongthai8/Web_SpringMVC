package webspringmvc.DAO;

import org.springframework.stereotype.Repository;

import webspringmvc.Entities.MapperUsers;
import webspringmvc.Entities.Users;

@Repository
public class UsersDAO extends BaseDAO{
	public int AddAccount (Users user) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert ");
		sql.append("into users ");
		sql.append("( ");
		sql.append("`HoTen`, ");
		sql.append("`DiaChi`, ");
		sql.append("`SDT`, ");
		sql.append("`Email`, ");
		sql.append("`Username`, ");
		sql.append("`Password`) ");
		sql.append("values (");
		sql.append(" '"+user.getHoTen()+"', ");
		sql.append(" '"+user.getDiaChi()+"', ");
		sql.append(" '"+user.getSDT()+"', ");
		sql.append(" '"+user.getEmail()+"', ");
		sql.append(" '"+user.getUsername()+"', ");
		sql.append(" '"+user.getPassword()+"' ");
		sql.append(")");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public Users CheckAccount (Users user) {
		String sql = "SELECT * FROM `users` WHERE Username = '"+user.getUsername()+"'";
		Users check = _jdbcTemplate.queryForObject(sql,new MapperUsers());
		return check;
	}
}
