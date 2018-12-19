package finalproj.mvc.dao.adminDao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalproj.dto.AdminVO;
import finalproj.dto.TeacherVO;

@Repository
public class Admin_JoinDao{

	@Autowired
	private SqlSessionTemplate ss;
	
	// 회원가입
	public void joinAdmin(AdminVO advo) {
		ss.insert("admin_Join.join",advo);
		
	}
	
	// 아이디 중복검사
	public int idChk(String adid) {
		System.out.println("adid : "+adid);
		return ss.selectOne("admin_Join.idChk",adid);
	}

	// 관리자_내 정보
	public AdminVO admin_MyInfo() {
		AdminVO advo = ss.selectOne("admin_Join.myInfo");
		return advo;
	}

	//관리자_ 내 정보 수정
		public void admin_Modify(AdminVO advo) {
		
			ss.update("admin_Join.myInfo_modify",advo);

		}

}
