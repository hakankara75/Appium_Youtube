package androidScreen;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.net.MalformedURLException;

public class DragAndDropScreen extends ApiDemosScreen{
    public DragAndDropScreen() throws MalformedURLException {
    }
    @FindBy(id = "com.touchboarder.android.api.demos:id/drag_dot_1")
    public WebElement firstDot;

    @FindBy(id = "com.touchboarder.android.api.demos:id/drag_dot_2")
    public WebElement secondDot;

    @FindBy(id = "com.touchboarder.android.api.demos:id/drag_dot_3")
    public WebElement thirdDot;

    @FindBy(id = "com.touchboarder.android.api.demos:id/drag_dot_hidden")
    public WebElement fourthDot;


}
