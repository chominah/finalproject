package finalproj.mvc.dao.studentDao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalproj.dto.CertVO;
import finalproj.dto.ClassVO;
import finalproj.dto.JobkeywordVO;
import finalproj.dto.StudentVO;
import javassist.compiler.ast.Keyword;

@Repository
public class Student_JoinDao implements Student_JoinInter{

	@Autowired
	private SqlSessionTemplate ss;
	
	// 학생 회원가입
	@Override
	public void joinStudent(StudentVO svo,String crname, String cname) {
		svo.setCnum(ss.selectOne("student.cname",cname));
		svo.setScert(ss.selectOne("student.scertname",crname));
		ss.insert("student.join",svo);
		
	}
	
	// 학생 아이디 중복검사
	@Override
	public int idChk(String sid) {
		System.out.println("sid : "+sid);
		return ss.selectOne("student.idChk",sid);
	}
	
	// 학생 로그인
	@Override
	public StudentVO loginCheck(StudentVO svo) {
		
		return ss.selectOne("student.loginChk",svo);
	}

	// 학생 내 정보
	@Override
	public CertVO MyInfo() {
		CertVO crvo = ss.selectOne("student.myInfo");
		System.out.println("id : "+crvo.getMyInfo().getSid());
		return crvo;
	}

	// 학생 내 정보 수정
	@Override
	public void Modify(StudentVO svo, String crname) {
		
		System.out.println("scert:"+svo.getScert());
		
		svo.setScert(ss.selectOne("student.modify_scertname",crname));
		
		
		
		ss.update("student.myInfo_modify",svo);
		
		System.out.println("crname : "+crname);
		/*System.out.println("cname : "+cname);*/
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
		System.out.println("keyword : "+svo.getKeyword());
	}

	// keyword
	@Override
	public List<JobkeywordVO> getkeywordList() {
		List<JobkeywordVO> keylist = ss.selectList("student.keywordAllList");
		return keylist;
	}

	// 자격증
	@Override
	public List<CertVO> getcertList() {
		List<CertVO> certlist = ss.selectList("student.certAllList");
		return certlist;
	}

	// class
	@Override
	public List<ClassVO> getclassList() {
		List<ClassVO> classlist = ss.selectList("student.classAllList");
		return classlist;
	}
	
	
	


}
