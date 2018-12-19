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

import finalproj.dto.TboardVO;
// 강사게시판_상세보기_엑셀다운로드
@SuppressWarnings("deprecation")
public class Teacher_ExcelBuilder extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<TboardVO> teacherboard_Detail = (List<TboardVO>)model.get("teacherboard_Detail");
		HSSFSheet sheet = workbook.createSheet("Show teacherboard_Detail");
		sheet.setDefaultColumnWidth(30);
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.GREEN.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);
		HSSFRow header = sheet.createRow(0);
		// ������ �� Ÿ��Ʋ
		String[] str = {"tbnum", "tbtitle", "tbdate", "tbfile", "tbcontent"};
		for(int i=0; i< str.length; i++) {
			header.createCell(i).setCellValue(str[i]);
			header.getCell(i).setCellStyle(style);
		}
		int rowCount = 1;
		// ���� ������ ä��
		for(TboardVO tboard : teacherboard_Detail) {
			HSSFRow aRow = sheet.createRow(rowCount++);
			aRow.createCell(0).setCellValue(tboard.getTbnum());
			aRow.createCell(1).setCellValue(tboard.getTbtitle());
			aRow.createCell(2).setCellValue(tboard.getTbdate());
			aRow.createCell(3).setCellValue(tboard.getTbfile());
			aRow.createCell(4).setCellValue(tboard.getTbcontent());
		}
		// ���� ��ü�� ���� �ٿ�ε� ���� Ÿ�԰� ���� �̸��� �����Ѵ�.
		response.setContentType("Application/Msexcel");
		response.setHeader("Content-Disposition", "attachment; filename=show_exce.xls;");
		
		
	}

}
