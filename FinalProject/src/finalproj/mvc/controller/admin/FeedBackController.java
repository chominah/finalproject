package finalproj.mvc.controller.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import finalproj.dto.CpfeedVO;
import finalproj.dto.ResumeVO;
import finalproj.mvc.dao.AdminDao;

@Controller
public class FeedBackController {

	@Autowired
	private AdminDao dao;

	// ---- Edu_resume.jsp start ----
	// 이력서 신청 리스트 View(Edu_resume.jsp 화면)
	@RequestMapping(value = "/resume")
	public String edu_resume(Model model) {
		List<Map<String, Object>> list = dao.fback_Resume();
		model.addAttribute("list", list);

		return "Edu_Resume";
	}

	// resume 파일 업로드
	// rnum(이력서 테이블의 pk)의 값과 mfile(이력서 테이블의 rfile)의 값을 파라메타 값으로 받아
	// 지정된 경로에 파일을 업로드 시키고 DB에 저장하는 형식이다.
	@PostMapping(value = "rfile_upload")
	public String rfile_upload(@RequestParam("rnum") int rnum, @RequestParam("mfile") MultipartFile mfile, Model model,
			HttpServletRequest request) {
		// 지정된 경로로 파일을 저장
		String file_path = "resources\\upload\\";
		String r_path = request.getRealPath("/");
		// 파일명
		String oriFn = mfile.getOriginalFilename();
		String contentType = mfile.getContentType();
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(file_path);
		path.append(oriFn);
		System.out.println(path);
		File f = new File(path.toString());
		System.out.println(f.exists());

		// 파일 업로드 진행
		try {
			mfile.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("fileName", oriFn);
		// ----파일 업로드 진행 End-----

		// ---- DB테이블에 update 실행 -----
		ResumeVO rvo = new ResumeVO();
		rvo.setRfile(oriFn);
		rvo.setRnum(rnum);
		dao.rfile_up(rvo);
		// ---- DB테이블에 update 실행 -----
		return "redirect:resume";
	}
	// ---- Edu_resume.jsp end -----

	// ---- Edu_Company.jsp start ----
	// 학생관리 관심기업 피드백
	@RequestMapping(value = "/company")
	public String edu_company(Model model) {
		List<Map<String, Object>> list = dao.fback_CompanyList();
		model.addAttribute("list", list);
		return "Edu_Company";
	}
	// ---- Edu_Company.jsp end ----

	// ---- Edu_Company_Write.jsp start ----
	// 학생관리 관심기업 피드백 상세보기
	@RequestMapping(value = "/company_write")
	public String edu_company_write(Model model, int cpfnum) {
		String content = dao.fback_contentView(cpfnum);
		model.addAttribute("cpfnum", cpfnum);
		model.addAttribute("content", content);
		return "Edu_Company_Write";
	}

	// 피드백에 대한 내용 업로드 후 학생관리 관심기업 리스트로 넘어가는 함수
	@RequestMapping(value = "/company_upload")
	public String edu_company_upload(Model model, int cpfnum, String content) {
		CpfeedVO cpfvo = new CpfeedVO();
		cpfvo.setCpfnum(cpfnum);
		cpfvo.setCpfcontent(content);
		dao.fback_up(cpfvo);
		return "redirect:company";
	}
	// ---- Edu_Company_Write.jsp end ----

	// ---- 파일 다운로드 메서드 Start ----
	// 버퍼의 크기 설정
	private static final int BUFFER_SIZE = 4096;

	// 파일 다운로드
	@RequestMapping(value = "/fileDown")
	public void fileDown(@RequestParam("fileName") String fileName, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// applicationContext 객체를 request로 부터 얻어냄
		ServletContext context = request.getServletContext();
		// 업로드된 경로 얻음
		String path = session.getServletContext().getRealPath("/resources/upload/") + fileName;
		System.out.println(path);
		// 그 경로로 파일 객체를 생성
		File downloadFile = new File(path);
		// FileInputStream 스트림으로 읽어옴
		FileInputStream fi = new FileInputStream(downloadFile);
		// 요청 객체로부터 연결될 브라우저의 마임타입을 얻어냄
		String mimeType = context.getMimeType(path);
		System.out.println(mimeType);
		// 만약 마임타입값이 없으면 그냥 디폴트로 스트림으로 연결
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}
		// 지정된 마임타입 세팅
		response.setContentType(mimeType);
		// 다운로드 될 파일의 길이 세팅
		response.setContentLength((int) downloadFile.length());
		// 다운로드 Type을 설정함
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
		System.out.println(headerValue);
		// 위의 다운로드 타입의 정보를 해더로 설정
		response.setHeader(headerKey, headerValue);
		// 브라우저로부터 스트림을 연결
		OutputStream outStream = response.getOutputStream();
		// 버퍼를 끼워서 빠르게 전달 목적
		byte[] buffer = new byte[BUFFER_SIZE];
		// 이제 브라우저로 보내고, 자원 닫으면 끝
		int bytesRead = -1;
		while ((bytesRead = fi.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		fi.close();
		outStream.close();
	}
	// ---- 파일 다운로드 메서드 End ----

}
