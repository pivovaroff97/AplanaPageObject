import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.InitDrv;
import pageobject.TestData;
import pageobject.pages.BasketPage;
import pageobject.pages.DetroitPage;
import pageobject.pages.MainPage;
import pageobject.pages.PlayStationPage;

public class TestDNS {
    @Before
    public void openBrowser() {
        InitDrv.getDriver();
    }


    @Test
    public void pageObjectCU(){
        MainPage main = new MainPage();
        main.searhItems("playstation");

        PlayStationPage psp = new PlayStationPage();
        psp.actions();

        DetroitPage dp = new DetroitPage();
        dp.actions();

        BasketPage bp = new BasketPage();
        bp.actions();
    }

    @After
    public void closeBrowser() {
        //InitDrv.closeDriver();
    }
}
