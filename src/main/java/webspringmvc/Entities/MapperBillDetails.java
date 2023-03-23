package webspringmvc.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperBillDetails implements RowMapper<BillDetails>{

	@Override
	public BillDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		BillDetails billdetails = new BillDetails();
		billdetails.setId(rs.getInt("id"));
		billdetails.setId_sp(rs.getInt("id_sp"));
		billdetails.setId_bills(rs.getInt("id_bills"));
		billdetails.setQuanty(rs.getInt("Quanty"));
		billdetails.setTotal(rs.getDouble("Total"));
		return null;
	}

}
