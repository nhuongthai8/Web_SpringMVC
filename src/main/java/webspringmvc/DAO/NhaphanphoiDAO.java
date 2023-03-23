package webspringmvc.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import webspringmvc.Entities.MapperNhaphanphoi;
import webspringmvc.Entities.Nhaphanphoi;


@Repository
public class NhaphanphoiDAO extends BaseDAO{
	public List<Nhaphanphoi> GetDataNhaphanphoi(){
		List<Nhaphanphoi> list = new ArrayList<Nhaphanphoi>();
		String sql ="SELECT * FROM `nhaphanphoi`";
		list = _jdbcTemplate.query(sql, new MapperNhaphanphoi());
		return list;
	}
}
