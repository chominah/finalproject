package finalproj.mvc.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalproj.dto.CpfeedVO;
import finalproj.dto.ResumeVO;

@Repository
public class AdminDao {

	@Autowired
	private SqlSessionTemplate ss;

	// ---- feedback company start ----
	// feedback company list 조회
	public List<Map<String, Object>> fback_CompanyList() {
		List<Map<String, Object>> list = ss.selectList("fback.compony");
		return list;
	}
	
	// feedback company별 상세보기 페이지
	public String fback_contentView(int cpfnum) {
		return ss.selectOne("fback.content",cpfnum);
	}
	
	// feedback company 피드백 내용 업데이트
	public void fback_up(CpfeedVO cpfvo) {
		ss.update("fback.upcontent", cpfvo);
	}
	// ---- feedback company end ----
	
	// ---- feedback resume&portfolio start----
	// 모든 feedback resume list 조회
	public List<Map<String, Object>> fback_Resume(){
		List<Map<String, Object>> list = ss.selectList("fback.resume");
		return list;
	}
	
	// 선택한 학생에 대한 feedback resume list 조회
	public List<ResumeVO> fback_Resume_fileview(int snum){
		List<ResumeVO> list = ss.selectList("resume_fileview",snum);
		return list;
	}
	
	// feedback resume 파일  업데이트
	public void rfile_up(ResumeVO rvo) {
		ss.update("rfile_update",rvo);
	}
	// ---- feedback resume&portfolio end ----
}
