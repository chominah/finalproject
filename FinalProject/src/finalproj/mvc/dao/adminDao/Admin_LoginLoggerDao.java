package finalproj.mvc.dao.adminDao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalproj.dto.AdminVO;
import finalproj.dto.Admin_LoggerVO;

@Repository
public class Admin_LoginLoggerDao {

	@Autowired
	private SqlSessionTemplate ss;
	
	// 관리자 로그인
	public AdminVO loginCheck(AdminVO advo) {
		
		return ss.selectOne("admin_Join.loginChk",advo);
	}
	// 관리자 로거
	public void login(Admin_LoggerVO adlogvo) {
		ss.insert("Admin_LoginLogger.login",adlogvo);
	}
	
	public void logout(Admin_LoggerVO adlogvo) {
		ss.insert("Admin_LoginLogger.logout",adlogvo);
	}
}
