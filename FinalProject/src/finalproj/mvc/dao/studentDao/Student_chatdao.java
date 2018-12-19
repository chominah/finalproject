package finalproj.mvc.dao.studentDao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalproj.dto.ChatVO;
import finalproj.dto.StgroupVO;
import finalproj.dto.StudentVO;

@Repository
public class Student_chatdao implements Student_Inter {

	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public void addgroup(String[] glist) {
		String grouplist = "";
		StgroupVO stvo = new StgroupVO();
		List<StudentVO> list = ss.selectList("main1.slist");
		int mgno = ss.selectOne("main1.gno");
		mgno += 1;
		for (String e : glist) {
			System.out.println("´©±¸ : " + e);
			for (StudentVO svo : list) {
				if (svo.getSname().equals(e)) { //mgno
					int selectsnum=ss.selectOne("main1.snum",e);
					stvo.setSnum(selectsnum);
					stvo.setGroupno(mgno);
					ss.insert("main1.insert", stvo);

				}
			}
		}

	}

	@Override
	public List<StudentVO> getstudentlist() {
		List<StudentVO> slist = ss.selectList("main1.slist");
		return slist;
	}

	@Override
	public List<StgroupVO> getSnameToSnum(List<StudentVO> svo) {
		// TODO Auto-generated method stub
		return null;
	}

}
