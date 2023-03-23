package webspringmvc.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import webspringmvc.Entities.Loaisanpham;
import webspringmvc.Entities.MapperLoaisanpham;


@Repository
public class LoaisanphamDAO extends BaseDAO{
	public List<Loaisanpham> GetDataLoaisanpham(){
		List<Loaisanpham> list = new ArrayList<Loaisanpham>();
		String sql ="SELECT * FROM `loaisanpham`";
		list = _jdbcTemplate.query(sql, new MapperLoaisanpham());
		return list;
	}
}
