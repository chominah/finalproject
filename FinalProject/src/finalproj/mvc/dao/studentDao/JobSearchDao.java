package finalproj.mvc.dao.studentDao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalproj.dto.ClassVO;
import finalproj.dto.CplistVO;
import finalproj.dto.JobkeywordVO;

@Repository
public class JobSearchDao {

	@Autowired
	private SqlSessionTemplate ss;

	public List<JobkeywordVO> keywordmenu() {

		return ss.selectList("jobSearch.keywordmenu");
	}

	public List<CplistVO> cplocmenu() {

		return ss.selectList("jobSearch.cploc");
	}
    
	public List<ClassVO> cnamemenu() {

		return ss.selectList("jobSearch.classmenu");
	}
	
	public List<CplistVO> keywordList( Map<String, String> map) {
      
		return ss.selectList("jobSearch.keyword",map);
	}	
	
	public List<CplistVO> keywordTotal(Map<String, String> map) {
	      
		return ss.selectList("jobSearch.keywordView",map);
	}	
	
	public int getTotal(Map<String, String> map) {
	      
		return ss.selectOne("jobSearch.getCount",map);
	}	
	
	public List<CplistVO> jobinfo(int cpnum) {
	      
		return ss.selectList("jobSearch.jobinfo",cpnum);
	}	
	
	public List<CplistVO> mail(String ceomail) {
	      
		return ss.selectList("jobSearch.ceomail",ceomail);
	}	
	
}
