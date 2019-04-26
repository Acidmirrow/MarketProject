import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;

public class YandexMarketFiltrationPage {

    private SelenideElement filters = $x("//div[@class='search-layout']");
    private String viewall ="//a[text()='Показать всё']";

    public YandexMarketFiltrationPage choseFilterWithCheckboxes(String nameOfFilter, String nameOfParameter) {
        SelenideElement availableElements = filters.$x("//legend[text()='"+nameOfFilter+"']/ancestor::fieldset");
        SelenideElement parameterInFilter = availableElements.$x("//span[text()='"+nameOfParameter+"']/ancestor::a");

        if(parameterInFilter.exists()){
            parameterInFilter.setSelected(true);
        }else {
            availableElements.$x(viewall).click();
            parameterInFilter.scrollIntoView(true).setSelected(true);
        }
        return this;
    }

}
