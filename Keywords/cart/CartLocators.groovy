package cart

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

class CartLocators {
	@Keyword
	static String btnAddToCart(String itemName) {
		return "//div[text()='$itemName']/ancestor::div[@class='inventory_item']//button[starts-with(@id, 'add-to-cart')]"
	}
	@Keyword
	static String btnRemoveFromCart(String itemName) {
		// Format id: remove-sauce-labs-backpack
		def id = 'remove-' + itemName.toLowerCase()
				.replaceAll(' ', '-')
				.replaceAll('[^a-z0-9\\-]', '')
		return "//button[@id='${id}']"
	}
	@Keyword
	static String icnCartBadge() {
		return '//span[@class="shopping_cart_badge"]'
	}
	@Keyword
	static String lnkCart()      {
		return '//a[@class="shopping_cart_link"]'
	}

	@Keyword
	static TestObject makeCartTO(String xpath) {
		TestObject to = new TestObject()
		to.addProperty('xpath', ConditionType.EQUALS, xpath)
		return to
	}
}

