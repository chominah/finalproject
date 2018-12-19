package finalproj.mvc.controller.student;

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
import finalproj.mvc.dao.studentDao.Student_JoinInter;

@Controller
public class Student_JoinController {

	@Autowired
	Student_JoinInter inter;
	
	
	@GetMapping("/Student_Join")
	public String Student_Join(Model m) {
		List<JobkeywordVO> keylist = inter.getkeywordList();
		List<CertVO> certlist = inter.getcertList();
		List<ClassVO> classlist = inter.getclassList();
	/*	for(JobkeywordVO e : keylist) {
			System.out.println("keylist :::"+e.getKeyword());
		}*/
		m.addAttribute("keylist",keylist);
		m.addAttribute("certlist",certlist);
		m.addAttribute("classlist",classlist);
		return "Student_Join";
	}
	
	//학생 회원가입
	@PostMapping("/memberjoin")
	public String Student_Join(StudentVO svo, Model m, String crname, String cname) {
		
		inter.joinStudent(svo, crname, cname);
		m.addAttribute("svo",svo);
	
		return "index";
	}
	
	// student_myInfo 학생 내 정보 
	@GetMapping(value="/myInfo")
	public String student_myInfo(Model m, StudentVO svo) {
		CertVO crvo = new CertVO();
		crvo = inter.MyInfo();
		m.addAttribute("crvo",crvo);
		return"student_myInfo";
	}
	
	// student_myInfo_modify_btn 학생 내 정보 수정 버튼
	@GetMapping(value="/student_myInfo_modify_btn")
	public String student_myInfo_modify_btn(Model m) {
		CertVO crvo = new CertVO();
		List<JobkeywordVO> keylist = inter.getkeywordList();
		List<CertVO> certlist = inter.getcertList();
		
		crvo = inter.MyInfo();
		m.addAttribute("keylist",keylist);
		m.addAttribute("certlist",certlist);
		m.addAttribute("crvo",crvo);
		
		return "student_myInfo_modify";
	}
	
	// student_myInfo_modify 학생 회원정보 수정
	@RequestMapping(value="/student_myInfo_modify")
	public String student_myInfo_modify( Model m, StudentVO svo, String crname){
		
				inter.Modify(svo, crname);
				
			/*	System.out.println("=========================");
				System.out.println("crname : "+crname);
				System.out.println("cname : "+cname);
				System.out.println("name : "+svo.getSname());
				System.out.println("id : "+svo.getSid());
				System.out.println("pwd : "+svo.getSpwd());
				System.out.println("birth : "+svo.getSbirth());
				System.out.println("spost : "+svo.getSpost());
				System.out.println("saddr1 : "+svo.getSaddr1());
			System.out.println("saddr2 : "+svo.getSaddr2());
				System.out.println("phone : "+svo.getSphone());
				System.out.println("email : "+svo.getSmail());
			System.out.println("major : "+svo.getSmajor());
				System.out.println("gender : "+svo.getSgender());
				System.out.println("keyword : "+svo.getKeyword());*/
				
				m.addAttribute("svo",svo);
				
				return "main";
			}
	
	
	@RequestMapping(value="/student_Login")
	public String login() {
		return"student_Login";
	}
	
	// 학생 로그인 
	@PostMapping("/stu_loginProcess")
	public String student_Login(StudentVO svo,HttpSession ss) {
		StudentVO map = inter.loginCheck(svo);
		if(map == null) {
			return "Denied";
		}else {
			ss.setAttribute("sid", map.getSid());
			ss.setAttribute("sname", map.getSname());
			ss.setAttribute("snum", map.getSnum());
		}
		return "student_LoginInfo";
	}
	
	// 학생 로그아웃
	@GetMapping("/student_logout")
	public String student_Logout(HttpSession ss) {
		ss.removeAttribute("sid");
		ss.removeAttribute("sname");
		ss.removeAttribute("snum");
		return "Logout";
	}

}
