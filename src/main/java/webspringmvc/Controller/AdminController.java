package webspringmvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	@RequestMapping("/quan-tri")
	public String IndexAdmin() {
		return "admin/index";
	}
}
