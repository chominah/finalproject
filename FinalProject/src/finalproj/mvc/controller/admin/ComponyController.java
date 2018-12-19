package finalproj.mvc.controller.admin;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	// main page 이동 --> 추후 삭제 예정
	@RequestMapping(value = "/admin_main")
	public String home() {

		return "my_main";
	}

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
				// Kosta 협약 기업 리스트 넣을 때 사용하는 code
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
				List<CplistVO> list =  upload.readExcel(path.toString(), request, response);
				for(CplistVO e : list) {
					adminDaoInter.addCpList2(e);
				}
		return "redirect:comlistview";
		
	}

	
	@RequestMapping(value="matchingSaramin")
	public String matchingSaramin(Model m) {		
		List<CplistVO> mycp_list = adminDaoInter.getAllCpList();
		m.addAttribute("mycp_list",mycp_list);
		
		return "matchingSaramin";
	}
	

}
