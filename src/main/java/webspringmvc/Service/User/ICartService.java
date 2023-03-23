package webspringmvc.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webspringmvc.DTO.CartDTO;

@Service
public interface ICartService {
	@Autowired
	public HashMap<Integer,CartDTO> AddCart(int id, HashMap<Integer,CartDTO> cart );
	@Autowired
	public HashMap<Integer,CartDTO> EditCart(int id, int soluong, HashMap<Integer,CartDTO> cart );
	@Autowired
	public HashMap<Integer,CartDTO> DeleteCart(int id, HashMap<Integer,CartDTO> cart );
	@Autowired
	public int TotalSoLuong(HashMap<Integer,CartDTO> cart );
	@Autowired
	public double TotalTongGia(HashMap<Integer,CartDTO> cart );
}
