package webspringmvc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import webspringmvc.DAO.AdminDAO;
import webspringmvc.DTO.SanphamDTO;
import webspringmvc.Entities.Bills;
import webspringmvc.Entities.Loaisanpham;
import webspringmvc.Entities.Nhaphanphoi;
import webspringmvc.Entities.Users;

@Controller
public class AdminController extends BaseController {
	@RequestMapping("/quan-tri")
	public String IndexAdmin() {
		return "admin/index";
	}

	// ==========================================================
	// nhà phân phối
	@Autowired
	AdminDAO adminDAO = new AdminDAO();
	
	@RequestMapping("/quan-tri/nhaphanphoi")
	public ModelAndView Nhaphanphoi(@ModelAttribute("npp") Nhaphanphoi npp, Model m) {
		List<Nhaphanphoi> list = adminDAO.getNhaphanhoi();
		m.addAttribute("list", list);
		m.addAttribute("npp", new Nhaphanphoi());
		_mvShare.setViewName("admin/nhaphanphoi");
		return _mvShare;
	}

	// ==========================================================
	// loại sản phẩm

	@RequestMapping("/quan-tri/loaisanpham")
	public ModelAndView Loaisanpham(@ModelAttribute("lsp") Loaisanpham lsp, Model m) {
		List<Loaisanpham> list = adminDAO.getLoaisanpham();
		m.addAttribute("list", list);
		_mvShare.setViewName("admin/loaisanpham");
		return _mvShare;
	}

	// ==========================================================
	// khách hàng

	@RequestMapping("/quan-tri/khachhang")
	public ModelAndView Khachhang(@ModelAttribute("kh") Users kh, Model m) {
		List<Users> list = adminDAO.getKhachhang();
		m.addAttribute("list", list);
		_mvShare.setViewName("admin/khachhang");
		return _mvShare;
	}

	// ==========================================================
	// sản phẩm
	@RequestMapping("/quan-tri/sanpham")
	public ModelAndView Sanpham(@ModelAttribute("sp") SanphamDTO sp, Model m) {
		List<SanphamDTO> list = adminDAO.getSanpham();
		m.addAttribute("list", list);
		_mvShare.setViewName("admin/sanpham");
		return _mvShare;
	}

	// ==========================================================
	// đơn hàng
	@RequestMapping("/quan-tri/donhang")
	public ModelAndView Donhang(@ModelAttribute("bills") Bills bills, Model m) {
		List<Bills> list = adminDAO.getBills();
		m.addAttribute("list", list);
		_mvShare.setViewName("admin/bills");
		return _mvShare;
	}
	
}
