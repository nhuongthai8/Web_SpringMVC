package webspringmvc.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import webspringmvc.DTO.SanphamDTO;
import webspringmvc.Entities.Bills;
import webspringmvc.Entities.Loaisanpham;
import webspringmvc.Entities.Nhaphanphoi;
import webspringmvc.Entities.Users;

@Repository
public class AdminDAO extends BaseDAO {
	//=============================================================================================
	// lấy tất cả npp đưa lên table trong admin npp
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
	
	//=============================================================================================
	// lấy tất cả loại sản phẩm đưa lên table trong admin lsp
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

	
	//=============================================================================================
	// lấy tất cả khách hàng đưa lên table trong admin lsp
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

	
	//=============================================================================================
	// lấy tất cả sản phẩm đưa lên table trong admin lsp
	public List<SanphamDTO> getSanpham() {
		return _jdbcTemplate
				.query("SELECT sp.id, sp.id_lsp, sp.id_npp, sp.TenSP, sp.HinhSP, sp.GiaSP, sp.NoiDung, sp.highlight "
						+ "FROM sanpham sp " + "JOIN loaisanpham lsp ON sp.id_lsp = lsp.id "
						+ "JOIN nhaphanphoi npp ON sp.id_npp = npp.id ORDER BY sp.id ASC", new RowMapper<SanphamDTO>() {
							public SanphamDTO mapRow(ResultSet rs, int row) throws SQLException {
								SanphamDTO e = new SanphamDTO();
								e.setId(rs.getInt(1));
								e.setId_lsp(rs.getInt(2));
								e.setId_npp(rs.getInt(3));
								e.setTenSP(rs.getString(4));
								e.setHinhSP(rs.getString(5));
								e.setGiaSP(rs.getDouble(6));
								e.setNoiDung(rs.getString(7));
								e.setHighlight(rs.getInt(8));
								return e;
							}
						});
	}

	
	//=============================================================================================
	// lấy tất cả bills đưa lên table trong admin lsp
	public List<Bills> getBills() {
		return _jdbcTemplate.query("select * from `bills`", new RowMapper<Bills>() {
			public Bills mapRow(ResultSet rs, int row) throws SQLException {
				Bills e = new Bills();
				e.setId(rs.getInt(1));
				e.setHoTen(rs.getString(2));
				e.setDiaChi(rs.getString(3));
				e.setSDT(rs.getInt(4));
				e.setEmail(rs.getString(5));
				e.setUsername(rs.getString(6));
				e.setQuanty(rs.getInt(7));
				e.setTotal(rs.getDouble(8));
				e.setNote(rs.getString(9));
				return e;
			}
		});
	}
}
