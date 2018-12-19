package finalproj.mvc.dao.studentDao;

import java.util.List;

import finalproj.dto.TboardVO;
import finalproj.dto.TeacherVO;

public interface Student_MainInter {

	public List<TeacherVO> listTBoard();
	public TeacherVO detailBoard(int num);
	public List<TboardVO> ExcelList();
}