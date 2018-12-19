package finalproj.mvc.dao.studentDao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalproj.dto.SboardVO;
import finalproj.dto.StudentVO;
import finalproj.dto.TboardVO;
import finalproj.dto.TeacherVO;

@Repository
public class Student_TeamBoardDao {
	
	@Autowired
	private SqlSessionTemplate ss;

	// Teamboard_write
	public void insert(SboardVO sbvo) {
		ss.insert("student_teamboard.wirte", sbvo);
	}
	
	// Teamboard
		public List<StudentVO> listSBoard() {
			List<StudentVO> list = ss.selectList("student_teamboard.teamlist");
			System.out.println("List:"+list.size());		
			return list;
		}
		
		// Teamboard_detail
		public StudentVO detailBoard(int num) {
			StudentVO svo = ss.selectOne("student_teamboard.teamboard_detail", num);
			return svo;
		}
		
		// teamboard_detail 상세보기 엑셀 다운로드
		public List<SboardVO> teamExcelList() {
			return ss.selectList("student_teamboard.ExcelList");
		}
		
		// teamboard_delete 글삭제
		public void delete(int num) {
			
			ss.delete("student_teamboard.delete", num);
		}
		
		// teamboard_modify 글 수정
		public void modify(SboardVO sbvo) {

			ss.update("student_teamboard.modify",sbvo);
		}
}
