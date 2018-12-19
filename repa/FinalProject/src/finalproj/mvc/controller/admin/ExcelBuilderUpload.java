package finalproj.mvc.controller.admin;

import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


@SuppressWarnings("resource")
public class ExcelBuilderUpload{

	protected String readExcel(String path, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 파일을 읽기위해 엑셀파일을 가져온다
		String filepath = path;
		System.out.println("ExcelPath :::" + filepath);
		FileInputStream fis = new FileInputStream(filepath);
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		int rowindex = 0;
		int columnindex = 0;
		String[] columnname = {"cpnum","cpname","cploc","keyword","cplink"};
		// 시트 수 (첫번째에만 존재하므로 0을 준다)
		// 만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
		HSSFSheet sheet = workbook.getSheetAt(0);
		// 행의 수
		int rows = sheet.getPhysicalNumberOfRows();
		StringBuffer sb = new StringBuffer();
		for (rowindex = 1; rowindex < rows; rowindex++) {
			// 행을 읽는다
			HSSFRow row = sheet.getRow(rowindex);
			if (row != null) {
				// 셀의 수
				int cells = row.getPhysicalNumberOfCells();
				for (columnindex = 0; columnindex <= cells; columnindex++) {
					// 셀값을 읽는다
					HSSFCell cell = row.getCell(columnindex);
					String value = "";
					// 셀이 빈값일경우를 위한 널체크
					if (cell == null) {
						continue;
					} else {
						// 타입별로 내용 읽기
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_FORMULA:
							value = cell.getCellFormula();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							value = cell.getNumericCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							value = cell.getBooleanCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							value = cell.getErrorCellValue() + "";
							break;
						}
					}
					if(columnindex == 0) {
						sb.append("{");
					}
					
					sb.append("\"").append(columnname[columnindex]).append("\":\"").append(value).append("\"");
					
					if(columnindex == 4) {
						sb.append("},");
					}else {
						sb.append(",");
					}
						System.out.println("각 셀 내용 :" + sb.toString());
					
				}
			}
		}
		return sb.toString();
	}
}
