package Tests;

import Base.Base;
import DataBase.DataBase;
import Help.ElementMethods;
import Help.PageMethods;
import Help.TabMethods;
import Objects.SpecificatiiCeruteObject;
import Objects.SpecificatiiGasiteObject;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import Queries.SQLAutovit;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class AutovitTest extends Base {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    public PageMethods pageMethods;
    public ElementMethods elementMethods;
    public TabMethods tabMethods;
    public SQLAutovit sqlAutovit;
    public SpecificatiiCeruteObject specificatiiCeruteObject;
    public SpecificatiiGasiteObject specificatiiGasiteObject;
    DataBase DB = new DataBase();


    @Test
    public void AutovitTest() throws InterruptedException, IOException, SQLException {
        pageMethods = new PageMethods(driver);
        elementMethods = new ElementMethods(driver);
        tabMethods = new TabMethods(driver);
        sqlAutovit = new SQLAutovit(DB);
        specificatiiCeruteObject = new SpecificatiiCeruteObject();

        Autovit();
    }

    public void Autovit() throws InterruptedException, IOException, SQLException {
        //Validare pagina Autovit
        String ExpectedTitle = "AUTOVIT - Anunturi auto, vanzari autoturisme noi si second hand.";
        pageMethods.ValidateTitleOfPage(ExpectedTitle);

        //Accept Cookies
        WebElement Cookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        elementMethods.ClickElement(Cookies);

        //Completare date de cautare masini
        int numberOfRows = sqlAutovit.getNumberRows();
        for (int indexRows = 1; indexRows <= numberOfRows; indexRows++) {
            specificatiiCeruteObject = new SpecificatiiCeruteObject();
            WebElement Marca = driver.findElement(By.id("filter_enum_make"));
            WebElement Model = driver.findElement(By.id("filter_enum_model"));
            WebElement Pretmin = driver.findElement(By.id("filter_float_price:from"));
            WebElement Pretmax = driver.findElement(By.id("filter_float_price:to"));
            WebElement Anmin = driver.findElement(By.id("filter_float_year:from"));
            WebElement Anmax = driver.findElement(By.id("filter_float_year:to"));
            WebElement Cauta = driver.findElement(By.xpath("//button[@data-testid='submit-btn']"));

            sqlAutovit.SelectMarca(specificatiiCeruteObject, "MasiniCautate", indexRows);
            elementMethods.SendKeyElement(Marca, specificatiiCeruteObject.getMarca());
            elementMethods.SendEnterElement(Marca);
            elementMethods.WaitAfeterClickableElement(Model);
            sqlAutovit.SelectModel(specificatiiCeruteObject, "MasiniCautate", indexRows);
            elementMethods.SendKeyElement(Model, specificatiiCeruteObject.getModel());
            elementMethods.SendEnterElement(Model);
            sqlAutovit.SelectPretmin(specificatiiCeruteObject, "MasiniCautate", indexRows);
            elementMethods.SendKeyElement(Pretmin, specificatiiCeruteObject.getPretmin());
            elementMethods.SendEnterElement(Pretmin);
            sqlAutovit.SelectPretmax(specificatiiCeruteObject, "MasiniCautate", indexRows);
            elementMethods.SendKeyElement(Pretmax, specificatiiCeruteObject.getPretmax());
            elementMethods.SendEnterElement(Pretmax);
            sqlAutovit.SelectAnmin(specificatiiCeruteObject, "MasiniCautate", indexRows);
            elementMethods.SendKeyElement(Anmin, specificatiiCeruteObject.getAnmin());
            elementMethods.SendEnterElement(Anmin);
            sqlAutovit.SelectAnmax(specificatiiCeruteObject, "MasiniCautate", indexRows);
            elementMethods.SendKeyElement(Anmax, specificatiiCeruteObject.getAnmax());
            elementMethods.SendEnterElement(Anmax);
            sqlAutovit.SelectCombustibil(specificatiiCeruteObject, "MasiniCautate", indexRows);
            elementMethods.ClickElement(Cauta);
            WebElement Combustibil = driver.findElement(By.xpath("//li/input[@placeholder='Combustibil']"));
            elementMethods.WaitAfterVisibleElement(Combustibil);
            elementMethods.SendKeyElement(Combustibil, specificatiiCeruteObject.getCombustibil());
            elementMethods.SendEnterElement(Combustibil);
            pageMethods.ScrollSmooth();

            //Cautare specificatii unice in lista de rezultate
            List<WebElement> Rezultate= driver.findElements(By.xpath("//div[@class='offers list']/article"));
            int index=0;
            while (index < Rezultate.size()){
                SpecificatiiGasiteObject specificatiiGasiteObject = new SpecificatiiGasiteObject();
                int countArticle=index+1;
                try{
                WebElement DenumireGasita = driver.findElement(By.xpath("//div[@class='offers list']/article["+countArticle+"]/div[2]//h2/a"));
                specificatiiGasiteObject.setDenumire(DenumireGasita.getAttribute("title"));}
                catch (NoSuchElementException exception){};
                try{
                WebElement DescriereGasita = driver.findElement(By.xpath("//div[@class='offers list']/article["+countArticle+"]/div[2]//h3"));
                specificatiiGasiteObject.setDescriere(DescriereGasita.getText());}
                catch (NoSuchElementException exception){};
                try{
                WebElement MotorizareGasita = driver.findElement(By.xpath("//div[@class='offers list']/article["+countArticle+"]/div[2]/ul/li[4]/span"));
                specificatiiGasiteObject.setMotorizare(MotorizareGasita.getText());}
                catch (NoSuchElementException exception){};
                try{
                WebElement KmGasiti = driver.findElement(By.xpath("//div[@class='offers list']/article["+countArticle+"]/div[2]/ul/li[2]/span"));
                specificatiiGasiteObject.setKm(KmGasiti.getText());}
                catch (NoSuchElementException exception){};
                try{
                WebElement AnGasit = driver.findElement(By.xpath("//div[@class='offers list']/article["+countArticle+"]/div[2]/ul/li[1]/span"));
                specificatiiGasiteObject.setAn(AnGasit.getText());}
                catch (NoSuchElementException exception){};
                try{
                WebElement LocatieGasita = driver.findElement(By.xpath("//div[@class='offers list']/article["+countArticle+"]/div[2]/h4/span[@class='ds-location-city']"));
                specificatiiGasiteObject.setLocatie(LocatieGasita.getText());}
                catch (NoSuchElementException exception){};
                try{
                WebElement PretGasit = driver.findElement(By.xpath("//div[@class='offers list']/article["+countArticle+"]/div[2]/div[2]/div/div/span/span[1]"));
                specificatiiGasiteObject.setPret(PretGasit.getText());}
                catch (NoSuchElementException exception){};
                try{
                WebElement LinkGasit = driver.findElement(By.xpath("//div[@class='offers list']/article["+countArticle+"]/div[2]/div[1]/h2/a[@href]"));
                specificatiiGasiteObject.setLink(LinkGasit.getAttribute("href"));}
                catch (NoSuchElementException exception){};

                //Inserare in SQL DB
                sqlAutovit.InsertDescriere(specificatiiGasiteObject, "MasiniGasite");
                index++;
            }

            driver.get("https://www.autovit.ro/");
        }
    }
}