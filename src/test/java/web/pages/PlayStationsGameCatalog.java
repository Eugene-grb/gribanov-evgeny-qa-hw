package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Sleeper;
import web.elements.*;
import web.helpers.WaitHelper;
import web.locators.PlayStationsGameCatalogLocators;

import java.time.Duration;

public class PlayStationsGameCatalog extends BasePage {

    private PlayStationsGameCatalogLocators pgcLocators;

    public PlayStationsGameCatalog(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this.pgcLocators);
    }

    // 1. Шапка

    public MainBlock mainBlock() {
        return new MainBlock(pgcLocators.mainBlock);
    }

    // 2. Фильтры

    // Фильтр "Платформа"
    // Чекбокс "Платформа"
    public CheckBox checkBoxPlatform(String platform) {
        return new CheckBox(findCheckBoxCompany(platform));
    }

    // Поиск чекбокса "Платформа"
    private WebElement findCheckBoxCompany(String platform) {
        WaitHelper.visibilityOfElement(pgcLocators.divPlatform);
        return pgcLocators.divPlatform
                .findElement(By.xpath("./label/span[contains(text(), \"" + platform + "\")]"));
    }


    // Фильтр "Год релиза"
    // Чекбокс "Платформа"
    public CheckBox checkBoxReleaseYear(String releaseYear) {
        return new CheckBox(findCheckBoxReleaseYear(releaseYear));
    }

    // установить год релиза
    public void releaseYearTextBox(String releaseYear) {
        WaitHelper.visibilityOfElement(pgcLocators.searchReleaseYearPlaceholder);
        TextBox releaseYearTextBox = new TextBox(pgcLocators.searchReleaseYearPlaceholder);
        releaseYearTextBox.click();
        releaseYearTextBox.setValue(releaseYear);
    }

    // Поиск чекбокса "Год релиза"
    private WebElement findCheckBoxReleaseYear(String releaseYear) {
        WaitHelper.visibilityOfElement(pgcLocators.divReleaseYear);
        return pgcLocators.divReleaseYear
                .findElement(By.xpath("./label/span[contains(text(), \"" + releaseYear + "\")]"));
    }

    // Фильтр "Тип Упаковки"
    // Чекбокс "Тип Упаковки"
    public CheckBox checkBoxPackage(String packageType) {
        return new CheckBox(findCheckBoxPackage(packageType));
    }

    // Поиск чекбокса "Платформа"
    private WebElement findCheckBoxPackage(String packageType) {
        WaitHelper.visibilityOfElement(pgcLocators.divGameBox);
        return pgcLocators.divGameBox
                .findElement(By.xpath("./label/span[contains(text(), \"" + packageType + "\")]"));
    }

    // Кнопка Применить
    public Button buttonApply() {
        return new Button(pgcLocators.buttonApply);
    }

    // 3. Сортировка
    // Аккордеон "Сортировка"
    public Accordion accordeonSort() {
        return new Accordion(pgcLocators.accordeonSort);
    }

    // Переключатель "Сортировка"
    public RadioButton radioButtonSort(String sort) {
        return new RadioButton(findRadioButtonSort(sort));
    }

    // Поиск переключателя "Сортировка"
    private WebElement findRadioButtonSort(String sort) {
        WaitHelper.visibilityOfElement(pgcLocators.divSort);
        return pgcLocators.divSort
                .findElement(By.xpath("//span[contains(text(), \"" + sort + "\")]"));
    }

    // 4. Ссылка на первый продукт в списке
    public Link linkFirstProduct() {
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofMillis(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Link(pgcLocators.linkFirstProduct);
    }
}
