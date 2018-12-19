package finalproj.mvc.controller.admin;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import finalproj.dto.CplistVO;
import finalproj.mvc.dao.adminDao.AdminDaoInter;


@Controller
public class ComponyController {

	@Autowired
	private AdminDaoInter adminDaoInter;

	// 기업 리스트 뷰로 이동
	@RequestMapping(value = "comlistview")
	public String listview(Model m) {
		List<CplistVO> list = adminDaoInter.getAllCpList();

		m.addAttribute("list", list);
		return "comlistview";
	}

	// 기업 추가 폼으로 이동
	@RequestMapping(value = "addcomform")
	public String addcomform() {
		return "addcomform";
	}

	// 기업 리스트 추가
	@RequestMapping(value = "addcomlist", method = RequestMethod.POST)
	public String addcomlist(CplistVO cplist) {
		int leng = cplist.getCplist().size();
		System.out.println("size ::" + leng);
		for (CplistVO e : cplist.getCplist()) {
			if (!e.getCpnum().equals("")) {
				adminDaoInter.addCpList(e);
			}
		}

		return "redirect:comlistview";
	}
	
	@RequestMapping(value="exceldown")
	public ModelAndView exceldown() {
		List<CplistVO> list =  adminDaoInter.getAllCpList();
		
		return new ModelAndView("excelDown", "cplist", list);
	}
	
	@RequestMapping(value="addExcel", method=RequestMethod.POST)
	public String addExcel(@RequestParam("m_file") MultipartFile m_file, Model m,
			HttpServletRequest request,	HttpServletResponse response) throws Exception {
		String imgpath = "resources\\temp";
		String r_path = request.getRealPath("/");
		String oriFn = m_file.getOriginalFilename();
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(imgpath).append("\\");
		path.append(oriFn);
		System.out.println(path);
		File f = new File(path.toString());
		try {
			m_file.transferTo(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		ExcelBuilderUpload upload = new ExcelBuilderUpload();                      
		String list =  upload.readExcel(path.toString(), request, response);
		m.addAttribute("list",list);
		return "cpExcelData";
		
	}
	

}
