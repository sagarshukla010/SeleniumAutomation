package test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import java.util.logging.*;

public class APMTesting 
{
	static Properties prop = new Properties();
	static WebDriver driver; 
	static String Filehand;
	static String DriverLocation;
	static String URL;
	//static String ConfigLocation;
	
	public static void main(String[] args) throws InterruptedException, Exception, Exception 
	{
		try 
		{
			
			InputStream input = new FileInputStream("C:\\Users\\sagar\\workspace\\SeleniumAutomation\\src\\test\\sagar.properties");
		    prop.load(input);
		  
		
		 Filehand = prop.getProperty("Filehand");
		 DriverLocation = prop.getProperty("DriverLocation");
		 URL = prop.getProperty("URL");
		 //ConfigLocation = prop.getProperty("ConfigLocation");
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		FileHandler APM = new FileHandler(Filehand,true);
	    Logger APM2 = Logger.getLogger("src");
		APM2.addHandler(APM);
		
		
		System.setProperty("webdriver.chrome.driver",DriverLocation);
		 driver = new ChromeDriver();
		 
		
		 XSSFWorkbook workbook = new XSSFWorkbook();
		  	XSSFSheet sheet = workbook.createSheet("Java Books");
		  	int rowCount=0;
		 	int cellnum=0;
					
					driver.get(URL);
					driver.manage().window().maximize();
					
					driver.findElement(By.xpath("//input[@name='name']")).sendKeys("SAGAR SHUKLA");
					
					driver.findElement(By.xpath("//*[@id=\'Day\']")).clear();
					
					driver.findElement(By.xpath("//*[@id=\'Day\']")).sendKeys("20");
					
					driver.findElement(By.xpath("//*[@id=\'Month\']")).clear();
					
					driver.findElement(By.xpath("//*[@id=\'Month\']")).sendKeys("08");
					
					driver.findElement(By.xpath("//*[@id=\'Year\']")).clear();
					
					driver.findElement(By.xpath("//*[@id=\'Year\']")).sendKeys("1997");
					
					driver.findElement(By.xpath("//*[@id=\'hrs\']")).clear();
					
					driver.findElement(By.xpath("//*[@id=\'hrs\']")).sendKeys("12");
					
					driver.findElement(By.xpath("//*[@id=\'min\']")).clear();
					
					driver.findElement(By.xpath("//*[@id=\'min\']")).sendKeys("45");
					
					driver.findElement(By.xpath("//*[@id=\'sec\']")).clear();
					
					driver.findElement(By.xpath("//*[@id=\'sec\']")).sendKeys("00");
					
					driver.findElement(By.xpath("//input[@name='place']")).sendKeys("Jabalpur");
					driver.findElement(By.xpath("//input[@name='place']")).sendKeys(Keys.ENTER);
					driver.findElement(By.xpath("//*[@id=\"UserCityDetailsForm\"]/div/div[2]/table/tbody/tr[2]/td[1]/a")).click();
					driver.findElement(By.xpath("//*[@id=\"slide-out\"]/li[1]/ul/li[6]/a/span")).click();
					WebElement tab = driver.findElement(By.xpath("//*[@id=\"slide-out\"]/li[1]/ul/li[6]/div/ul/li[9]/a"));
					
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView(true);", tab);
					
					try 
					{
						Thread.sleep(1000);
					}
					catch(Exception ex) 
					{
						ex.printStackTrace();
					}
					
					driver.findElement(By.xpath("//*[@id=\"slide-out\"]/li[1]/ul/li[6]/div/ul/li[9]/a")).click();
					//No of columns
					List<?>  col = driver.findElements(By.xpath("//*[@id=\"main-content\"]/div[2]/div/div/table/tbody/tr[1]/td"));
			       
					List<?>  col1 = driver.findElements(By.xpath("//*[@id=\"main-content\"]/div[3]/div/div/table/thead/tr/td"));
					
				List<?>  col2 = driver.findElements(By.xpath("//*[@id=\"main-content\"]/div[3]/div/div/table/tbody/tr[1]/td"));
					
					APM2.info("No of cols are : " +col.size()); 
			        
			        //No.of rows 
		         List<?>  rows = driver.findElements(By.xpath("//*[@id=\"main-content\"]/div[2]/div/div/table/tbody/tr")); 
		        
		         List<?>  rows1 = driver.findElements(By.xpath("//*[@id=\"main-content\"]/div[3]/div/div/table/thead/tr/td[1]")); 
		         
		         List<?>  rows2 = driver.findElements(By.xpath("//*[@id=\"main-content\"]/div[3]/div/div/table/tbody/tr"));
		         
		         APM2.info("No of rows are : " + rows.size());
		
		         for(int i=1; i<=(rows.size());i++)
		     	{
		     		Row row = sheet.createRow(rowCount++);
		     		cellnum = 0;
		     		for(int j=1;j<=(col.size());j++)
		     		{
		     			Cell c= row.createCell(cellnum++);
		     			String data = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/div/table/tbody/tr["+i+"]/td["+j+"]")).getText();
		     			c.setCellValue(data);
		     			CellStyle cs = workbook.createCellStyle();
		     			cs.setWrapText(true);
		     			c.setCellStyle(cs);
		     	    }
		     	} 
		         
		         rowCount+=4;
		         
		         for(int i=1; i<=(rows1.size());i++)
			     	{
			     		Row row1 = sheet.createRow(rowCount++);
			     		cellnum = 0;
			     		for(int j=1;j<=(col1.size());j++)
			     		{
			     			Cell c1= row1.createCell(cellnum++);
			     			String data = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[3]/div/div/table/thead/tr["+i+"]/td["+j+"]")).getText();
			     			c1.setCellValue(data);
			     			CellStyle cs = workbook.createCellStyle();
			     			cs.setWrapText(true);
			     			c1.setCellStyle(cs);
			     	    }
			     	} 
		         
		         for(int i=1; i<=(rows2.size());i++)
			     	{
			     		Row row2 = sheet.createRow(rowCount++);
			     		cellnum = 0;
			     		for(int j=1;j<=(col2.size());j++)
			     		{
			     			Cell c2 = row2.createCell(cellnum++);
			     			String data = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[3]/div/div/table/tbody/tr["+i+"]/td["+j+"]")).getText();
			     			c2.setCellValue(data);
			     			CellStyle cs = workbook.createCellStyle();
			     			cs.setWrapText(true);
			     			c2.setCellStyle(cs);
			     	    }
			     	} 
		         
		     FileOutputStream out = new FileOutputStream(new File("E:\\APMDataExcel.xlsx"));
		     			workbook.write(out);
		     			out.close();
		     			workbook.close();
		     			APM2.info("Written Successfully");
		     			System.out.println("**");
		     			
	              }
              }


