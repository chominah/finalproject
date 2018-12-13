package finalproj.mvc.dao.adminDao;

import java.util.List;

import finalproj.dto.CplistVO;

public interface AdminDaoInter {

	public List<CplistVO> getAllCpList();
	public void addCpList(CplistVO vo);
	
}
