package finalproj.mvc.aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import finalproj.dto.Teacher_LoggerVO;
import finalproj.mvc.dao.teacherDao.Teacher_LoginLoggerDao;
// 강사 로거
@Component
@Aspect
public class Teacher_AspectLoginLogger {

	@Autowired
	private Teacher_LoginLoggerDao dao;
	
	@After("execution(String finalproj.mvc.controller.teacher.Teacher_JoinController.teacher_Login(..))")
	public void login(JoinPoint jp) {
		Object[] fd = jp.getArgs();
		Teacher_LoggerVO tlogvo = new Teacher_LoggerVO();
		for(Object e : fd) {
			if(e instanceof HttpSession && ((HttpSession) e).getAttribute("tid") != null) {
				System.out.println("tnum::::"+((HttpSession)e).getAttribute("tnum"));
				tlogvo.setTnum((int)((HttpSession)e).getAttribute("tnum"));
			}
		}
		dao.login(tlogvo);
		}
	
	@Before("execution(String finalproj.mvc.controller.teacher.Teacher_JoinController.teacher_Logout(..))")
	public void logout(JoinPoint jp) {
		Object[] fd = jp.getArgs();
		Teacher_LoggerVO tlogvo = new Teacher_LoggerVO();
		for(Object e : fd) {
			if(e instanceof HttpSession && ((HttpSession) e).getAttribute("tid") != null) {
				tlogvo.setTnum((int)((HttpSession)e).getAttribute("tnum"));
			}
		}
		dao.logout(tlogvo);
	}
}
