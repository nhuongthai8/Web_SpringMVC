package webspringmvc.Controller;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import webspringmvc.Service.User.HomeServiceImpl;

@Controller
public class BaseController {
	@Autowired
	HomeServiceImpl _homeService;
	public ModelAndView _mvShare = new ModelAndView();
	@PostConstruct
	public ModelAndView Init() {
		_mvShare.addObject("loaisanpham",_homeService.GetDataLoaisanpham());
		_mvShare.addObject("nhaphanphoi",_homeService.GetDataNhaphanphoi());
		return _mvShare;
	}
}
