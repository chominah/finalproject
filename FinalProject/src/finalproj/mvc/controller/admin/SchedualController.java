package finalproj.mvc.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SchedualController {

	@RequestMapping(value="schedualForm")
	public String goSchedualForm() {
	
		return "schedualForm";
		
	}
}
