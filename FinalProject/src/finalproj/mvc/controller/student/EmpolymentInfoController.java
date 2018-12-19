package finalproj.mvc.controller.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import finalproj.dto.ClassVO;
import finalproj.dto.CplistVO;
import finalproj.dto.JobkeywordVO;
import finalproj.dto.PageVO;
import finalproj.mvc.dao.studentDao.JobSearchDao;


@Controller
public class EmpolymentInfoController {
	@Autowired
	private JobSearchDao dao;
    
	// select 박스에 디비에 저장된 키워드,강의 넣기
	@RequestMapping(value = "jobsearch", method = RequestMethod.GET)
	public ModelAndView jobsearch() {
		ModelAndView mav = new ModelAndView();

		List<JobkeywordVO> list = dao.keywordmenu();
		List<CplistVO> list2 = dao.cplocmenu();
		List<ClassVO> list3 = dao.cnamemenu();
		System.out.println("list: " + list.get(0).getKeyword());
		mav.addObject("list", list);
		mav.addObject("list2", list2);
		mav.addObject("list3", list3);
		mav.setViewName("jobinfo");

		return mav;
	}
    
	// 키워드 기업리스트 간략보기
	@RequestMapping(value = "/keyword", method = RequestMethod.GET)
	public ModelAndView keywordSearch(String keywordValue, String cplocValue) {
		ModelAndView mav = new ModelAndView();
		System.out.println("keyword: " + keywordValue);
		System.out.println("cploc: " + cplocValue);
		Map<String, String> map = new HashMap<>();
		map.put("keywordValue", keywordValue);
		map.put("cplocValue", cplocValue);
		List<CplistVO> list = dao.keywordList(map);
		mav.setViewName("keywordList");
		mav.addObject("job", list);
		mav.addObject("keyword", keywordValue);
		mav.addObject("cploc", cplocValue);

		return mav;
	}
    
	// 키워드 기업리스트 전체보기
	@RequestMapping(value = "/keywordtotal",method=RequestMethod.GET)
	public ModelAndView keywordTotal(String keyword,String cploc,int page) {
		
		Map<String, String> map = new HashMap<>();
		PageVO pageinfo = new PageVO();
		int currentPage = page;
		int rowsPerPage = 5;
		int pagesPerBlock = 10;
		int currentBlock = 0;
		
		int startRow = (currentPage - 1) * rowsPerPage + 1;
		int endRow = currentPage * rowsPerPage;
		String begin = String.valueOf(startRow);
		String end = String.valueOf(endRow);
		 System.out.println("begin:"+begin); 
	     System.out.println("end:"+end);  
		 System.out.println("currentPage:"+page); 
		 
		 
			map.put("keywordValue", keyword);
			map.put("cplocValue", cploc);
			map.put("begin", begin);
			map.put("end", end);
		 
		if(currentPage%pagesPerBlock==0) {
			currentBlock = currentPage / pagesPerBlock;
		}else {
			currentBlock = currentPage / pagesPerBlock + 1;
		}
		
		ModelAndView mav = new ModelAndView();
		
		int totalRow=dao.getTotal(map);
       
        int totalPage = 0;
        if(totalRow % rowsPerPage == 0) {
        	totalPage = totalRow / rowsPerPage;
        }else {
        	totalPage = totalRow / rowsPerPage + 1;
        }
        int totalBlock = 0;
        
        if(totalPage%pagesPerBlock==0) {
        	totalBlock = totalPage / pagesPerBlock;
        	
        }else {
        	totalBlock = totalPage / pagesPerBlock+1;
        }
        
		
	
		
        pageinfo.setCurrentBlock(currentBlock);
        pageinfo.setCurrentPage(currentPage);
        pageinfo.setPagesPerBlock(pagesPerBlock);
        pageinfo.setRowsPerPage(rowsPerPage);
        pageinfo.setTotalBlocks(totalBlock);
        pageinfo.setTotalPages(totalPage);
        pageinfo.setTotalRows(totalRow);
       
       System.out.println("currentBlock:"+currentBlock); 
       System.out.println("totalBlock:"+totalBlock); 
       System.out.println("totalPage:"+totalPage); 
       System.out.println("totalRow:"+totalRow); 
       
        
		List<CplistVO> list = dao.keywordTotal(map);
		
	    mav.setViewName("kTotal");
	    System.out.println("list3:"+list.get(0).getCpname());
		mav.addObject("keywordtotal",list);
		mav.addObject("pageinfo",pageinfo);
		mav.addObject("keyword",keyword);
		mav.addObject("cploc",cploc);
		
		
		
		return mav;
	}
	
		
	
    // 기업 상세보기
	@RequestMapping(value = "/jobinfo", method = RequestMethod.GET)
	public ModelAndView keywordTotal(int cpnum) {
		ModelAndView mav = new ModelAndView();

		System.out.println("cpnum:" + cpnum);
		List<CplistVO> list = dao.jobinfo(cpnum);

		mav.setViewName("companyinfo");
		System.out.println("cpnum :" + list);
		mav.addObject("jobinfo", list);

		return mav;
	}
    
	// 메일페이지로
	@RequestMapping(value = "/mail", method = RequestMethod.GET)
	public ModelAndView mail(String ceomail) {
		ModelAndView mav = new ModelAndView();
		System.out.println("ceomail:" + ceomail);

		mav.setViewName("email");

		mav.addObject("ceomail", ceomail);

		return mav;
	}

}