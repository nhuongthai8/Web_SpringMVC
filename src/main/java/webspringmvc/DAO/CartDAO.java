package webspringmvc.DAO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import webspringmvc.DTO.CartDTO;
import webspringmvc.DTO.SanphamDTO;

@Repository
public class CartDAO extends BaseDAO{
	
	@Autowired
	SanphamDAO sanphamDAO = new SanphamDAO();
	
	public HashMap<Integer,CartDTO> AddCart(int id, HashMap<Integer,CartDTO> cart ) {
		CartDTO itemCart = new CartDTO();
		SanphamDTO sanpham = sanphamDAO.FindProductByID(id);
		if(sanpham != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setSoluong(itemCart.getSoluong()+1);
			itemCart.setTongGia(sanpham.getGiaSP()*itemCart.getSanpham().getGiaSP());
		}else {
			itemCart.setSanpham(sanpham);
			itemCart.setSoluong(1);
			itemCart.setTongGia(sanpham.getGiaSP());
		}
		cart.put(id,itemCart);
		return cart;
	}
	
	public HashMap<Integer,CartDTO> EditCart(int id, int soluong, HashMap<Integer,CartDTO> cart ) {
		if(cart==null) {
			return cart;
		}
		CartDTO itemCart = new CartDTO();
		if(cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setSoluong(soluong);
			double totalPrice = soluong*itemCart.getSanpham().getGiaSP();
			itemCart.setTongGia(totalPrice);
		}
		cart.put(id,itemCart);
		return cart;
	}
	
	public HashMap<Integer,CartDTO> DeleteCart(int id, HashMap<Integer,CartDTO> cart ) {
		if(cart==null) {
			return cart;
		}
		if(cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}
	
	public int TotalSoLuong(HashMap<Integer,CartDTO> cart ) {
		int totalSoluong = 0; 
		for(Map.Entry<Integer,CartDTO> itemCart: cart.entrySet()) {
			totalSoluong += itemCart.getValue().getSoluong();
		}
		return totalSoluong;
	}
	
	public double TotalTongGia(HashMap<Integer,CartDTO> cart ) {
		int totalTonggia = 0; 
		for(Map.Entry<Integer,CartDTO> itemCart: cart.entrySet()) {
			totalTonggia += itemCart.getValue().getTongGia();
		}
		return totalTonggia;
	}
}
