package finalproj.mvc.controller.teacher;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import finalproj.dto.ClassVO;
import finalproj.dto.TboardVO;
import finalproj.mvc.dao.teacherDao.Teacher_TeahcerBoardDao;
@Controller
public class Teacher_TeacherController {
	
	@Autowired
	public Teacher_TeahcerBoardDao dao;
	
	// teacherboard list 강사 
	@RequestMapping(value="/teacherboard")
	public String teacherBoard(Model m, TboardVO tbvo) {
		tbvo.setTnum(1);
		System.out.println("tnum : "+tbvo.getTnum());
		m.addAttribute("list",dao.listTBoard(tbvo.getTnum()));
		return "teacherboard";
	}
	
	// teacherboard_write_btn 강사 글작성버튼
	@GetMapping("/teacherboard_write_btn")
	public String teacherboard_write_btn() {
		return "teacherboard_write";
	}
	
	//teacherboard_btn 목록으로 돌아가기 버튼
	@GetMapping("/teacherboard_btn")
	public String teacherboard_btn() {
		return "redirect:/teacherboard";
	}
	
	// teacherboard_write 글 작성 완료하면 실행
	@PostMapping(value="/teacherboard_write")
	public String teacherboard_write(List<MultipartFile> tb_file, 
						Model m, HttpServletRequest request, TboardVO tbvo) {
		String img_path = "resources\\upload\\";
		String r_path = request.getRealPath("/");
		
		StringBuffer file = new StringBuffer();
		System.out.println(r_path);
		
		int i=0;
		for(MultipartFile mf : tb_file) {
			String oriFn = mf.getOriginalFilename();
			
			long size = mf.getSize();
			String contentType = mf.getContentType();
			  System.out.println(r_path);
			   System.out.println("���ϸ� :"+oriFn);
			   System.out.println("����ũ�� :"+size);
			   System.out.println("Type :"+contentType);
			   
			 StringBuffer path = new StringBuffer();
			 path.append(r_path).append(img_path).append("\\");
			 path.append(oriFn);
			 File f = new File(path.toString());
			 
			 //파일 업로드
			 try {
				mf.transferTo(f);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			 file.append(oriFn).append(",");
			 m.addAttribute("imgName"+(i++), oriFn);
			 
		}
	
		tbvo.setTbfile(file.toString());
		tbvo.setTnum(1);
		tbvo.setCnum(1);
		dao.teacherboard_write(tbvo);
		System.out.println("tnum controller: "+tbvo.getTnum());
		System.out.println("tbtitle controller: "+tbvo.getTbtitle());
		System.out.println("tbfile controller: "+tbvo.getTbfile());
		System.out.println("tbcontent controller: "+tbvo.getTbcontent());
		return "redirect:/teacherboard";
	}
	
	// teacherboard_detail 강사 작성글 상세보기
	@GetMapping(value="/teacherboard_detail")
	public String teacherboard_detail(int num, Model m, TboardVO tbvo) {
		ClassVO cvo = new ClassVO();
		cvo = dao.teacherboard_detail(num);
		String tbfile = cvo.getTboard_detail().getTbfile();
		ArrayList<String> list = new ArrayList<String>();
		StringTokenizer tokens = new StringTokenizer(tbfile, ",");
		
		for(int i=0; tokens.hasMoreTokens();i++) {
			list.add(tokens.nextToken());
		}
		m.addAttribute("list",list);
		m.addAttribute("cvo",cvo);
		return "teacherboard_detail";
	}
	
	//teacherboard_detail 상세보기 엑셀로 내려받기
	@RequestMapping(value="/TeacherExcelDown")
	public ModelAndView TeacherExcelDown() {
		List<TboardVO> teacherboard_Detail = dao.teacherExcelList();
		return new ModelAndView("excelTeacherView","teacherboard_Detail",teacherboard_Detail);
	}
	
	// teacherboard_detail 상세보기 파일 다운로드
		private static final int BUFFER_SIZE = 4096;
		@RequestMapping(value="/teacherFileDown")
		public void teacherFileDown(@RequestParam("tbfile") String tbfile, HttpSession session,
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
		
		// teacherboard_modify_btn 수정 버튼
				@GetMapping(value="/teacherboard_modify_btn")
				public String teacherboard_modify_btn(@RequestParam("tbnum") int tbnum, Model m) {
					ClassVO cvo = new ClassVO();
					cvo = dao.teacherboard_detail(tbnum);
					String tbfile = cvo.getTboard_detail().getTbfile();
					ArrayList<String> list = new ArrayList<String>();
					StringTokenizer tokens = new StringTokenizer(tbfile, ",");
					
					for(int i=0;tokens.hasMoreTokens();i++) {
						list.add(tokens.nextToken());
					}
					
					System.out.println("list : "+list);
					
					m.addAttribute("list",list);
					m.addAttribute("cvo",cvo);
					return"teacherboard_modify";
						}
			
				// teacherboard_modify 수정완료되면 실행
				@RequestMapping(value="/teacherboard_modify")
				public String teacherboard_modify(List<MultipartFile> tb_file, 
						Model m, HttpServletRequest request, TboardVO tbvo){
					System.out.println("========================");
					String img_path = "resources\\upload\\";
					String r_path = request.getRealPath("/");
					
					StringBuffer file = new StringBuffer();
					System.out.println(r_path);
					
					int i=0;
					for(MultipartFile mf : tb_file) {
						String oriFn = mf.getOriginalFilename();
						
						long size = mf.getSize();
						String contentType = mf.getContentType();
						  System.out.println(r_path);
						   System.out.println("파일명 :"+oriFn);
						   System.out.println("파일 크기 :"+size);
						   System.out.println("Type :"+contentType);
						   
						 StringBuffer path = new StringBuffer();
						 path.append(r_path).append(img_path).append("\\");
						 path.append(oriFn);
						 File f = new File(path.toString());

						 //파일 업로드
						 try {
							mf.transferTo(f);
						} catch (IllegalStateException | IOException e) {
							e.printStackTrace();
						}
						 file.append(oriFn).append(",");
						 m.addAttribute("imgName"+(i++), oriFn);
						 
					}
					
					//db
					tbvo.setTbfile(file.toString());
					tbvo.setTnum(1);
					tbvo.setCnum(1);
					dao.teacherboard_modify(tbvo);
					return "redirect:/teacherboard";
				}
				
				// teacherboard_delete 삭제
				@RequestMapping(value="/teacherboard_delete", method=RequestMethod.GET)
				public String teacherboard_delete(@RequestParam("num")int num){
					dao.teacherboard_delete(num);
					return "redirect:/teacherboard";
				}
	
}
