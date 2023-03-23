package webspringmvc.Service.User;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webspringmvc.DTO.SanphamDTO;

@Service
public interface IProductService {
	@Autowired
	public SanphamDTO GetSPid(int id);
	@Autowired
	public List<SanphamDTO> GetDataSanphamTLLienQuan(int id);
}
