package finalproj.mvc.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import finalproj.dto.Admin_LoggerVO;
import finalproj.mvc.dao.adminDao.Admin_LoginLoggerDao;
/* 관리자 로거*/
@Component
@Aspect
public class Admin_AspectLoginLogger {

	@Autowired
	private Admin_LoginLoggerDao dao;
	
	/*@Around("execution(String finalproj.mvc.controller.admin.Admin_JoinController(..))")
	public ModelAndView loginLogger(ProceedingJoinPoint jp) {
		Object[] fd = jp.getArgs();
		ModelAndView rpath = null;
		String methodName = jp.getSignature().getName();
		if(methodName.equals("admin_loginProcess")) {
			try {
				Admin_LoggerVO adlogvo = new Admin_LoggerVO();
				rpath = (ModelAndView) jp.proceed();
				if(fd[0] instanceof HttpSession && fd[1] instanceof HttpServletRequest) {
					HttpSession session = (HttpSession) fd[0];
					HttpServletRequest request = (HttpServletRequest) fd[1];
					String adid = (String) session.getAttribute("adid");
						if(adid == null) { // 로그인 했지만 세션의 값이 없을경우
							
						}else {
							adlogvo.setStat(1);
							dao
						}
				}else if(methodName.equals("admin_logout")) {
					try {
						Admin_LoggerVO adlogvo = new Admin_LoggerVO();
						if(fd[0] instanceof HttpSession && fd[1] instanceof HttpServletRequest) {
							HttpSession session = (HttpSession) fd[0];
							HttpServletRequest request = (HttpServletRequest) fd[1];
							String adid = (String) session.getAttribute("adid");
							if(adid == null) { // 로그인 했지만 세션의 값이 없을경우
								
							}else {
								adlogvo.setStat(0);
							}
							rpath = (ModelAndView) jp.proceed();
						}
					} catch (Throwable e) {
						e.printStackTrace(e);
					}
				}
			} catch (Throwable e) {
				e.printStackTrace(e);
			
			}
			System.out.println("insert::::::::::::");
			return rpath;
		}
	}*/
	
	@After("execution(String finalproj.mvc.controller.admin.Admin_JoinController.admin_Login(..))")
	public void login(JoinPoint jp) {
		Object[] fd = jp.getArgs();
		Admin_LoggerVO adlogvo = new Admin_LoggerVO();
		for(Object e : fd) {
			if(e instanceof HttpSession && ((HttpSession) e).getAttribute("adid") != null) {
				System.out.println("adnum::::"+((HttpSession)e).getAttribute("adnum"));
				adlogvo.setAdnum((int)((HttpSession)e).getAttribute("adnum"));
			}
		}
		dao.login(adlogvo);
		}
	
	@Before("execution(String finalproj.mvc.controller.admin.Admin_JoinController.admin_Logout(..))")
	public void logout(JoinPoint jp) {
		Object[] fd = jp.getArgs();
		Admin_LoggerVO adlogvo = new Admin_LoggerVO();
		for(Object e : fd) {
			if(e instanceof HttpSession && ((HttpSession) e).getAttribute("adid") != null) {
				adlogvo.setAdnum((int)((HttpSession)e).getAttribute("adnum"));
			}
		}
		dao.logout(adlogvo);
	}
}
