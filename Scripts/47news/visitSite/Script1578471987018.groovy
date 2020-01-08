import java.nio.file.Path
import org.openqa.selenium.WebDriver
import com.kazurayam.materials.MaterialRepository
import com.kazurayam.visualtesting.ManagedGlobalVariable as MGV
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/**
 * Test Cases/47news/visitSite
 */
WebUI.comment("*** GlobalVariable[${MGV.CURRENT_TESTSUITE_ID.getName()}]=${GlobalVariable[MGV.CURRENT_TESTSUITE_ID.getName()]}")
WebUI.comment("*** GlobalVariable[${MGV.CURRENT_TESTSUITE_TIMESTAMP.getName()}]=${GlobalVariable[MGV.CURRENT_TESTSUITE_TIMESTAMP.getName()]}")
MaterialRepository mr = (MaterialRepository)GlobalVariable[MGV.MATERIAL_REPOSITORY.getName()]
assert mr != null
WebUI.openBrowser('')
WebUI.setViewPortSize(1280, 768)
WebDriver driver = DriverFactory.getWebDriver()

URL url = new URL("https://www.47news.jp/")

WebUI.navigateToUrl(url.toExternalForm())
WebUI.delay(5)
Path png1 = mr.resolveScreenshotPathByURLPathComponents(
					GlobalVariable[MGV.CURRENT_TESTCASE_ID.getName()],
					url,
					0,
					'home')
CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.takeEntirePage'(driver, png1.toFile(), 500)
WebUI.comment("saved image into ${png1}")
WebUI.closeBrowser()