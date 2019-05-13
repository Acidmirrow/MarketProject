import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;
import static junit.framework.TestCase.fail;


public class YandexMarketFiltrationPage {

    private SelenideElement filters = $x("//div[@class='search-layout']");
    private String viewall ="//a[text()='Показать всё']";
    private SelenideElement spinerinfiltering = $x("//div[@class='spin2 spin2_size_m i-bem spin2_js_inited spin2_progress_yes']");
    private SelenideElement viewmore = $x("//span[text()='Показать еще']/ancestor::a[not (contains(@class,'button_disabled_yes'))]");
    private SelenideElement spinerviewmore = $x("//div[contains(@class,'spin_progress_yes')]");
    private SelenideElement resultsgrid = $x("//div[contains(@class,'n-snippet-list_type_grid')]");
    private SelenideElement spinerinshowmoredevice = $x("//div[@class='spin spin_theme_gray-24 i-bem spin_js_inited spin_progress_yes']");


    public YandexMarketFiltrationPage choseFilterWithCheckboxes(String nameOfFilter, String nameOfParameter) {
        SelenideElement availableElements = filters.$x("//legend[text()='"+nameOfFilter+"']/ancestor::fieldset");
        SelenideElement parameterInFilter = availableElements.$x("//span[text()='"+nameOfParameter+"']/ancestor::a//input");
        if(!parameterInFilter.isSelected())
        availableElements.$x("//span[text()='"+nameOfParameter+"']/ancestor::a").scrollIntoView(true).click();
        spinerinfiltering.shouldNotBe(Condition.visible);
        return this;
    }

    public YandexMarketFiltrationPage deviceInFilteringResults(String nameofdevice) {
        while(viewmore.exists()){
            viewmore.scrollIntoView(true).click();
            spinerviewmore.shouldNotBe(Condition.visible);
        }
        if(resultsgrid.$x("//a[@title='"+nameofdevice+"']").exists()){
            resultsgrid.$x("//a[@title='"+nameofdevice+"']").click();
            spinerinshowmoredevice.shouldNotBe(Condition.visible);
        }else {
            fail("Не найден мобильный телефон с названием "+nameofdevice+"");
        }
        return this;
    }

}
