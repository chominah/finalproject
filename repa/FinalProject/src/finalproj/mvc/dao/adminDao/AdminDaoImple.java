package finalproj.mvc.dao.adminDao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalproj.dto.CplistVO;

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
	

	
}
