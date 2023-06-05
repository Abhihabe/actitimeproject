package com.Actitime.genericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class is generic class which contains all the generic method.
 * @author Admin abhi
 *
 */
public class FileLibrary {
	/**
	 * this method is generic method which is used to read data from property file.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readData_FromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./Testdata/commondata.property");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	/**
	 * this method is generic method which is used to read data from excel sheet
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readData_FromExcel(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./Testdata/Testdata1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	

}
