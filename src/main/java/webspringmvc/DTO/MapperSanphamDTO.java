package webspringmvc.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperSanphamDTO implements RowMapper<SanphamDTO>{

	@Override
	public SanphamDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		SanphamDTO sanphamDTO = new SanphamDTO();
		sanphamDTO.setId(rs.getInt("id"));
		sanphamDTO.setId_lsp(rs.getInt("id_lsp"));
		sanphamDTO.setId_npp(rs.getInt("id_npp"));
		sanphamDTO.setTenSP(rs.getString("TenSP"));
		sanphamDTO.setHinhSP(rs.getString("HinhSP"));
		sanphamDTO.setGiaSP(rs.getDouble("GiaSP"));
		sanphamDTO.setNoiDung(rs.getString("NoiDung"));
		sanphamDTO.setHighlight(rs.getInt("highlight"));
		return sanphamDTO;
	}
	
}
