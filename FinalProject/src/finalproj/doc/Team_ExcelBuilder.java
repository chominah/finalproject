package finalproj.doc;

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

import finalproj.dto.SboardVO;
import finalproj.dto.TboardVO;
import finalproj.dto.TeacherVO;
// 팀게시판_상세보기_엑셀다운로드
@SuppressWarnings("deprecation")
public class Team_ExcelBuilder extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, 
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<SboardVO> teamboard_Detail = (List<SboardVO>)model.get("teamboard_Detail");
		HSSFSheet sheet = workbook.createSheet("Show Teamboard_Detail");
		sheet.setDefaultColumnWidth(30);
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.GOLD.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);
		HSSFRow header = sheet.createRow(0);
		// ������ �� Ÿ��Ʋ
		String[] str = {"bnum", "btitle", "bdate", "bfile", "bcontent"};
		for(int i=0; i< str.length; i++) {
			header.createCell(i).setCellValue(str[i]);
			header.getCell(i).setCellStyle(style);
		}
		int rowCount = 1;
		// ���� ������ ä��
		for(SboardVO sboard : teamboard_Detail) {
			HSSFRow aRow = sheet.createRow(rowCount++);
			aRow.createCell(0).setCellValue(sboard.getBnum());
			aRow.createCell(1).setCellValue(sboard.getBtitle());
			aRow.createCell(2).setCellValue(sboard.getBdate());
			aRow.createCell(3).setCellValue(sboard.getBfile());
			aRow.createCell(4).setCellValue(sboard.getBcontent());
		}
		// ���� ��ü�� ���� �ٿ�ε� ���� Ÿ�԰� ���� �̸��� �����Ѵ�.
		response.setContentType("Application/Msexcel");
		response.setHeader("Content-Disposition", "attachment; filename=show_exce.xls;");
		
		
	}

}
