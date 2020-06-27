package Tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import Pages.HomePage;
import Pages.RegisterationPage;

public class RegisterationTest extends TestBase
{

	HomePage HomeObject;
	RegisterationPage Register_page;
	
	// Import Faker Library for data driven to give different values for registeration form
	Faker fakerData = new Faker();	
	String FirstName = fakerData.name().firstName();
	String Email = fakerData.internet().emailAddress();
	String Password = fakerData.number().digits(9).toString();
	
	@Test()
	public void UserCanRegisterSuccssfully() 
	{
		// Take object from home page 
		HomeObject = new HomePage(driver); 
		
		// Verify that GoCardi Opened Successfully and Logo is appeard
	    boolean logo = HomeObject.GoCardi_is_Displayed();
	    driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	    if(logo)
	    {
	        Reporter.log("The GoCardi Website is Opened Successfully");

	    }
	    else 
	    {
	    	Reporter.log("The GoCardi Website isnot Opened Successfully");
		}
	    
	    // Convert from Arabic to English Language
		HomeObject.Click_English_Language();
		
		// Verify that the language is converted successfully
		String Change_Language = HomeObject.Contact_Us.getText();
	    if(Change_Language.contains("Contact Us"))
	    {
	        Reporter.log("The Language is Changed Successfully");
	    }
	    else 
	    {
	    	Reporter.log("The Language isnot Changed Successfully");
		}
	    
	    // Verify that The register Button is Clickable
		HomeObject.openRegistrationPage();
		
		// Take object from Registeration Page
		Register_page = new RegisterationPage(driver);
		
		// Verify That Registeration page is opened successfully
		String Open_Register_Page = Register_page.Registeration_Page.getText();
	    if(Open_Register_Page.contains("Join GOcardi!"))
	    {
	        Reporter.log("The Regiseration Page is Opened Successfully");
	    }
	    else 
	    {
	    	Reporter.log("The Regiseration Page isnot Opened Successfully");
		}
	    
	    // Fill The Textbxes with valid data
		Register_page.userRegistration(FirstName, "Jack" , Email, Password);
		
		// Verify That User is Registered to GoCardi
		String User_Registeration = Register_page.SuccessMessage.getText();
	    if(User_Registeration.contains("Registration Completed!"))
	    {
	        Reporter.log("The User is Registered Successfully Into The GoCardi");
	    }
	    else 
	    {
	    	Reporter.log("The User is Registered Successfully Into The GoCardi");
		}

		HomeObject.openRegistrationPage();
		
	    // Fill The Textbxes again with valid data without LastName
		Register_page.userRegistration(FirstName, "" , Email, Password);
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		
		// Verify That User isnot Registered to GoCardi and Validation Message appear for LastName Textbox
		String Forget_LastName = Register_page.ErrorMessage.getText();
	    if(Forget_LastName.contains("This field is required."))
	    {
	        Reporter.log("The User is Forgetten the last name value and validation mesage appears");
	    }
	    else 
	    {
	    	Reporter.log("The User isnot Forgetten the last name value and validation mesage appears");
		}
	}

}
