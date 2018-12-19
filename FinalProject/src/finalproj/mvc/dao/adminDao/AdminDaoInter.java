package finalproj.mvc.dao.adminDao;

import java.util.List;

import finalproj.dto.CplistVO;
import finalproj.dto.ScheduleVO;

public interface AdminDaoInter {

	public List<CplistVO> getAllCpList();
	public void addCpList(CplistVO vo);
	public void addCpList2(CplistVO vo);
	public List<ScheduleVO> getScheduleList(String day);
	public List<ScheduleVO> getScheduleOne(String day);
}
