package finalproj.mvc.dao.teacherDao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalproj.dto.ClassVO;
import finalproj.dto.TboardVO;

@Repository
public class Teacher_TeahcerBoardDao {

	@Autowired
	private SqlSessionTemplate ss;
	
	// teacherboard list
	public List<ClassVO> listTBoard(int tnum){
		List<ClassVO> list = ss.selectList("teacher_teacherboard.list",tnum);
		
		for(ClassVO vo : list) {
			for(TboardVO e : vo.getTboard()) {
				System.out.println("tbtitle : "+e.getTbtitle());
				System.out.println("classname : "+vo.getCname());
				System.out.println("tbdate : "+e.getTbdate());
			}
		}
		
		return list;
	}
	
	// teacherboard_write 글작성
	public void teacherboard_write(TboardVO tbvo) {
		System.out.println("tnum : "+tbvo.getTnum());
		System.out.println("tbtitle : "+tbvo.getTbtitle());
		System.out.println("tbfile : "+tbvo.getTbfile());
		System.out.println("tbcontent : "+tbvo.getTbcontent());
		ss.insert("teacher_teacherboard.write", tbvo);
	}
	
	// teacherboard_detail 상세보기
	public ClassVO teacherboard_detail(int num) {
		ClassVO cvo = ss.selectOne("teacher_teacherboard.detail", num);
		return cvo;
	}
	
	// teacherboard_detail 엑셀로 내려받기
		public List<TboardVO> teacherExcelList(){
			return ss.selectList("teacher_teacherboard.ExcelList");
		}
		
		// teacherboard_modify 글수정
		public void teacherboard_modify(TboardVO tbvo) {
			ss.update("teacher_teacherboard.modify",tbvo);
		}
		
		// teacherboard_delete 글삭제
		public void teacherboard_delete(int num) {
			ss.delete("teacher_teacherboard.delete", num);
		}
		
}
