package webspringmvc.Controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webspringmvc.DTO.CartDTO;
import webspringmvc.Entities.Bills;
import webspringmvc.Entities.Users;
import webspringmvc.Service.User.BillServiceImpl;
import webspringmvc.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController{
	
	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();
	@Autowired
	private BillServiceImpl billsService = new BillServiceImpl();
	
	@RequestMapping(value="Giohang")
	public ModelAndView Cart() {
		_mvShare.setViewName("user/cart/giohang");
		return _mvShare;
	}
	
	
	@RequestMapping(value="AddCart/{id}")
	public String AddCart(HttpServletRequest request,HttpSession session, @PathVariable int id) {
		HashMap<Integer, CartDTO> cart = (HashMap<Integer, CartDTO>)session.getAttribute("Cart");
		if(cart==null) {
			cart = new HashMap<Integer, CartDTO>();
		}
		cart = cartService.AddCart(id,cart);
		session.setAttribute("Cart",cart);
		session.setAttribute("TotalSoLuong",cartService.TotalSoLuong(cart));
		session.setAttribute("TotalTongGia",cartService.TotalTongGia(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value="DeleteCart/{id}")
	public String DeleteCart(HttpServletRequest request,HttpSession session, @PathVariable int id) {
		HashMap<Integer, CartDTO> cart = (HashMap<Integer, CartDTO>)session.getAttribute("Cart");
		if(cart==null) {
			cart = new HashMap<Integer, CartDTO>();
		}
		cart = cartService.DeleteCart(id,cart);
		session.setAttribute("Cart",cart);
		session.setAttribute("TotalSoLuong",cartService.TotalSoLuong(cart));
		session.setAttribute("TotalTongGia",cartService.TotalTongGia(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value="EditCart/{id}/{quanty}")
	public String EditCart(HttpServletRequest request,HttpSession session, @PathVariable int id, @PathVariable int quanty) {
		HashMap<Integer, CartDTO> cart = (HashMap<Integer, CartDTO>)session.getAttribute("Cart");
		if(cart==null) {
			cart = new HashMap<Integer, CartDTO>();
		}
		cart = cartService.EditCart(id,quanty,cart);
		session.setAttribute("Cart",cart);
		session.setAttribute("TotalSoLuong",cartService.TotalSoLuong(cart));
		session.setAttribute("TotalTongGia",cartService.TotalTongGia(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	
	@RequestMapping(value="Thanhtoan", method = RequestMethod.GET)
	public ModelAndView CheckOut(HttpServletRequest request,HttpSession session) {
		_mvShare.setViewName("user/cart/thanhtoan");
		Bills bills = new Bills();
		Users loginInfo = (Users)session.getAttribute("Logininfo");
		if(loginInfo!=null) {
			bills.setDiaChi(loginInfo.getDiaChi());
			bills.setHoTen(loginInfo.getHoTen());
			bills.setUsername(loginInfo.getUsername());
		}
		_mvShare.addObject("bills", new Bills());
		return _mvShare;
	}
	
	@RequestMapping(value="Thanhtoan", method = RequestMethod.POST)
	public String CheckOutBill(HttpServletRequest request,HttpSession session, @ModelAttribute("bills") Bills bills) {
//		bills.setQuanty(Integer.parseInt((String)session.getAttribute("TotalSoLuong")));
//		bills.setTotal(Double.parseDouble((String)session.getAttribute("TotalTongGia")));
		
		bills.setQuanty(Integer.parseInt((String)session.getAttribute("TotalSoLuong").toString()));
		bills.setTotal(Double.parseDouble((String)session.getAttribute("TotalTongGia").toString()));
		
		if(billsService.AddBills(bills)>0) {
			HashMap<Integer,CartDTO> carts = (HashMap<Integer,CartDTO>)session.getAttribute("Cart");
			billsService.AddBillsDetail(carts);
		}
		session.removeAttribute("Cart");
		return "redirect:Giohang";
	}
	
}
