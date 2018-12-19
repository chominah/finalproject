package finalproj.mvc.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import finalproj.mvc.dao.studentDao.Student_JoinInter;

@RestController
@RequestMapping("/data")
public class Student_JoinDataController {
	
	@Autowired
	Student_JoinInter inter;
	
	// 학생 id중복확인
		@GetMapping("/idCheck")
		public int idCheck(@RequestParam("sid") String sid) {
			int cnt = inter.idChk(sid);

			return cnt;
		}
}
