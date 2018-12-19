package finalproj.mvc.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import finalproj.mvc.dao.adminDao.Admin_JoinDao;

@RestController
@RequestMapping("/data")
public class Admin_JoinDataController {
	
	@Autowired
	Admin_JoinDao joindao;
	
	// 관리자 id중복확인
		@GetMapping("/admin_idCheck")
		public int idCheck(@RequestParam("adid") String adid) {
			int cnt = joindao.idChk(adid);

			return cnt;
		}
}
