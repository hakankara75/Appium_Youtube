package androidScreen;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Puzzle_Yapboz_Screen extends KitapYurdu{

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.mobisoft.kitapyurdu:id/icon'])[3]")
    public WebElement kategoriler;
    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.mobisoft.kitapyurdu:id/imageView'])[6]")
    public WebElement puzzleYapboz;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Tüm Kategoriler\")")
    public WebElement tumKategoriler;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Puzzle - Yapboz\")")
    public WebElement puzzleYapbozTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Ahşap Puzzle \")")
    public WebElement ahsapPuzzleMenu;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Ahşap Puzzle \")")
    public WebElement ahsapPuzzleTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"300 Parça\")")
    public WebElement ucyuzParcaTitle;
    @FindBy( xpath= "(//android.view.ViewGroup[@resource-id='com.mobisoft.kitapyurdu:id/btnCategoryName'])[14]")
    public WebElement ucyuzParcaMenu;
    @FindBy( xpath= "//android.widget.TextView[@text='Lava']")
    public WebElement lava;
    @AndroidFindBy( uiAutomator= "new UiSelector().text(\"Çocuk Puzzle\")")
    public WebElement cocukPuzzle;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Çocuk Puzzle\")")
    public WebElement cocukPuzzleTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"6-48 PARÇA\")")
    public WebElement altiKirksekizParca;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"6-48 PARÇA\")")
    public WebElement altiKirksekizParcaTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Ahşap Puzzle (1000 Parça)\")")
    public WebElement ahsapBinParca;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Ahşap Puzzle (1000 Parça)\")")
    public WebElement ahsapBinParcaText;
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id='com.mobisoft.kitapyurdu:id/productImage'])[1]")
    public WebElement kaplumbagaTerbiyecisi;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Türk Sanatı Serisi\")")
    public WebElement turkSanatEseri;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Türk Sanatı Serisi\")")
    public WebElement turkSanatEseriText;
}
