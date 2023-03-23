package webspringmvc.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperBills implements RowMapper<Bills>{

	@Override
	public Bills mapRow(ResultSet rs, int rowNum) throws SQLException {
		Bills bills = new Bills();
		bills.setId(rs.getInt("id"));
		bills.setHoTen(rs.getString("HoTen"));
		bills.setDiaChi(rs.getString("DiaChi"));
		bills.setSDT(rs.getInt("SDT"));
		bills.setEmail(rs.getString("Email"));
		bills.setUsername(rs.getString("Username"));
		bills.setQuanty(rs.getInt("Quanty"));
		bills.setTotal(rs.getDouble("Total"));
		bills.setNote(rs.getString("Note"));
		return bills;
	}

}
