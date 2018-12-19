package finalproj.mvc.dao.teacherDao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalproj.dto.TeacherVO;

@Repository
public class Teacher_JoinDao{

	@Autowired
	private SqlSessionTemplate ss;
	
	// 강사 회원가입
	public void joinTeacher(TeacherVO tvo) {
		ss.insert("teacher.join",tvo);
		
	}
	
	// 강사 아이디 중복검사
	public int idChk(String tid) {
		System.out.println("tid : "+tid);
		return ss.selectOne("teacher.idChk",tid);
	}

	// 강사_내 정보
	public TeacherVO teacher_MyInfo() {
		TeacherVO tvo = ss.selectOne("teacher.myInfo");
		return tvo;
	}

	// 강사_내 정보 수정
	public void teacher_Modify(TeacherVO tvo) {
	
		ss.update("teacher.myInfo_modify",tvo);

	}

}
