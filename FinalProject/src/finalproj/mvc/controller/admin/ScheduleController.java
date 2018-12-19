package finalproj.mvc.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import finalproj.dto.ScheduleVO;
import finalproj.mvc.dao.adminDao.AdminDaoInter;

@Controller
public class ScheduleController {
	
	@Autowired
	private AdminDaoInter adminDaoInter;

	@RequestMapping(value="scheduleForm")
	public String goSchedualForm() {		
		return "scheduleForm";
	}
	
	
	@RequestMapping(value="getScheduleDetail")
	public String scheduleDetailView(String day, Model m) {
		m.addAttribute("day",day);
		
		return "scheduleDetailView";
	}
}
