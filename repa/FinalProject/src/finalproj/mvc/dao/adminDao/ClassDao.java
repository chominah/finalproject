package finalproj.mvc.dao.adminDao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalproj.dto.ClassVO;
import finalproj.dto.StudentVO;
import finalproj.dto.TeacherVO;

@Repository
public class ClassDao {
@Autowired
private SqlSessionTemplate ss;



public List<Map<String, Object>> classList(){
	
	return ss.selectList("classInfo.classlist");
}

public List<Map<String, Object>> myclassList(String id){
	
	return ss.selectList("classInfo.myclasslist",id);
}

public int logcheck(Map<String, Object> map){
	
	return ss.selectOne("classInfo.clogcheck",map);
}

public List<StudentVO> classview(int cnum){
	
	return ss.selectList("classInfo.classviewer",cnum);
}

public void addClass(ClassVO vo){
	
	ss.insert("classInfo.addclass",vo);
}


}
