package webspringmvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController extends BaseController{

	//=================================================================//
	
	@RequestMapping(value = {"/","/trangchu"})
	public ModelAndView Index() {
		_mvShare.addObject("sanpham",_homeService.GetDataSanphams());
		_mvShare.addObject("sanphamhighlight",_homeService.GetDataSanphamHighlight());
		_mvShare.setViewName("user/index");
		return _mvShare;
	}
	
	//=================================================================//
		
	@RequestMapping("/gioithieu")
	public String GioiThieu() {
		return "user/gioithieu";
	}
	
	@RequestMapping("/lienhe")
	public ModelAndView LienHe() {
		ModelAndView mv = new ModelAndView("user/lienhe");
		return mv;
	}
	@RequestMapping("/tintuc")
	public ModelAndView TinTuc() {
		_mvShare.setViewName("user/tintuc");
		return _mvShare;
	}
}