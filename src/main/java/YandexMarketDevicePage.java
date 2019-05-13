import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class YandexMarketDevicePage {


    public SelenideElement tabs = $x("//ul[@class='n-product-tabs__list']");

    public YandexMarketDevicePage tabsInDevice(String nameOfTab) {
        tabs.$x("//a[.='"+nameOfTab+"']").click();
        tabs.$x("//a[.='"+nameOfTab+"']/ancestor::li[contains(@class,'selected')]").shouldBe(Condition.exist);
        return this;
    }

    public String getDeviceFeatureValue(String nameOfFeature) {
        return $x("//dt[.='"+nameOfFeature+"']/following-sibling::dd/span").getValue();
    }

}
