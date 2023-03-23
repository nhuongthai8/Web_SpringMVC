package webspringmvc.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webspringmvc.DAO.SanphamDAO;
import webspringmvc.DTO.SanphamDTO;

@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
	SanphamDAO sanphamDAO = new SanphamDAO();
	
	public SanphamDTO GetSPid(int id) {
		List<SanphamDTO> listsp =  sanphamDAO.GetSPid(id);
		return listsp.get(0);
	}

	@Override
	public List<SanphamDTO> GetDataSanphamTLLienQuan(int id) {
		return sanphamDAO.GetDataSanphamLienQuan(id);
	}

}
