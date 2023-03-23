package webspringmvc.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperNhaphanphoi implements RowMapper<Nhaphanphoi>{

	@Override
	public Nhaphanphoi mapRow(ResultSet rs, int rowNum) throws SQLException {
		Nhaphanphoi npp = new Nhaphanphoi();
		npp.setId(rs.getInt("id"));
		npp.setTenNPP(rs.getString("TenNPP"));
		return npp;
	}

}
