package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath ="//*[@id=\"email\"]")
	public WebElement Username;
	
	@FindBy(xpath ="//*[@id=\"loginForm1\"]/div[2]/button")
	public WebElement Nxt_btn;	
	
	@FindBy(xpath ="//*[@id=\"loginForm2\"]/div[4]/button")
	public WebElement login_btn;
	
	
	@FindBy(xpath ="//*[@id=\"password\"]")
	public WebElement password_txt;
	
	public void Logi_user(String email , String password) 
	{
		setTextElementText(Username, email);
		clickButton(Nxt_btn);
		setTextElementText(password_txt, password);
		clickButton(login_btn);
	}
}
