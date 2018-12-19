package finalproj.mvc.dao.studentDao;

import java.util.List;

import finalproj.dto.ChatVO;
import finalproj.dto.StgroupVO;
import finalproj.dto.StudentVO;


public interface Student_Inter {
	
	public void addgroup(String[] glist);

	public List<StudentVO> getstudentlist();
	
	public List<StgroupVO> getSnameToSnum(List<StudentVO> svo);
}
