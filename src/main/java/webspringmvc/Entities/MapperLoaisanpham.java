package webspringmvc.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperLoaisanpham implements RowMapper<Loaisanpham>{

	@Override
	public Loaisanpham mapRow(ResultSet rs, int rowNum) throws SQLException {
		Loaisanpham loaisanpham = new Loaisanpham();
		loaisanpham.setId(rs.getInt("id"));
		loaisanpham.setTenLSP(rs.getString("TenLSP"));
		return loaisanpham;
	}
	
}
