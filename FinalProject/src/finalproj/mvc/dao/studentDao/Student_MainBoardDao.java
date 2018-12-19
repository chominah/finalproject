package finalproj.mvc.dao.studentDao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import finalproj.dto.TboardVO;
import finalproj.dto.TeacherVO;

@Repository
public class Student_MainBoardDao implements Student_MainInter{
	
	@Autowired
	private SqlSessionTemplate ss;
	
	// mainboard
	@Override
	public List<TeacherVO> listTBoard() {
		List<TeacherVO> list = ss.selectList("student_main.mainlist");
		/*for(TeacherVO vo : list) {
		System.out.println("Tboard.Tdate : "+vo.getTboard());
		System.out.println("Tboard.Ttitle : "+vo.getTboard());
		}*/
		return list;
	}

	// mainboard_detail
	@Override
	public TeacherVO detailBoard(int num) {
		System.out.println("num1 : "+num);
		TeacherVO tvo = ss.selectOne("student_main.mainboard_detail", num);
		System.out.println("num2 : "+num);
		System.out.println("Tcontent : "+tvo.getTboard().getTbcontent());
		System.out.println("TFile : "+tvo.getTboard().getTbfile());
		return tvo;
	}

	// mainboard_detail 상세보기 엑셀 다운로드
	@Override
	public List<TboardVO> ExcelList() {
		return ss.selectList("student_main.ExcelList");
	}
}
