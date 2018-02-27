package com.stylefeng.guns.modular.adverse.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class ExcelUtils {

	/**
	 * @param list
	 * @param title2Key
	 * @return
	 * @throws IOException
	 */
	public static byte[] buildBytes(List<Map<String, Object>> list,final Map<String,String> title2Key) throws IOException {
    	ByteArrayOutputStream bo=null;
    	byte[] bytes=null;
    	try {
    		bo=buildFile(list,title2Key);
        	bytes=bo.toByteArray();
        	return bytes;
    	}finally {
    		if(null!=bo) {
    			bo.close();
    		}
    	}

	}

    /**
     * @param list
     * @param title2Key
     * @return
     * @throws IOException
     */
    public static ByteArrayOutputStream buildFile(List<Map<String, Object>> list,final Map<String,String> title2Key) throws IOException {

		Workbook wb = null;
		try {
			wb=new SXSSFWorkbook(100);
			Sheet sheet = wb.createSheet("new sheet");

			int rowNum=0;//Rows are 0 based.

			Set<String> titles=title2Key.keySet();
			Row titleRow=sheet.createRow(rowNum++);
			int columnNum=0;
			for(String title:titles) {
				Cell cell = titleRow.createCell(columnNum++);
				cell.setCellValue(title);
			}

			for (Map<String,Object> rowData:list) {
				Row row=sheet.createRow(rowNum++);
				int dataColumnNum=0;
				for(String title:titles) {
					String key=title2Key.get(title);
					Object columnValue=rowData.get(key);
					Cell cell = row.createCell(dataColumnNum++);
					if(null==columnValue) {
						cell.setCellValue("");
					}else {
						cell.setCellValue(columnValue.toString());
					}
				}
			}

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			wb.write(out);

			return out;
		}finally {
			if(null!=wb) {
				wb.close();
			}
		}
    }
}
