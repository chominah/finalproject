package finalproj.mvc.controller.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import finalproj.mvc.dao.teacherDao.Teacher_JoinDao;

@RestController
@RequestMapping("/data")
public class Teacher_JoinDataController {
	
	@Autowired
	Teacher_JoinDao joindao;
	
	// 강사 id중복확인
		@GetMapping("/teacher_idCheck")
		public int idCheck(@RequestParam("tid") String tid) {
			int cnt = joindao.idChk(tid);

			return cnt;
		}
}
