package finalproj.mvc.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import finalproj.dto.CplistVO;



@SuppressWarnings("deprecation")
public class ExcelBuilderDown extends AbstractExcelView{
	// excelView 뷰를 찾으면, 이것을 현재 클래스 ExcelBuilder 가 AbstractExcelView를 상속 했기 때문에 이것은 뷰 이다.
	// DispatcherServlet -> [view]jsp (model) : forward
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// HSSF : 마이크로 소프트의 엑셀 전용 클래스
		// DispatcherServlet 에 의해서 Model을 받는다.
		// ${listBooks}
		List<CplistVO> listBooks = (List<CplistVO>) model.get("cplist");
		// poi 문법
		HSSFSheet sheet = workbook.createSheet("show list");
		sheet.setDefaultColumnWidth(30);
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);
		HSSFRow header = sheet.createRow(0);
		
		//엑셀의 셀 타이틀
		String[] str = {"기업번호","기업이름","기업위치","분류","채용공고"};
		for(int i =0; i<str.length; i++) {
			header.createCell(i).setCellValue(str[i]);
			header.getCell(i).setCellStyle(style);
		}
		int rowCount = 1;
		for(CplistVO book : listBooks) {
			HSSFRow aRow = sheet.createRow(rowCount++);
			aRow.createCell(0).setCellValue(book.getCpnum());
			aRow.createCell(1).setCellValue(book.getCpname());
			aRow.createCell(2).setCellValue(book.getCploc());
			aRow.createCell(3).setCellValue(book.getKeyword());
			aRow.createCell(4).setCellValue(book.getCplink());
		}
		//  응답객체로 부터 다운로드 받을 타입과 파일 이름을 설정한다.
		response.setContentType("Application/Msexcel");
		response.setHeader("Content-Disposition", "attachment; filenname=기업리스트.xls"); 
	}

}
