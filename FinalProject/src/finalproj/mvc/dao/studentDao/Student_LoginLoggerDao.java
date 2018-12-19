package finalproj.mvc.dao.studentDao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalproj.dto.Stu_LoggerVO;
@Repository
public class Student_LoginLoggerDao {

	@Autowired
	private SqlSessionTemplate ss;
	// 학생 로거
	public void login(Stu_LoggerVO slogvo) {
		ss.insert("Student_LoginLogger.login",slogvo);
	}
	
	public void logout(Stu_LoggerVO slogvo) {
		ss.insert("Student_LoginLogger.logout",slogvo);
	}
}
