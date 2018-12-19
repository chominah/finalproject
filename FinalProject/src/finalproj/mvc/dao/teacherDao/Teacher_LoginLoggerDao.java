package finalproj.mvc.dao.teacherDao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalproj.dto.TeacherVO;
import finalproj.dto.Teacher_LoggerVO;

@Repository
public class Teacher_LoginLoggerDao {

	@Autowired
	private SqlSessionTemplate ss;
	
	// 강사 로그인
	public TeacherVO loginCheck(TeacherVO tvo) {
		
		return ss.selectOne("teacher_teacherboard.loginChk",tvo);
	}
	// 강사 로거
	public void login(Teacher_LoggerVO tlogvo) {
		ss.insert("Teacher_LoginLogger.login",tlogvo);
	}
	
	public void logout(Teacher_LoggerVO tlogvo) {
		ss.insert("Teacher_LoginLogger.logout",tlogvo);
	}
}
