package stepDefinitions;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.io.IOException;
import java.time.Duration;

import static utilities.Driver.isAppiumServerRunning;


public class HooksAppium {
    public static AppiumDriverLocalService server;


    @Before
    public void setUp() throws InterruptedException {

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder
//                .withAppiumJS(new File("C:\\Users\\Mustafa\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//                .usingDriverExecutable(new File("C:\\Users\\Mustafa\\.appium\\node_modules\\appium-reporter-plugin\\node_modules\\util-deprecate\\node.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withTimeout(Duration.ofSeconds(30));


        server = AppiumDriverLocalService.buildService(builder);

        server.start();


        int maxWaitTimeSeconds  = 120;
        int port = 4723;
        boolean serverStarted = false;

        for (int i = 0; i < maxWaitTimeSeconds; i += 5) {
            if (isAppiumServerRunning("localhost", port)) {
                serverStarted = true;
                break;
            } else {
                Thread.sleep(5000); // 5 saniye bekleyin ve tekrar kontrol edin
            }
        }

        if (serverStarted) {
            System.out.println("Appium sunucusu başarıyla başlatıldı ve bağlandı.");
        } else {
            System.out.println("Appium sunucusu başlatılamadı veya bağlantı sağlanamadı.");
        }

    }


    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png", "screenshots");
        }
        Driver.quitAppiumDriver();
    }

    public void forceStopAppiumServer() {

        try {
            Runtime.getRuntime().exec("taskkill /F /IM node.exe");
            Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}