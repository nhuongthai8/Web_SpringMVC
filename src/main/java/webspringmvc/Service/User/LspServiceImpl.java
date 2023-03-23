package webspringmvc.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webspringmvc.DAO.SanphamDAO;
import webspringmvc.DTO.SanphamDTO;

@Service
public class LspServiceImpl implements ILspService {
	@Autowired
	SanphamDAO sanphamDAO;
	
	public List<SanphamDTO> GetDataSanphamTLid(int id) {
		return sanphamDAO.GetDataSanphamTLid(id);
	}
	
	public List<SanphamDTO> GetDataSanphamTLpaginate(int id,int start, int totalPage) {
		return sanphamDAO.GetDataSanphamTLpaginate(id ,start,totalPage);
	}

//	public List<SanphamDTO> GetDataSanphamTNPPid(int id) {
//		return sanphamDAO.GetDataSanphamTNPPid(id);
//	}
//
//	public List<SanphamDTO> GetDataSanphamTNPPpaginate(int start, int end) {
//		return sanphamDAO.GetDataSanphamTNPPpaginate(start,end);
//	}

}
