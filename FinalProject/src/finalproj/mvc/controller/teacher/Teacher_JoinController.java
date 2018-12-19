package finalproj.mvc.controller.teacher;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import finalproj.dto.CertVO;
import finalproj.dto.ClassVO;
import finalproj.dto.JobkeywordVO;
import finalproj.dto.StudentVO;
import finalproj.dto.TeacherVO;
import finalproj.mvc.dao.teacherDao.Teacher_JoinDao;
import finalproj.mvc.dao.teacherDao.Teacher_LoginLoggerDao;
@Controller
public class Teacher_JoinController {
	
	@Autowired
	Teacher_LoginLoggerDao dao;
	
	@Autowired
	Teacher_JoinDao joindao;
	
	@RequestMapping(value="/teacher_Login")
	public String login() {
		return"teacher_Login";
	}
	
	// 강사 로그인 
	@PostMapping("/teacher_loginProcess")
	public String teacher_Login(TeacherVO tvo,HttpSession ss) {
		TeacherVO map = dao.loginCheck(tvo);
		if(map == null) {
			return "Denied";
		}else {
			ss.setAttribute("tid", map.getTid());
			ss.setAttribute("tname", map.getTname());
			ss.setAttribute("tnum", map.getTnum());
		}
		return "teacher_LoginInfo";
	}
	
	//강사 로그아웃
	@GetMapping("/teacher_logout")
	public String teacher_Logout(HttpSession ss) {
		ss.removeAttribute("tid");
		ss.removeAttribute("tname");
		ss.removeAttribute("tnum");
		return "Logout";
	}
	
	
	@GetMapping("/Teacher_Join")
	public String Student_Join(Model m) {
		
		return "Teacher_Join";
	}
	
	// 강사 회원가입
	@PostMapping("/teacherjoin")
	public String Teacher_Join(TeacherVO tvo, Model m) {
		joindao.joinTeacher(tvo);
		m.addAttribute("tvo",tvo);
	
		return "index";
	}
	
	// teacher_myInfo  강사 내 정보
		@GetMapping(value="/teacher_myInfo")
		public String teacher_myInfo(Model m, TeacherVO tvo) {
			tvo = joindao.teacher_MyInfo();
			System.out.println("전화번호 : "+tvo.getTphone());
			m.addAttribute("tvo",tvo);
			return"teacher_myInfo";
		}
		
		// teacher_myInfo_modify_btn 강사 내정보 수정 버튼
		@GetMapping(value="/teacher_myInfo_modify_btn")
		public String teacher_myInfo_modify_btn(Model m) {
			TeacherVO tvo = new TeacherVO();
			tvo = joindao.teacher_MyInfo();
			m.addAttribute("tvo",tvo);
			
			return "teacher_myInfo_modify";
		}
		
		// teacher_myInfo_modify 강사 회원 수정
		@RequestMapping(value="/teacher_myInfo_modify")
		public String teacher_myInfo_modify( Model m, TeacherVO tvo){
			joindao.teacher_Modify(tvo);
			m.addAttribute("tvo",tvo);
					
					return "main";
				}
}
