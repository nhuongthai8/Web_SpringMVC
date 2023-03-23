package webspringmvc.DAO;

import org.springframework.stereotype.Repository;

import webspringmvc.Entities.BillDetails;
import webspringmvc.Entities.Bills;

@Repository
public class BillsDAO extends BaseDAO{
	
	public int AddBills(Bills bills) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into bills ");
		sql.append("( ");
		sql.append(" `HoTen`, `DiaChi`, `SDT`, `Email`, `Username`, `Quanty`, `Total`, `Note`)");
		sql.append("values (");
		sql.append(" '"+bills.getHoTen()+"', ");
		sql.append(" '"+bills.getDiaChi()+"', ");
		sql.append(" '"+bills.getSDT()+"', ");
		sql.append(" '"+bills.getEmail()+"', ");
		sql.append(" '"+bills.getUsername()+"', ");
		sql.append(" '"+bills.getQuanty()+"', ");
		sql.append(" '"+bills.getTotal()+"', ");
		sql.append(" '"+bills.getNote()+"' ");
		sql.append(") ");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public int GetIDLastBills() {
		StringBuffer sql = new StringBuffer();
		sql.append("select max(id) from bills");
		int id = _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, Integer.class);
		return id;
		
	}
	
	public int AddBillsDetail(BillDetails billdetails) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into billdetails ");
		sql.append("( ");
		sql.append(" id_sp, ");
		sql.append(" id_bills, ");
		sql.append(" Quanty, ");
		sql.append(" Total");
		sql.append(") ");
		sql.append("values (");
		sql.append(" '"+billdetails.getId_sp()+"', ");
		sql.append(" '"+billdetails.getId_bills()+"', ");
		sql.append(" '"+billdetails.getQuanty()+"', ");
		sql.append(" '"+billdetails.getTotal()+"') ");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
}
