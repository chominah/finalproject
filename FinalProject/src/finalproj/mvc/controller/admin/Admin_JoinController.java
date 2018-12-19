package finalproj.mvc.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import finalproj.dto.AdminVO;
import finalproj.dto.TeacherVO;
import finalproj.mvc.dao.adminDao.Admin_JoinDao;
import finalproj.mvc.dao.adminDao.Admin_LoginLoggerDao;
@Controller
public class Admin_JoinController {
	
	@Autowired
	Admin_LoginLoggerDao dao;
	
	@Autowired
	Admin_JoinDao joindao;
	
	@RequestMapping(value="/admin_Login")
	public String login() {
		return"admin_Login";
	}
	
	// 관리자 로그인 
	@PostMapping("/admin_loginProcess")
	public String admin_Login(AdminVO advo,HttpSession ss) {
		AdminVO map = dao.loginCheck(advo);
		if(map == null) {
			return "Denied";
		}else {
			ss.setAttribute("adid", map.getAdid());
			ss.setAttribute("adname", map.getAdname());
			ss.setAttribute("adnum", map.getAdnum());
		}
		return "admin_LoginInfo";
	}
	
	//관리자 로그아웃
	@GetMapping("/admin_logout")
	public String admin_Logout(HttpSession ss) {
		ss.removeAttribute("adid");
		ss.removeAttribute("adname");
		ss.removeAttribute("adnum");
		return "Logout";
	}
	
	@GetMapping("/Admin_Join")
	public String Student_Join(Model m) {
		
		return "Admin_Join";
	}
	
	// 관리자 회원가입
	@PostMapping("/adminjoin")
	public String Admin_Join(AdminVO advo, Model m) {
		joindao.joinAdmin(advo);
		m.addAttribute("advo",advo);
	
		return "index";
	}
	
	// admin_myInfo  관리자 내 정보
			@GetMapping(value="/admin_myInfo")
			public String admin_myInfo(Model m, AdminVO advo) {
				advo = joindao.admin_MyInfo();
				m.addAttribute("advo",advo);
				
				return"admin_myInfo";
			}
			
			// admin_myInfo_modify_btn 버튼
			@GetMapping(value="/admin_myInfo_modify_btn")
			public String admin_myInfo_modify_btn(Model m) {
				AdminVO advo = new AdminVO();
				advo = joindao.admin_MyInfo();
				m.addAttribute("advo",advo);
				
				return "admin_myInfo_modify";
			}
			
			// admin_myInfo_modify 관리자 회원 수정
			@RequestMapping(value="/admin_myInfo_modify")
			public String admin_myInfo_modify( Model m, AdminVO advo){
				joindao.admin_Modify(advo);
				m.addAttribute("advo",advo);
						
						return "main";
					}
}
