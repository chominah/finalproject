package finalproj.mvc.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finalproj.dto.ScheduleVO;
import finalproj.mvc.dao.adminDao.AdminDaoInter;

@RestController
@RequestMapping(value="/data")
public class ScheduleDataController {
	
	@Autowired
	private AdminDaoInter adminDaoInter;	
	
	@RequestMapping(value="getScheduleData_month")
	public List<ScheduleVO> getScheduleData_month(String day) {
		List<ScheduleVO> list =  adminDaoInter.getScheduleList(day);
		return list;
	}
	
	@RequestMapping(value="getScheduleData_oneday")
	public List<ScheduleVO> getScheduleData_oneday(String day){
		System.out.println("getScheduleData_oneday");
		System.out.println("day ::"+day);
		List<ScheduleVO> list = adminDaoInter.getScheduleOne(day);
		String[] temp;
		for(ScheduleVO vo : list) {
			System.out.println("vo::"+vo.getShdate());
			System.out.println("vo::"+vo.getShloc());
			System.out.println("vo::"+vo.getShname());
			System.out.println("vo::"+vo.getCnum());
			temp = vo.getShdate().split(" ");
			for(String e : temp) {
				System.out.println("sub :::"+e);				
			}
			System.out.println("-----------------------");
		}		
		return list;
	}
}
