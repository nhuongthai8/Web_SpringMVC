package webspringmvc.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webspringmvc.DTO.SanphamDTO;

@Service
public interface ILspService {
	@Autowired
	public List<SanphamDTO> GetDataSanphamTLid(int id);
	@Autowired
	public List<SanphamDTO> GetDataSanphamTLpaginate(int id,int start, int end);
//	@Autowired
//	public List<SanphamDTO> GetDataSanphamTNPPid(int id);
//	@Autowired
//	public List<SanphamDTO> GetDataSanphamTNPPpaginate(int start, int end);
	
}
