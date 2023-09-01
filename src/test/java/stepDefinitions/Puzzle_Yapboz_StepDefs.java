package stepDefinitions;


import androidScreen.Puzzle_Yapboz_Screen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utilities.ReusableMethods.*;


public class Puzzle_Yapboz_StepDefs {

    Puzzle_Yapboz_Screen kitapYurdu=new Puzzle_Yapboz_Screen();

    public Puzzle_Yapboz_StepDefs() throws MalformedURLException {
    }
    @Given("Kitap Yurdu sitesine gidildi")
    public void kitapYurduSitesineGidildi() {
        Driver.getDriver();
    }


    @Then("Kitap Yurdu sitesine gidildigi dogrulandi")
    public void kitap_yurdu_sitesine_gidildigi_dogrulandi() {

        Driver.getDriver();
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
            case "Ahşap Puzzle":
                    kitapYurdu.ahsapPuzzleMenu.click();
                break;
                case "Türk Sanatı Serisi":
                kitapYurdu.turkSanatEseri.click();
                break;
            case "300 Parça":
               try {
                   scroll(Driver.getDriver(),1);
               }finally {
                   scroll(Driver.getDriver(),1);
               }
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
                case "Ahşap Puzzle (1000 Parça)":
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
            String bolumBasligi= kitapYurdu.altiKirksekizParca.getText();
        System.out.println("bolumBasligi = " + bolumBasligi);
        if (bolumBasligi.equals("6-48 PARÇA")) {
            urunDogrula("//android.widget.TextView[@text='12 ürün listelendi']");
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
}

