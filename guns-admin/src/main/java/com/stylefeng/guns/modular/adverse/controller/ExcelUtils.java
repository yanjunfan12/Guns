package com.stylefeng.guns.modular.adverse.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
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
	 *
	 */
	public static final Map<String,String> TITLE_2_KEY=new LinkedHashMap<String,String>();
	static {
		TITLE_2_KEY.put("主键id", "id");
		TITLE_2_KEY.put("住院号", "patientNumber");
		TITLE_2_KEY.put("姓名", "name");
		TITLE_2_KEY.put("放疗次数 ", "radiotherapyCount");
		TITLE_2_KEY.put("化疗次数", "chemotherapyCount");
		TITLE_2_KEY.put("体重", "weight");
		TITLE_2_KEY.put("目前饮食", "dietaryStatusName");
		TITLE_2_KEY.put("乏力", "weakStatus");
		TITLE_2_KEY.put("恶心", "nauseaStatus");
		TITLE_2_KEY.put("呕吐", "vomitStatus");
		TITLE_2_KEY.put("腹泻", "diarrheaStatus");
		TITLE_2_KEY.put("便秘", "constipationStatus");
		TITLE_2_KEY.put("肌肉关节痛", "muscleJointPainStatus");
		TITLE_2_KEY.put("神经系统", "nervousSystemStatus");
		TITLE_2_KEY.put("脱发", "alopeciaStatus");
		TITLE_2_KEY.put("发热", "feverStatus");
		TITLE_2_KEY.put("咳嗽", "coughStatus");
		TITLE_2_KEY.put("放射性皮肤损伤", "skinStatus");
		TITLE_2_KEY.put("打嗝", "hiccupStatus");
		TITLE_2_KEY.put("口腔黏膜炎", "oralMucositisStatus");
		TITLE_2_KEY.put("声嘶 ", "hoarsenessStatus");
		TITLE_2_KEY.put("听力损伤", "hearingStatus");
		TITLE_2_KEY.put("头晕 ", "dizzyStatus");
		TITLE_2_KEY.put("头痛  ", "headacheStatus");
		TITLE_2_KEY.put("肺炎", "pneumoniaStatus");
		TITLE_2_KEY.put("进食痛 （食管炎） ", "esophagitisStatus");
		TITLE_2_KEY.put("其他症状", "otherStatusesDesc");
		TITLE_2_KEY.put("填表日期", "createtime");
		TITLE_2_KEY.put("修改日期", "updatetime");

	}

	/**
	 * @param list
	 * @return
	 * @throws IOException
	 */
	public static byte[] buildBytes(List<Map<String, Object>> list) throws IOException {
    	ByteArrayOutputStream bo=null;
    	byte[] bytes=null;
    	try {
    		bo=buildFile(list);
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
     * @return
     * @throws IOException
     */
    public static ByteArrayOutputStream buildFile(List<Map<String, Object>> list) throws IOException {

		Workbook wb = null;
		try {
			wb=new SXSSFWorkbook(100);
			Sheet sheet = wb.createSheet("new sheet");

			int rowNum=0;//Rows are 0 based.

			Set<String> titles=TITLE_2_KEY.keySet();
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
					String key=TITLE_2_KEY.get(title);
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
