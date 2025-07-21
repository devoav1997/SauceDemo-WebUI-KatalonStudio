package checkout

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testobject.ConditionType

class CheckoutLocators {
	@Keyword
	static String btnCheckout()  {
		return '//button[@id="checkout"]'
	}
	@Keyword
	static String txtFirstName() {
		return '//input[@id="first-name"]'
	}
	@Keyword
	static String txtLastName()  {
		return '//input[@id="last-name"]'
	}
	@Keyword
	static String txtZip()       {
		return '//input[@id="postal-code"]'
	}
	@Keyword
	static String btnContinue()  {
		return '//input[@id="continue"]'
	}
	@Keyword
	static String btnFinish()    {
		return '//button[@id="finish"]'
	}
	@Keyword
	static String lblSuccess()   {
		return '//h2[text()="Thank you for your order!"]'
	}
	@Keyword
	static String lblError()     {
		return '//h3[@data-test="error"]'
	} // error message pada form checkout

	@Keyword
	static TestObject makeCheckoutTO(String xpath) {
		TestObject to = new TestObject()
		to.addProperty('xpath', ConditionType.EQUALS, xpath)
		return to
	}
}

