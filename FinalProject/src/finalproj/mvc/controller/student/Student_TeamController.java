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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import finalproj.dto.SboardVO;
import finalproj.dto.StudentVO;
import finalproj.mvc.dao.studentDao.Student_TeamBoardDao;

@Controller
public class Student_TeamController {
	
	@Autowired
	private Student_TeamBoardDao dao;
	
	// teamboard_write_btn 작성 버튼
	@GetMapping("/teamboard_write_btn")
	public String teamboard_write_btn() {
		return "teamboard_write";
	}
	
	// teamboard 목록으로 버튼
	@GetMapping("/teamboard_btn")
	public String teamboard_btn() {
		return "redirect:/teamboard";
	}
	
	//Teamboard_write 작성완료 후 실행
	@PostMapping(value="/teamboard_write")
		public String uploadFile(
				Model m, MultipartHttpServletRequest mtfRequest , SboardVO sbvo) {
		
		List<MultipartFile> fileList = mtfRequest.getFiles("b_file");
		String img_path = "resources\\upload\\";
		String r_path = mtfRequest.getRealPath("/");
		String oriFn;
		
		StringBuffer file = new StringBuffer();
		System.out.println(r_path);
	
		for ( MultipartFile bf : fileList) {
			oriFn = bf.getOriginalFilename();
			System.out.println("���ϸ� : "+oriFn);
			
			StringBuffer path = new StringBuffer();
			path.append(r_path).append(img_path);
			path.append(oriFn);
			System.out.println(path);
			
			File f = new File(path.toString());
			System.out.println(f.exists());
			
			// 파일업로드
			try {
				bf.transferTo(f);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			file.append(oriFn).append(",");
		}
		// db
		sbvo.setBfile(file.toString());
		sbvo.setSnum(9);
		System.out.println(file);
		dao.insert(sbvo);
		
		return "redirect:/teamboard";
		}
	
	// teamboard list
	@RequestMapping(value="/teamboard")
		public String teamBoard(Model m){
			System.out.println(dao.listSBoard());
			m.addAttribute("list",dao.listSBoard());
			return "teamboard";
		}
		
		// teamboard_detail 상세보기
		@GetMapping(value="/teamboard_detail")
		public String teamboardDetail( int num, Model m) {
			StudentVO svo = new StudentVO();
			svo = dao.detailBoard(num);
			String bfile = svo.getSboard_detail().getBfile();
			ArrayList<String> list = new ArrayList<String>();
			StringTokenizer tokens = new StringTokenizer(bfile, ",");
			
			for(int i=0;tokens.hasMoreTokens();i++) {
				list.add(tokens.nextToken());
			}
			
			System.out.println("list : "+list);
			
			m.addAttribute("list",list);	
			m.addAttribute("svo", svo);
			
			return"teamboard_detail";
		}
		
		// teamboard_detail 상세보기 파일 다운로드
	private static final int BUFFER_SIZE = 4096;
		@RequestMapping(value="/teamImgDown")
		public void imgDown(@RequestParam("bfile") String bfile, HttpSession session,
				           HttpServletRequest request, HttpServletResponse response) throws IOException{
			ServletContext context = request.getServletContext();
			String path = session.getServletContext().getRealPath("/resources/upload/"+bfile);
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
		
		// teamboard_detail 상세보기 엑셀 다운로드
		@RequestMapping(value="/TeamExcelDown")
		public ModelAndView ExcelList() {
			List<SboardVO> teamboard_Detail = dao.teamExcelList();
			return new ModelAndView("excelTeamView","teamboard_Detail",teamboard_Detail);
		}

		// teamboard_delete 삭제
		@RequestMapping(value="/teamboard_delete", method=RequestMethod.GET)
		public String teamboardDelete(@RequestParam("num")int num){
			dao.delete(num);
			
			return "redirect:/teamboard";
		}
		
		// teamboard_modify_btn 수정버튼
		@GetMapping(value="/teamboard_modify_btn")
		public String teamboardmodify_btn(@RequestParam("bnum") int bnum, Model m) {
			StudentVO svo = new StudentVO();
			svo = dao.detailBoard(bnum);
			String bfile = svo.getSboard_detail().getBfile();
			ArrayList<String> list = new ArrayList<String>();
			StringTokenizer tokens = new StringTokenizer(bfile, ",");
			
			for(int i=0;tokens.hasMoreTokens();i++) {
				list.add(tokens.nextToken());
			}
			
			System.out.println("list : "+list);
			
			m.addAttribute("list",list);
			m.addAttribute("svo",svo);

			return"teamboard_modify";
				}
	
		// teamboard_modify 수정 완료 후 실행
		@RequestMapping(value="/teamboard_modify")
		public String teamboard_modify(
				Model m, MultipartHttpServletRequest mtfRequest, SboardVO sbvo){
			System.out.println("========================");
			List<MultipartFile> fileList = mtfRequest.getFiles("b_file");
			String img_path="resources\\upload\\";
			String r_path= mtfRequest.getRealPath("/");
			String oriFn;
			
			StringBuffer file = new StringBuffer();
			System.out.println(r_path);
			for(MultipartFile bf : fileList) {
				oriFn = bf.getOriginalFilename();
				
				StringBuffer path = new StringBuffer();
				path.append(r_path).append(img_path);
				path.append(oriFn);
				System.out.println(path);
				
				File f = new File(path.toString());
				System.out.println(f.exists());
				
				// 파일 업로드
				try {
					bf.transferTo(f);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
				file.append(oriFn).append(",");
			}
			
			//db
			sbvo.setBfile(file.toString());
			sbvo.setSnum(9);	
			dao.modify(sbvo);
			
			return "redirect:/teamboard";
		}
							
}