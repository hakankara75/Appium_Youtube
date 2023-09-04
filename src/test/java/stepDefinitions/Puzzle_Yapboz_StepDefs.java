package stepDefinitions;

import androidScreen.Puzzle_Yapboz_Screen;
import androidScreen.Screens;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;
import static utilities.ReusableMethods.*;


public class Puzzle_Yapboz_StepDefs extends Screens {

    Puzzle_Yapboz_Screen kitapYurdu=new Puzzle_Yapboz_Screen();

    public Puzzle_Yapboz_StepDefs() throws MalformedURLException {
    }
    @Given("Kitap Yurdu sitesine gidildi")
    public void kitap_yurdu_sitesine_gidildi() {
        Driver.getDriver();
    }
    @Then("Kitap Yurdu sitesine gidildigi dogrulandi")
    public void kitap_yurdu_sitesine_gidildigi_dogrulandi() {

        assertTrue(kitapYurdu.logo.isDisplayed());
    }

    @When("Kategoriler ikonu tiklandi")
    public void kategoriler_ikonu_tiklandi() {
        kitapYurdu.kategoriler.click();
    }
    @And("{string} bolumunde oldugu dogrulandi")
    public void bolumundeOlduguDogrulandi(String string) {
        switch (string){
            case "Kategoriler":
                kitapYurdu.tumKategoriler.getText().contains("Kategoriler");
                break;
                case "Şehirler ve Yapılar Serisi":
                kitapYurdu.sehirlerYapilarTitle.getText().contains("Kategoriler");
                break;
                case "Puzzle Yapboz":
               kitapYurdu.puzzleYapbozTitle.getText().contains("Puzzle");
                break;
            case "Ahşap Puzzle":
                kitapYurdu.ahsapPuzzleTitle.getText().contains("Ahşap Puzzle");
                break;
            case "300 Parça":
                kitapYurdu.ucyuzParcaTitle.getText().contains("300");
                break;
                case "Çocuk Puzzle":
                kitapYurdu.cocukPuzzleTitle.getText().contains("Çocuk Puzzle");
                break;
            case "6-48 PARÇA":
                kitapYurdu.altiKirksekizParcaTitle.getText().contains("6-48 PARÇA");
                break;
                case "Ahşap Puzzle (1000 Parça)":
                kitapYurdu.ahsapBinParcaText.getText().contains("1.000 Parça Ahşap Puzzle");
                break;
                case "Türk Sanatı Serisi":
                kitapYurdu.turkSanatEseriText.getText().contains("Türk Sanatı Serisi");
                break;
            default:
                break;
        }

    }


    @Then("{string} menusu tiklandi")
    public void menusuTiklandi(String string) throws InterruptedException {
        switch (string) {
            case "Puzzle Yapboz":
            kitapYurdu.puzzleYapboz.click();
                break;
                case "Şehirler ve Yapılar Serisi":
                kitapYurdu.sehirlerYapilar.click();
                break;
                case "Panaromik":
                kitapYurdu.panaromik.click();
                break;
            case "Ahşap Puzzle":
            kitapYurdu.ahsapPuzzleMenu.click();
                break;
                case "Türk Sanatı Serisi":
                kitapYurdu.turkSanatEseri.click();
                break;
            case "300 Parça":
            kitapYurdu.ucyuzParcaMenu.click();
                break;
            case "Lava":
                kitapYurdu.lava.click();
                break;
            case "Çocuk Puzzle":
                try {
                    kitapYurdu.cocukPuzzle.click();
                }finally {
                    kitapYurdu.cocukPuzzle.click();
                }
                break;
                case "6-48 PARÇA":
                kitapYurdu.altiKirksekizParca.click();
                break;
                case "1.000 Parça Ahşap Puzzle":
                kitapYurdu.ahsapBinParca.click();
                break;
            default:
                break;

        }
    }

    @And("{string} menusunun gorundugu dogrulandi")
    public void menusununGorunduguDogrulandi(String string) {
        switch (string) {
            case "Ahşap Puzzle":

                break;
            case "Ahsap Puzzle":

                break;
            case "300 Parça":

                break;
            default:
                break;

        }

    }

    @And("Sayfada {string} sayida urun oldugu dogrulandi")
    public void sayfadaSayidaUrunOlduguDogrulandi(String text) throws InterruptedException {
        String bolumBasligi = Driver.getDriver().findElement(By.xpath("//android.widget.TextView[@text='"+text+"']")).getAttribute("text");
        if (bolumBasligi.equals("6-48 PARÇA")) {
            urunDogrula("//android.widget.TextView[@text='12 ürün listelendi']");
        } else if (bolumBasligi.equals("Şehirler ve Yapılar Serisi")) {
            urunDogrula("//android.widget.TextView[@text='17 ürün listelendi']");
        }else {
           // "Lava":
            Set<String > elements= new HashSet<>();
            List<WebElement> list=null;
            do {
                for (int i = 0; i < 4; i++) {
                    try{
                        list = Driver.getDriver().findElements(By.xpath("//android.widget.TextView[@resource-id='com.mobisoft.kitapyurdu:id/textViewProductName']"));
                        elements.add(list.get(i).getAttribute("text"));
                        System.out.println("elements = " + elements);
                        System.out.println("elements.size() = " + elements.size());
                    }catch (Exception e){

                    }
                }
                if((list.size()/4)==1) {
                    //js.executeScript("window.scrollBy(0, 10);");
                    scroll(Driver.getDriver(), 1);
                }else {
                    break;
                }

            }while ((list.size()/4)==1);

        }

    }

    @And("Urunu tikladi")
    public void urunuTikladi() {
        kitapYurdu.kaplumbagaTerbiyecisi.click();
    }


    @And("Urunu swipe yapti")
    public void urunuSwipeYapti() throws InterruptedException {
        scrollHorizontal(Driver.getDriver(), 5);
    }

    @And("Sayfada kac urun oldugu yazdirildi")
    public void sayfadaKacUrunOlduguYazdirildi() throws InterruptedException {
        List<WebElement> urunlerWebElements;
        List<String> urunListesi = new ArrayList<>();
        int a = 0;
        int b = 0;
        do {
            urunlerWebElements = Driver.getDriver().findElements(By.id("com.mobisoft.kitapyurdu:id/textViewProductName"));
            a = urunListesi.size();
            for (int i = 0; i < urunlerWebElements.size(); i++) {
                if (!urunListesi.contains(urunlerWebElements.get(i).getText())) {
                    urunListesi.add(urunlerWebElements.get(i).getText());
                }
            }
            scroll(Driver.getDriver(), 1);
            b = urunListesi.size();
        } while (a < b);
        System.out.println("TOPLAM URUN SAYISI: " + urunListesi.size());
        urunListesi.forEach(System.out::println);
    }
}

