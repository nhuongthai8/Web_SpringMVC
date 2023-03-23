package webspringmvc.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import webspringmvc.DTO.MapperSanphamDTO;
import webspringmvc.DTO.SanphamDTO;



@Repository
public class SanphamDAO extends BaseDAO{
	
	private StringBuffer sqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		sql.append("sp.id as id ");
		sql.append(", sp.id_lsp ");
		sql.append(", sp.id_npp ");
		sql.append(", sp.TenSP ");
		sql.append(", sp.HinhSP ");
		sql.append(", sp.GiaSP ");
		sql.append(", sp.NoiDung ");
		sql.append(", sp.highlight ");
		sql.append("from ");
		sql.append("sanpham as sp ");
		return sql;
	}
	//=================================================================//
	//lấy tất cả sản phẩm, sắp xếp random
	private String sqlStringGetDataAllSanpham() {
		StringBuffer sql= sqlString();
		sql.append("order by rand() ");
		return sql.toString();
	}
	
	public List<SanphamDTO> GetDataAllSanpham(){
		List<SanphamDTO> list = new ArrayList<SanphamDTO>();
		String sql = sqlStringGetDataAllSanpham();
		list = _jdbcTemplate.query(sql, new MapperSanphamDTO());
		return list;
	}
	//=================================================================//
	//lấy sản phẩm có highlight
	private String sqlStringGetDataSanphamHighlight() {
		StringBuffer sql= sqlString();
		sql.append("where highlight = 0 ");
		sql.append("order by id desc ");
		sql.append("limit 0,6 ");
		return sql.toString();
	}
	
	public List<SanphamDTO> GetDataSanphamHighlight(){
		List<SanphamDTO> list = new ArrayList<SanphamDTO>();
		String sql = sqlStringGetDataSanphamHighlight();
		list = _jdbcTemplate.query(sql, new MapperSanphamDTO());
		return list;
	}
	//=================================================================//
	//lấy tất cả sản phẩm mới, giới hạn 6
	private String sqlStringGetDataSanphams() {
		StringBuffer sql= sqlString();
		sql.append("order by id desc ");
		sql.append("limit 0,6 ");
		return sql.toString();
	}
	
	public List<SanphamDTO> GetDataSanphams(){
		List<SanphamDTO> list = new ArrayList<SanphamDTO>();
		String sql = sqlStringGetDataSanphams();
		list = _jdbcTemplate.query(sql, new MapperSanphamDTO());
		return list;
	}
	//=================================================================//
	//lấy sản phẩm theo loại
	
	private StringBuffer sqlGetDataSanphamTLid(int id) {
		StringBuffer sql = sqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("and id_lsp = "+id+" ");
		return sql;
	}
	private String sqlGetDataSanphamTLpaginate(int id,int start, int totalPage) {
		StringBuffer sql = sqlGetDataSanphamTLid(id);
		sql.append("limit "+ start + ", "+ totalPage);
		return sql.toString();
	}
	
	public List<SanphamDTO> GetDataSanphamTLid(int id){
		List<SanphamDTO> list = new ArrayList<SanphamDTO>();
		String sql = sqlGetDataSanphamTLid(id).toString();
		list = _jdbcTemplate.query(sql, new MapperSanphamDTO());
		return list;
	}
	
	public List<SanphamDTO> GetDataSanphamTLpaginate(int id,int start, int totalPage){
		StringBuffer sqlGetDataTLid = sqlGetDataSanphamTLid(id);
		List<SanphamDTO> list_databyid = _jdbcTemplate.query(sqlGetDataTLid.toString(), new MapperSanphamDTO());
		List<SanphamDTO> list = new ArrayList<SanphamDTO>();
		if(list_databyid.size()>0) {
			String sql = sqlGetDataSanphamTLpaginate(id,start,totalPage);
			list = _jdbcTemplate.query(sql, new MapperSanphamDTO());
		}
		return list;
	}
	//=================================================================//
	//lấy sản phẩm theo nhà phân phối
	
	
//	private String sqlGetDataSanphamTNPPid(int id) {
//		StringBuffer sql = sqlString();
//		sql.append("WHERE 1 = 1 ");
//		sql.append("and id_npp = "+id);
//		return sql.toString();
//	}
//	private String sqlGetDataSanphamTNPPpaginate(int start, int end) {
//		StringBuffer sql = sqlString();
//		sql.append("limit "+ start + ", "+ end);
//		return sql.toString();
//	}
//	
//	public List<SanphamDTO> GetDataSanphamTNPPid(int id){
//		List<SanphamDTO> list = new ArrayList<SanphamDTO>();
//		String sql = sqlGetDataSanphamTNPPid(id);
//		list = _jdbcTemplate.query(sql, new MapperSanphamDTO());
//		return list;
//	}
//	
//	public List<SanphamDTO> GetDataSanphamTNPPpaginate(int start, int end){
//		List<SanphamDTO> list = new ArrayList<SanphamDTO>();
//		String sql = sqlGetDataSanphamTNPPpaginate(start,end);
//		list = _jdbcTemplate.query(sql, new MapperSanphamDTO());
//		return list;
//	}
	
	//=================================================================//
	//lấy thông tin chi tiết 1 sản phẩm
	private String sqlGetDataSPid(int id) {
		StringBuffer sql = sqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("and sp.id = "+id+" ");
		return sql.toString();
	}
	
	public List<SanphamDTO> GetSPid(int id) {
		String sql = sqlGetDataSPid(id);
		List<SanphamDTO> listSP = _jdbcTemplate.query(sql,new MapperSanphamDTO());
		return listSP;
	}
	//=================================================================//
	//lấy sản phẩm liên quan
	public StringBuffer sqlGetDataSanphamLienQuan(int id) {
		StringBuffer sql = sqlString();
		sql.append("where id_lsp = "+id+" ");
		sql.append("and sp.id != "+id+" ");
		sql.append("order by rand() ");
		sql.append("limit 0,3 ");
		return sql;
	}
	public List<SanphamDTO> GetDataSanphamLienQuan(int id){
		List<SanphamDTO> list = new ArrayList<SanphamDTO>();
		String sql = sqlGetDataSanphamLienQuan(id).toString();
		list = _jdbcTemplate.query(sql, new MapperSanphamDTO());
		return list;
	}
	//=================================================================//
	//Giỏ hàng
	private String SqlProductByID(long id) {
		StringBuffer sql = sqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND sp.id = " + id + " ");
		sql.append("LIMIT 1 ");
		return sql.toString();
	}
	
	public SanphamDTO FindProductByID(long id) {
		String sql = SqlProductByID(id);
		SanphamDTO product = _jdbcTemplate.queryForObject(sql, new MapperSanphamDTO());
		return product;
	}
}
