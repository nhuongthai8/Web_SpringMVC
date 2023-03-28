package webspringmvc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webspringmvc.DAO.AdminDAO;
import webspringmvc.Entities.MapperNhaphanphoi;
import webspringmvc.Entities.Nhaphanphoi;
import webspringmvc.Entities.Users;
import webspringmvc.Entities.Loaisanpham;

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

//	@RequestMapping("/nppform")
//	public String showform(Model m) {
//		m.addAttribute("command", new NhaphanphoiDAO());
//		return "nppform";
//	}
//
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public String save(@ModelAttribute("npp") NhaphanphoiDAO npp) {
//		nppDAO.save(npp);
//		return "redirect:/viewnpp";
//	}
//	
//	@RequestMapping("/viewemp")    
//    public String viewemp(Model m){    
//        List<MapperNhaphanphoi> list= nppDAO.getEmployees();    
//        m.addAttribute("list",list);  
//        return "viewemp";    
//    }
//	
//	@RequestMapping(value="/editemp/{id}")    
//    public String edit(@PathVariable int id, Model m){    
//		MapperNhaphanphoi npp= nppDAO.getEmpById(id);    
//        m.addAttribute("command", npp);  
//        return "empeditform";    
//    }
//	
//	@RequestMapping(value="/editsave",method = RequestMethod.POST)    
//    public String editsave(@ModelAttribute("emp") MapperNhaphanphoi npp){    
//		nppDAO.update(npp);    
//        return "redirect:/viewemp";    
//    }    
//    /* It deletes record for the given id in URL and redirects to /viewemp */    
//    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)    
//    public String delete(@PathVariable int id){    
//    	nppDAO.delete(id);    
//        return "redirect:/viewemp";    
//    }

    
    
    
    
	@RequestMapping("/quan-tri/nhaphanphoi")
	public ModelAndView Nhaphanphoi(@ModelAttribute("npp") Nhaphanphoi npp,Model m) {
		List<Nhaphanphoi> list= adminDAO.getNhaphanhoi();    
        m.addAttribute("list",list);
		_mvShare.setViewName("admin/nhaphanphoi");
		return _mvShare;
	}
	
	// ==========================================================
	// loại sản phẩm

	@RequestMapping("/quan-tri/loaisanpham")
	public ModelAndView Loaisanpham(@ModelAttribute("lsp") Loaisanpham lsp,Model m) {
		List<Loaisanpham> list= adminDAO.getLoaisanpham();    
        m.addAttribute("list",list);
		_mvShare.setViewName("admin/loaisanpham");
		return _mvShare;
	}
	
	// ==========================================================
	// khách hàng
	
	@RequestMapping("/quan-tri/khachhang")
	public ModelAndView Khachhang(@ModelAttribute("kh") Users kh,Model m) {
		List<Users> list= adminDAO.getKhachhang();    
        m.addAttribute("list",list);
		_mvShare.setViewName("admin/khachhang");
		return _mvShare;
	}
	
}
