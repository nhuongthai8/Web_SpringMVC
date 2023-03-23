package webspringmvc.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webspringmvc.Entities.Loaisanpham;
import webspringmvc.Entities.Nhaphanphoi;
import webspringmvc.DAO.LoaisanphamDAO;
import webspringmvc.DAO.NhaphanphoiDAO;
import webspringmvc.DAO.SanphamDAO;
import webspringmvc.DTO.SanphamDTO;

@Service
public class HomeServiceImpl implements IHomeService{
	@Autowired
	private SanphamDAO sanphamDAO;
	@Autowired
	private LoaisanphamDAO loaisanphamDAO;
	@Autowired
	private NhaphanphoiDAO nhaphanphoiDAO;
	
	@Override
	public List<SanphamDTO> GetDataAllSanpham(){
		List<SanphamDTO> listsanphams = sanphamDAO.GetDataAllSanpham();
		return listsanphams;
	}
	@Override
	public List<SanphamDTO> GetDataSanphamHighlight(){
		List<SanphamDTO> listsanphams = sanphamDAO.GetDataSanphamHighlight();
		return listsanphams;
	}
	
	@Override
	public List<Nhaphanphoi> GetDataNhaphanphoi(){
		return nhaphanphoiDAO.GetDataNhaphanphoi();
	}
	
	@Override
	public List<Loaisanpham> GetDataLoaisanpham(){
		return loaisanphamDAO.GetDataLoaisanpham();
	}
	
	@Override
	public List<SanphamDTO> GetDataSanphams() {
		List<SanphamDTO> listsanphams = sanphamDAO.GetDataSanphams();
		return listsanphams;
	}
}
