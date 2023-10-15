package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.time.Duration;

public class Driver {
    private static UiAutomator2Options options;
    static AppiumDriver driver;

    public static AppiumDriver getDriver() {

        if (driver == null) {

            switch (ConfigReader.getProperty("platformName")) {
                case "Android":
                  options = new UiAutomator2Options();


             //  options.setApp(ConfigReader.getProperty("app"));
               options.setApp(ConfigReader.getProperty("app"));

//                   options.setAppPackage("com.mobisoft.kitapyurdu");  //Uygulama paketi adini ayarlar
//                   options.setAppActivity("com.mobisoft.kitapyurdu.main.MainActivity"); //Uygulama aktivite adini ayarla

                    options.setDeviceName(ConfigReader.getProperty("device"));    //Cihaz UDID'sini ayarla bu kodu cmd'de "adb devices" yazarak buluruz
                    options.setNoReset(true);   //sifirlama islemini kapat
                    options.setCapability("shouldTerminateApp", true);   // appi kapatmak için
                    options.setNewCommandTimeout(Duration.ofSeconds(15));   //yeni komut zaman asimini ayarla
                    break;
                case "IOS":
                    // IOS için ayarlar
                    break;
                default:
                    throw new RuntimeException("Desteklenmeyen Platform: " + ConfigReader.getProperty("platformName"));
            }

            boolean driverCreated = false;
            int maxAttempts = 5;
            int attempt = 0;

            do {
                try {
                    System.out.println("Deneme #" + (attempt + 1));
                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
                    driverCreated = true;
                    System.out.println("Android baglandi, driver atandi");
                } catch (MalformedURLException ignored) {

                }

                if (!driverCreated) {
                    System.out.println("Bekleme ve yeniden deneme...");
                    attempt++;
                    if (attempt >= maxAttempts) {
                        throw new RuntimeException("Belirtilen sayida deneme yapildi, driver olusturulamadi.");
                    }
                    // Gerekirse bir bekleme süresi ekleyebilirsiniz.
                    // Thread.sleep(2000);
                }
            } while (!driverCreated);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
        return driver;
    }

    public static boolean isAppiumServerRunning(String host, int port) {
        try (Socket socket = new Socket(host, port)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void quitAppiumDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

