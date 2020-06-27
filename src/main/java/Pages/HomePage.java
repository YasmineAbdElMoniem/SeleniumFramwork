package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase
{
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath="//*[@id=\"page-content-wrapper\"]/header/nav[1]/div/div[1]/ul/li[3]/a")
	WebElement English_Language;
	
	@FindBy(xpath="//*[@id=\"page-content-wrapper\"]/header/nav[1]/div/div[1]/ul/li[1]/a")
	WebElement Register_Link;
	
	@FindBy(xpath ="//*[@id=\"page-content-wrapper\"]/header/nav[1]/div/div[2]/div/a/span")
	public WebElement Contact_Us;
	
	@FindBy(xpath = "//*[@id=\"page-content-wrapper\"]/header/nav[2]/div/div[1]/a[2]/img")
	WebElement GoCardi_Logo;
	
	public void Click_English_Language() 
	{
		clickButton(English_Language);
	}
		
	public void openRegistrationPage() 
	{
		clickButton(Register_Link);
	}
	
	public boolean GoCardi_is_Displayed() 
	{
		boolean x = false;
		if (GoCardi_Logo.isDisplayed()) 
		{
			x = true;
		}
		return x ;
		
	}
	
}
