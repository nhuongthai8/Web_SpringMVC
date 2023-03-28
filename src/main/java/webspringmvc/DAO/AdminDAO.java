package webspringmvc.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import webspringmvc.Entities.Loaisanpham;
import webspringmvc.Entities.Nhaphanphoi;
import webspringmvc.Entities.Users;

@Repository
public class AdminDAO extends BaseDAO {
	// lấy tất cả npp đuâ lên table trong admin npp
	public List<Nhaphanphoi> getNhaphanhoi() {
		return _jdbcTemplate.query("select * from `nhaphanphoi`", new RowMapper<Nhaphanphoi>() {
			public Nhaphanphoi mapRow(ResultSet rs, int row) throws SQLException {
				Nhaphanphoi e = new Nhaphanphoi();
				e.setId(rs.getInt(1));
				e.setTenNPP(rs.getString(2));
				return e;
			}
		});
	}

	// lấy tất cả lsp đuâ lên table trong admin lsp
	public List<Loaisanpham> getLoaisanpham() {
		return _jdbcTemplate.query("select * from `loaisanpham`", new RowMapper<Loaisanpham>() {
			public Loaisanpham mapRow(ResultSet rs, int row) throws SQLException {
				Loaisanpham e = new Loaisanpham();
				e.setId(rs.getInt(1));
				e.setTenLSP(rs.getString(2));
				return e;
			}
		});
	}
	
	// lấy tất cả lsp đuâ lên table trong admin lsp
		public List<Users> getKhachhang() {
			return _jdbcTemplate.query("select * from `users`", new RowMapper<Users>() {
				public Users mapRow(ResultSet rs, int row) throws SQLException {
					Users e = new Users();
					e.setId(rs.getInt(1));
					e.setHoTen(rs.getString(2));
					e.setDiaChi(rs.getString(3));
					e.setSDT(rs.getInt(4));
					e.setEmail(rs.getString(5));
					e.setUsername(rs.getString(6));
					e.setPassword(rs.getString(7));
					return e;
				}
			});
		}
}
