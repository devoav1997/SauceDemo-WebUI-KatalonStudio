package login

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

import internal.GlobalVariable
import com.kms.katalon.core.testobject.ConditionType

class LoginLocators {
	@Keyword
	static String txtUsername() {
		return '//input[@id="user-name"]'
	}
	@Keyword
	static String txtPassword() {
		return '//input[@id="password"]'
	}
	@Keyword
	static String btnLogin()    {
		return '//input[@id="login-button"]'
	}
	@Keyword
	static String lblError()    {
		return '//h3[@data-test="error"]'
	}

	@Keyword
	static TestObject makeLoginTO(String xpath) {
		TestObject to = new TestObject()
		to.addProperty('xpath', ConditionType.EQUALS, xpath)
		return to
	}
}
