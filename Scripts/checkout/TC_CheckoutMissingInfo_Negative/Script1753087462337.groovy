import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import login.LoginLocators as L
import cart.CartLocators as C
import checkout.CheckoutLocators as CO

String itemName = 'Sauce Labs Backpack'

WebUI.openBrowser(GlobalVariable.baseUrl)
WebUI.setText(L.makeLoginTO(L.txtUsername()), GlobalVariable.stdUser)
WebUI.setText(L.makeLoginTO(L.txtPassword()), GlobalVariable.stdPass)
WebUI.click(L.makeLoginTO(L.btnLogin()))

WebUI.click(C.makeCartTO(C.btnAddToCart(itemName)))
WebUI.click(C.makeCartTO(C.lnkCart()))
WebUI.click(CO.makeCheckoutTO(CO.btnCheckout()))

// Field first name dikosongkan
WebUI.setText(CO.makeCheckoutTO(CO.txtFirstName()), '')
WebUI.setText(CO.makeCheckoutTO(CO.txtLastName()), 'QA')
WebUI.setText(CO.makeCheckoutTO(CO.txtZip()), '12345')
WebUI.click(CO.makeCheckoutTO(CO.btnContinue()))

WebUI.verifyElementPresent(CO.makeCheckoutTO(CO.lblError()), 3)
WebUI.closeBrowser()

