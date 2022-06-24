import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ComputerDatabasePage;
import pages.Osdatapage;

public class MyStepdefs {

    WebDriver driver;
       ComputerDatabasePage  computerDatabasePage;
       Osdatapage  osdatapage;
    @Before
    public void start(){
        driver = TestRunner.driver;
        computerDatabasePage = new ComputerDatabasePage(driver);
        osdatapage = new Osdatapage(driver);
    }

    @Given("^Admin is in landing page$")
    public void adminIsInLandingPage() {
        Assert.assertTrue(driver.findElement((By.name("username"))).isDisplayed());
    }



    @Then("he should logout")
    public void heShouldLogout() {
        driver.navigate().to("https://computer-database.gatling.io/computers");
           }

    @Given("admin is in create computer page")
    public void adminIsInCreateComputerPage() {
        computerDatabasePage.addNewComputer.click();
        driver.manage().window().maximize();
    }

    @When("he creates the computer with fields {string},{string},{string}")
    public void heCreatesTheComputerWithFields(String computername, String introduced, String company) {

       computerDatabasePage.AddaNewComputer(computername,introduced,company);


    }

    @Then("the computer created is displayed")
    public void theComputerCreatedIsDisplayed() {
        computerDatabasePage.searchBox.sendKeys("");
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Acer Iconia')]")).isDisplayed());
    }

    @Then("the computer created is displayed {string}")
    public void theComputerCreatedIsDisplayed(String computername) {

        computerDatabasePage.searchBox.sendKeys(computername);
        computerDatabasePage.filterButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Acer Iconia')]")).isDisplayed());
    }

    @When("he searches and edit {string}")
    public void heSearchesAndEdit(String computername) {
        computerDatabasePage.searchBox.sendKeys(computername);
        computerDatabasePage.filterButton.click();
        driver.findElement(By.xpath("//a[contains(text(),'Acer Iconia')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Edit computer')]")).isDisplayed());
        computerDatabasePage.computernameLocator.sendKeys("ABC");
        computerDatabasePage.createComputerbtn.click();

    }

    @Then("the computer details are updated")
    public void theComputerDetailsAreUpdated() {
        Assert.assertTrue((computerDatabasePage.createmessage).isDisplayed());
        Assert.assertEquals((computerDatabasePage.createmessage).getText(),"Done ! Computer Acer IconiaABC has been updated");
    }

    @Given("admin is in computer landing page")
    public void adminIsInComputerLandingPage() {
        driver.get(Constants.URL);
    }

    @When("user searches and delete {string}")
    public void userSearchesAndDelete(String computername) {
        computerDatabasePage.searchBox.sendKeys(computername);
        computerDatabasePage.filterButton.click();
        driver.findElement(By.xpath("//a[contains(text(),'Acer Iconia')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Edit computer')]")).isDisplayed());
        computerDatabasePage.deleteBtn.click();
            }

    @Then("user deletes the data")
    public void userDeletesTheData() {
        Assert.assertTrue((computerDatabasePage.createmessage).isDisplayed());
        Assert.assertEquals((computerDatabasePage.createmessage).getText(),"Done ! Computer Acer Iconia has been deleted");
    }

    @Given("navigate to the os page and accept cookies")
    public void navigateToTheOsPageAndAcceptCookies() {
        osdatapage.acceptBtn.click();
    }

    @And("user clicks on docs option displayed in the page")
    public void userClicksOnDocsOptionDisplayedInThePage() {
        osdatapage.docs.click();
    }

    @Then("check user is on documentation page")
    public void checkUserIsOnDocumentationPage() {
        String a = osdatapage.documentation.getText();
        String b = "Documentation";
        Assert.assertEquals(a,b);
    }

    @And("user verifies the page elements displayed in the page")
    public void userVerifiesThePageElementsDisplayedInThePage() {

        Assert.assertTrue(osdatapage.osDownloadapiLink.isDisplayed());

        Assert.assertTrue(osdatapage.osDownloadapisection.isDisplayed());

        osdatapage.osDownloadapiLink.click();

        Assert.assertTrue(osdatapage.osdownloadlink.isDisplayed());

    }
}
