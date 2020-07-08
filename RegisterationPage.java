package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterationPage extends PageBase 
{
	public RegisterationPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(id ="firstname")
	WebElement FN_TxtBox;

	@FindBy(id ="lastname")
	WebElement LN_TxtBox;

	@FindBy(id ="email")
	WebElement Email;

	@FindBy(id ="password")
	WebElement Password;

	@FindBy(css ="#checkbox1")
	WebElement Privacy_Policy_CheckBox;

	@FindBy(css ="#checkbox2")
	WebElement recommendations_CheckBox;

	@FindBy(xpath ="//*[@id=\"signupForm\"]/div[7]/button")
	WebElement Register_Button;//
	
	
	@FindBy(xpath ="//*[@id=\"page-content-wrapper\"]/div[2]/div/div/div/div/div[1]/h2")
	public WebElement SuccessMessage;
	
	@FindBy(xpath ="//*[@id=\"lastname-error\"]")
	public WebElement ErrorMessage;
	
	@FindBy(xpath ="//*[@id=\"page-content-wrapper\"]/div[2]/div/div[1]/div[1]/h3")
	public WebElement Registeration_Page;
	

	public void userRegistration(String firstName , String lastName , String email , String password) 
	{
		setTextElementText(FN_TxtBox, firstName);
		setTextElementText(LN_TxtBox, lastName);
		setTextElementText(Email, email);
		setTextElementText(Password, password);
		clickButton(Privacy_Policy_CheckBox);
		clickButton(recommendations_CheckBox);
		clickButton(Register_Button);
	}
	
}
