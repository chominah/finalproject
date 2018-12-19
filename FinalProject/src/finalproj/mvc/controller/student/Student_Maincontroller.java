package finalproj.mvc.controller.student;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import finalproj.dto.StudentVO;
import finalproj.mvc.dao.studentDao.Student_Inter;

@Controller
public class Student_Maincontroller {

	@Autowired
	public Student_Inter sinter;
	
	@RequestMapping(value = "/")
	public String main() {

		return "my_main";
	}
	
	@RequestMapping(value = "/list")
	public String Studentlist(Model m) {
		List<StudentVO> slist = new ArrayList<>();
		slist = sinter.getstudentlist();
		m.addAttribute("slist", slist);
		return "teamboard";
	}

	@RequestMapping(value = "/makegroup")
	public String Studentgroup(Model m, HttpServletRequest req, HttpSession session) {
		String[] glist = req.getParameterValues("grouplist");
		//glist[glist.length]=(String) session.getAttribute("sname");
		sinter.addgroup(glist);

		return "my_main";

	}

	@RequestMapping(value = "/chat")
	public String chat() {
		return "chat";
	}

}
