package finalproj.mvc.aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import finalproj.dto.Stu_LoggerVO;
import finalproj.mvc.dao.studentDao.Student_LoginLoggerDao;
// 학생 로거
@Component
@Aspect
public class Student_AspectLoginLogger {

	@Autowired
	private Student_LoginLoggerDao dao;
	
	@After("execution(String finalproj.mvc.controller.student.Student_JoinController.student_Login(..))")
	public void login(JoinPoint jp) {
		Object[] fd = jp.getArgs();
		Stu_LoggerVO slogvo = new Stu_LoggerVO();
		for(Object e : fd) {
			if(e instanceof HttpSession && ((HttpSession) e).getAttribute("sid") != null) {
				System.out.println("snum::::"+((HttpSession)e).getAttribute("snum"));
				slogvo.setSnum((int)((HttpSession)e).getAttribute("snum"));
			}
		}
		dao.login(slogvo);
		}
	
	@Before("execution(String finalproj.mvc.controller.student.Student_JoinController.student_Logout(..))")
	public void logout(JoinPoint jp) {
		Object[] fd = jp.getArgs();
		Stu_LoggerVO slogvo = new Stu_LoggerVO();
		for(Object e : fd) {
			if(e instanceof HttpSession && ((HttpSession) e).getAttribute("sid") != null) {
				slogvo.setSnum((int)((HttpSession)e).getAttribute("snum"));
			}
		}
		dao.logout(slogvo);
	}
}
