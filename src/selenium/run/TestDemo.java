package selenium.run;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDemo {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");//chromedriver�����ַ
        WebDriver driver =new ChromeDriver(); //�½�һ��WebDriver �Ķ��󣬵���new ����FirefoxDriver������
        
        try {
        	
        	driver.get("http://www.baidu.com");//��ָ������վ
            driver.findElement(By.id("kw")).sendKeys(new  String[] {"hello"});//�ҵ�kwԪ�ص�id��Ȼ������hello
            int i = 9/0;
            driver.findElement(By.id("su")).click(); //�����Ť
            
            /**
             * WebDriver�Դ���һ�����ܵȴ��ķ�����
            dr.manage().timeouts().implicitlyWait(arg0, arg1����
            Arg0���ȴ���ʱ�䳤�ȣ�int ���� ��
            Arg1���ȴ�ʱ��ĵ�λ TimeUnit.SECONDS һ��������Ϊ��λ��
             */
        	
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);        
        } catch (Exception e) {
            e.printStackTrace();
            
            // ��ӡ�쳣ԭ�򣬿���̨Ҳ���ӡ
			System.out.println("======exception reason=======" + e);
			//ͼƬ���Ƽ�ʱ���
			String dateString = getDateFormat();
			
			// getScreenshotAs()�Ե�ǰ���ڽ��н�ͼ
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// ��Ҫָ��ͼƬ�ı���·�����ļ���
			FileUtils.copyFile(srcFile, new File("D:\\seleniumErro\\" + dateString + ".png"));
			e.printStackTrace();
        }
        /**
         * dr.quit()��dr.close()�������˳������,�򵥵�˵һ�����ߵ����𣺵�һ��close��
         * ������˶��ҳ���ǹز��ɾ��ģ���ֻ�رյ�ǰ��һ��ҳ�档�ڶ���quit��
         * ���˳�������Webdriver���еĴ��ڣ��˵ķǳ��ɾ��������Ƽ�ʹ��quit��Ϊһ��case�˳��ķ�����
         */
        driver.quit();//�˳������
        
	}
	
	
	
	
	public static String getDateFormat(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String dateString = sdf.format(date);
		return dateString;
	}


}
