package Runer;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.CreateDepotAccount;
import Pages.Home;
import Sites.PageObjectModelFrameWork.Base;

public class HomeDepotTest extends Base {
  @Test(priority = 1)
  public void Verification() {
	  Home home=new Home(driver);
	  String MyAccountText=home.MyAccountTextVerification();
	  SoftAssert softAsser=new SoftAssert();
	  softAsser.assertEquals(MyAccountText, "My Account");
	  String YOurSHoppingText=home.YourShoppingTextVerification();
	  YOurSHoppingText=YOurSHoppingText.trim();
	  System.out.println(YOurSHoppingText);
	  softAsser.assertEquals(YOurSHoppingText, "You're shopping Leesburg OPEN until 8 pm");
	  String FindStoreText=home.StoreFinderTextVerification();
	  softAsser.assertEquals(FindStoreText, "Store Finder");
	  softAsser.assertAll();
  }
  @Test(priority = 2)
  public void CreateTheAccount() {
	  Home home=new Home(driver);
	  home.MyAccountClick();
	  home.Registerbutton();
CreateDepotAccount dt = new CreateDepotAccount(driver);
	    String createAccountText = dt.createAnAccountVerification();
	    SoftAssert SoftAssert=new SoftAssert();
	    SoftAssert.assertEquals(createAccountText, "Create an Account");
	    boolean lk = dt.linkds();
	    SoftAssert.assertEquals(lk, true);
	    boolean click = dt.createButtonClickable();
	    SoftAssert.assertEquals(click, false);
	    dt.email("sl@gmail.com");
	    dt.passwrd("testinghome258*");
	    dt.phoneNumber("7181234567");
	    dt.zipCode("11001");
	    dt.createButtonAccount();
	    }
	 

  }

