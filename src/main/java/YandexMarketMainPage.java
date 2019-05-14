import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$x;

public class YandexMarketMainPage  extends InitMarketPage{


 private ElementsCollection horizontalTabs = $$x("//div[@class='n-w-tabs__horizontal-tabs n-adaptive-layout']//span");
 private ElementsCollection categories = $$x("//div[@class='n-w-tabs__vertical-tabs']//span");
 private ElementsCollection subCategories = $$x("//div[contains(@class,'n-w-tab__column n-w-tab__column_type_navigation-menu-vertical')]//a[text()='Электроника']/following-sibling::div//a");


    @Когда("Выбираем меню из горизонтальной панели")
    public YandexMarketMainPage choseHorizontalTabMenu(String nameOfMenu) {
         horizontalTabs.findBy(Condition.textCaseSensitive(nameOfMenu)).click();
         return this;
    }

    @Когда("Выбираем категории")
    public YandexMarketMainPage choiseCategory(String nameOfCategory) {
        categories.filter(Condition.exactTextCaseSensitive(nameOfCategory)).shouldHaveSize(1).get(0).click();
        return this;
    }

    @Тогда("Наводим курсор на категорию")
    public YandexMarketMainPage focusCategory(String nameOfCategory) {
        categories.findBy(Condition.exactTextCaseSensitive(nameOfCategory)).shouldBe(Condition.visible).hover();
        return this;
    }

    @Тогда("Выбираем категорию")
    public YandexMarketFiltrationPage choiseSubCategory(String nameOfSubCategory) {
        subCategories.findBy(Condition.exactTextCaseSensitive(nameOfSubCategory)).click();
        return new YandexMarketFiltrationPage();
    }








}
