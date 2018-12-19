package finalproj.mvc.controller.admin;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalproj.dto.CplistVO;
import finalproj.mvc.dao.adminDao.AdminDaoInter;


@SuppressWarnings("resource")
public class ExcelBuilderUpload{
	
	@SuppressWarnings("null")
	protected List<CplistVO> readExcel(String path, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// ������ �б����� ���������� �����´�
		String filepath = path;
		System.out.println("ExcelPath :::" + filepath);
		FileInputStream fis = new FileInputStream(filepath);
		
		List<CplistVO> list = new ArrayList<CplistVO>();
		CplistVO vo;
		String[] temp;
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int rowindex = 0;
		int columnindex = 0;
		String[] columnname = {"index","cpname","cpnum","cpapl","ratnum","yearmoney","cprel","cpmajor","cpceo","cpphone","ceomail","cploc","cpagree","cparrears"};
		// ��Ʈ �� (ù��°���� �����ϹǷ� 0�� �ش�)
		// ���� �� ��Ʈ�� �б����ؼ��� FOR���� �ѹ��� �����ش�
		XSSFSheet sheet = workbook.getSheetAt(0);
		// ���� ��
		
		int rows = sheet.getPhysicalNumberOfRows();
		StringBuffer sb = new StringBuffer();
		for (rowindex = 0; rowindex < rows; rowindex++) {
			// ���� �д´�
			XSSFRow row = sheet.getRow(rowindex);
			vo = new CplistVO();
			if (row != null) {
				// ���� ��
				int cells = row.getPhysicalNumberOfCells();
				for (columnindex = 0; columnindex <= cells; columnindex++) {
					// ������ �д´�
					XSSFCell cell = row.getCell(columnindex);
					String value = "";
					// ���� ���ϰ�츦 ���� ��üũ
					if (cell == null) {
						continue;
					} else {
						// Ÿ�Ժ��� ���� �б�
						switch (cell.getCellType()) {
						case XSSFCell.CELL_TYPE_FORMULA:
							value = cell.getCellFormula();
							break;
						case XSSFCell.CELL_TYPE_NUMERIC:
							value = cell.getNumericCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_BLANK:
							value = cell.getBooleanCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_ERROR:
							value = cell.getErrorCellValue() + "";
							break;
						}
					}
					
					switch (columnindex) {
					case 0:
						System.out.println(columnname[columnindex]+" ::: "+value);
						break;
					case 1:
						System.out.println(columnname[columnindex]+" ::: "+value);
						vo.setCpname(value);

						break;
					case 2:
						System.out.println(columnname[columnindex]+" ::: "+value);
						vo.setCpnum(value);
						
						break;
					case 3:
						System.out.println(columnname[columnindex]+" ::: "+value);
						vo.setCpapl(value);
						
						break;
					case 4:
						System.out.println(columnname[columnindex]+" ::: "+value);						
						temp = value.split("\\.");
						vo.setRatnum(Integer.valueOf(temp[0]).intValue());
						System.out.println(columnname[columnindex]+" ::: "+Integer.valueOf(temp[0]).intValue());
						
						break;
					case 5:
						System.out.println(columnname[columnindex]+" ::: "+value);
						if(value.equals("false")) {
							vo.setYearmoney(0);
						}else {
							temp = value.split("\\.");
							vo.setYearmoney(Integer.parseInt(temp[0]));
						}

						break;
					case 6:
						System.out.println(columnname[columnindex]+" ::: "+value);
						vo.setCprel(value);
						
						break;
					case 7:
						System.out.println(columnname[columnindex]+" ::: "+value);
						vo.setCpmajor(value);

						break;
					case 8:
						System.out.println(columnname[columnindex]+" ::: "+value);
						vo.setCpceo(value);
						
						break;
					case 9:
						System.out.println(columnname[columnindex]+" ::: "+value);
						vo.setCpphone(value);
						
						break;
					case 10:
						System.out.println(columnname[columnindex]+" ::: "+value);
						vo.setCeomail(value);
						
						break;
					case 11:
						System.out.println(columnname[columnindex]+" ::: "+value);
						vo.setCploc(value);
						
						break;
					case 12:
						System.out.println(columnname[columnindex]+" ::: "+value);
						vo.setCpagree(value);

						break;
					case 13:
						System.out.println(columnname[columnindex]+" ::: "+value);
						vo.setCparrears(value);
						
						break;

					default:
						break;
					}
					
					if(columnindex == 0) {
						sb.append("{");
					}
					
					sb.append("\"").append(columnname[columnindex]).append("\":\"").append(value).append("\"");
					
					if(columnindex == 13) {
						System.out.println(vo.getCpname());
						System.out.println("131313131313131313131313");
						sb.append("},");
						list.add(vo);
						
					}else {
						sb.append(",");
					}
					
				}
			}
		}
		System.out.println("�� �� ���� :" + sb.toString());
		return list;
	}
	
	
}
