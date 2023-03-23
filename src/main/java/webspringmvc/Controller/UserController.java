package webspringmvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webspringmvc.Entities.Users;
import webspringmvc.Service.User.AccountServiceImpl;


@Controller
public class UserController extends BaseController{
	@Autowired
	AccountServiceImpl accountService = new AccountServiceImpl();
	
	//======================================================
	//đăng ký
	@RequestMapping(value= {"/Dangky"}, method = RequestMethod.GET)
	public ModelAndView Register() {
		_mvShare.setViewName("user/taikhoan/dangky");
		_mvShare.addObject("dangkyuser", new Users());
		return _mvShare;
	}
	@RequestMapping(value= {"/Dangky"}, method = RequestMethod.POST)
	public ModelAndView CreateAcc(@ModelAttribute("dangkyuser") Users dangkyuser) {
		int count = accountService.AddAccount(dangkyuser);
		if(count>0) {
			_mvShare.addObject("status","Đăng ký tài khoản thành công!");
		}else {
			_mvShare.addObject("status","Đăng ký tài khoản thất bại!");
		}
		_mvShare.addObject("status",true);
		_mvShare.setViewName("user/taikhoan/dangky");
		return _mvShare;
	}
	
	//======================================================
	//đăng nhập
	
	@RequestMapping(value= {"/Dangnhap"}, method = RequestMethod.GET)
	public ModelAndView Login() {
		_mvShare.setViewName("user/taikhoan/dangnhap");
		_mvShare.addObject("dangnhapuser", new Users());
		return _mvShare;
	}
	
	@RequestMapping(value= {"/Dangnhap"}, method = RequestMethod.POST)
	public ModelAndView LoginAccount(HttpSession session ,@ModelAttribute("dangnhapuser") Users dangnhapuser) {
		dangnhapuser = accountService.CheckAccount(dangnhapuser);
		if(dangnhapuser!=null) {
			_mvShare.setViewName("redirect:trangchu");
			session.setAttribute("Logininfo",dangnhapuser);
		}else {
			_mvShare.addObject("status","Đăng nhập thất bại!");
		}
		return _mvShare;
	}
	
	//======================================================
	//đăng nhập
	@RequestMapping(value= {"/Dangxuat"}, method = RequestMethod.GET)
	public String Logout(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("Logininfo");
		return "redirect:"+request.getHeader("Referer");
	}
}
