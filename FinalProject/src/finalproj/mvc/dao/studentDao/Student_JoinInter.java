package finalproj.mvc.dao.studentDao;

import java.util.List;

import finalproj.dto.CertVO;
import finalproj.dto.ClassVO;
import finalproj.dto.JobkeywordVO;
import finalproj.dto.StudentVO;
import javassist.compiler.ast.Keyword;

public interface Student_JoinInter {
	
	public void joinStudent(StudentVO svo, String crname, String cname);
	public int idChk(String sid);
	public StudentVO loginCheck(StudentVO svo);
	public CertVO MyInfo();
	public void Modify(StudentVO svo, String crname);
	public List<JobkeywordVO> getkeywordList();
	public List<CertVO> getcertList();
	public List<ClassVO> getclassList();
}
