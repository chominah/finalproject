package finalproj.mvc.controller.student;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import finalproj.dto.StudentVO;
import finalproj.dto.TboardVO;
import finalproj.dto.TeacherVO;
import finalproj.mvc.dao.studentDao.Student_Inter;
import finalproj.mvc.dao.studentDao.Student_MainInter;

@Controller
public class Student_Maincontroller {

	@Autowired
	public Student_Inter sinter;
	
	@Autowired
	private Student_MainInter mainInter;
	
	// index 나중에 삭제
		@RequestMapping(value="/")
		public String index() {
			return"index";
		}
		
	// mainboard 목록으로 버튼
	@GetMapping("/mainboard_btn")
	public String mainboard_btn() {
		return "redirect:/";
	}
	
	// mainboard list
	@RequestMapping(value="/mainboard")
	public String mainBoard(Model m){
		List<TeacherVO> list = mainInter.listTBoard();
		m.addAttribute("list",list);
		return "mainboard";
	}
	
	// mainboard_detail 상세보기
	@GetMapping(value="/mainboard_detail")
	public String mainboardDetail( int num, Model m) {
		TeacherVO tvo = new TeacherVO();
		tvo = mainInter.detailBoard(num);
		String bfile = tvo.getTboard().getTbfile();
		ArrayList<String> list = new ArrayList<String>();
		StringTokenizer tokens = new StringTokenizer(bfile, ",");
		
		for(int i=0;tokens.hasMoreTokens();i++) {
			list.add(tokens.nextToken());
		}
		
		System.out.println("list : "+list);
		
		m.addAttribute("list",list);	
		m.addAttribute("tvo", tvo);
		System.out.println("num3 : "+num);
		
		return"mainboard_detail";
	}
	
	// mainboard_detail 상세보기 파일 다운로드
	private static final int BUFFER_SIZE = 4096;
	@RequestMapping(value="/MainimgDown")
	public void imgDown(@RequestParam("tbfile") String tbfile, HttpSession session,
			           HttpServletRequest request, HttpServletResponse response) throws IOException{
		ServletContext context = request.getServletContext();
		String path = session.getServletContext().getRealPath("/resources/upload/"+tbfile);
		File downloadFile = new File(path);
		FileInputStream fi = new FileInputStream(downloadFile);
		String mimeType = context.getMimeType(path);
		if(mimeType == null) {
			mimeType = "application/octet-stream";
		}
		response.setContentType(mimeType);
		response.setContentLength((int)downloadFile.length());
		String headerkey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
		response.setHeader(headerkey, headerValue);
		OutputStream outStream = response.getOutputStream();
		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = -1;
		while((bytesRead = fi.read(buffer)) != -1) {
			outStream.write(buffer,0,bytesRead);
		}
		fi.close();
		outStream.close();
	}
	
	// mainboard_detail 상세보기 엑셀 다운로드
	@RequestMapping(value="/MainExcelDown")
	public ModelAndView ExcelList() {
		List<TboardVO> mainboard_Detail = mainInter.ExcelList();
		return new ModelAndView("excelMainView","mainboard_Detail",mainboard_Detail);
	}
	
	@RequestMapping(value = "/list")
	public String Studentlist(Model m) {
		List<StudentVO> slist = new ArrayList<>();
		slist = sinter.getstudentlist();
		m.addAttribute("slist", slist);
		return "teamboard";
	}

	@RequestMapping(value = "/makegroup")
	public String Studentgroup(Model m, HttpServletRequest req, HttpSession session) {
		String[] glist = req.getParameterValues("grouplist");
		//glist[glist.length]=(String) session.getAttribute("sname");
		sinter.addgroup(glist);

		return "my_main";

	}

	@RequestMapping(value = "/chat")
	public String chat() {
		return "chat";
	}

}
