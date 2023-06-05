package com.Actitime.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.genericLibrary.Baseclass;
import com.Actitime.genericLibrary.FileLibrary;
import com.Actitime.pom.HomePage;
import com.Actitime.pom.TaskPage;

public class CreateCustomer extends Baseclass {
	
	@Test
	public void createcustomer() throws EncryptedDocumentException, IOException {
		HomePage h=new HomePage(driver);
		h.getTasktab().click();
		TaskPage tp = new TaskPage(driver);
		tp.getAddnewtbn().click();
		tp.getNewcust().click();
		FileLibrary fl= new FileLibrary();
		String customer = fl.readData_FromExcel("Data", 2, 1);
		tp.getCustname().sendKeys(customer);
		String description = fl.readData_FromExcel("Data", 2, 2);
		tp.getCustdes().sendKeys(description);
		tp.getCreatebtn().click();
		String expectedresult = customer;
		 String actualresult = driver.findElement(By.xpath("(//div[.='"+customer+"'])[2]")).getText();
		 SoftAssert s= new SoftAssert();
		 s.assertEquals(expectedresult, actualresult);
	}

}
