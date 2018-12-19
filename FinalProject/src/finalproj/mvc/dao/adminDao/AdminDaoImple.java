package finalproj.mvc.dao.adminDao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalproj.dto.CplistVO;
import finalproj.dto.ScheduleVO;

@Repository
public class AdminDaoImple implements AdminDaoInter{
	
	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public List<CplistVO> getAllCpList() {
		List<CplistVO> list = ss.selectList("cplist.alllist");
		
		return list;
	}

	@Override
	public void addCpList(CplistVO vo) {
		ss.insert("cplist.addcplist",vo);
		
	}

	@Override
	public List<ScheduleVO> getScheduleList(String day) {
		List<ScheduleVO> list = ss.selectList("schedule.scheduleAllList",day);
		
		return list;
	}

	@Override
	public List<ScheduleVO> getScheduleOne(String day) {
		List<ScheduleVO> list = ss.selectList("schedule.scheduleDetailView",day);
		
		return list;
	}

	@Override
	public void addCpList2(CplistVO vo) {
		System.out.println("addCpList2");
		ss.insert("cplist.addcplist2",vo);
		
	}
	

	
}
