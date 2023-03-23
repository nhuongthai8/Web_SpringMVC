package webspringmvc.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webspringmvc.DAO.CartDAO;
import webspringmvc.DTO.CartDTO;

@Service
public class CartServiceImpl implements ICartService{
	@Autowired
	private CartDAO cartDAO = new CartDAO();

	@Override
	public HashMap<Integer, CartDTO> AddCart(int id, HashMap<Integer, CartDTO> cart) {
		return cartDAO.AddCart(id,cart);
	}

	@Override
	public HashMap<Integer, CartDTO> EditCart(int id, int soluong, HashMap<Integer, CartDTO> cart) {
		return cartDAO.EditCart(id,soluong,cart);
	}

	@Override
	public HashMap<Integer, CartDTO> DeleteCart(int id, HashMap<Integer, CartDTO> cart) {
		return cartDAO.DeleteCart(id,cart);
	}

	@Override
	public int TotalSoLuong(HashMap<Integer, CartDTO> cart) {
		return cartDAO.TotalSoLuong(cart);
	}

	@Override
	public double TotalTongGia(HashMap<Integer, CartDTO> cart) {
		return cartDAO.TotalTongGia(cart);
	}
}
