package webspringmvc.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webspringmvc.DTO.SanphamDTO;
import webspringmvc.Entities.Loaisanpham;
import webspringmvc.Entities.Nhaphanphoi;

@Service
public interface IHomeService {
	@Autowired
	public List<SanphamDTO> GetDataSanphams();
	@Autowired
	public List<SanphamDTO> GetDataAllSanpham();
	@Autowired
	public List<SanphamDTO> GetDataSanphamHighlight();
	@Autowired
	public List<Loaisanpham> GetDataLoaisanpham();
	@Autowired
	public List<Nhaphanphoi> GetDataNhaphanphoi();
}
