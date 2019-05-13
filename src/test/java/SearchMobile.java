import org.junit.Assert;
import org.junit.jupiter.api.Test;



public class SearchMobile {

    @Test
    public void  searchMobile () {
        new YandexMarketMainPage ().choseHorizontalTabMenu("Все категории").focusCategory("Электроника").choiseSubCategory("Мобильные телефоны");
        new YandexMarketFiltrationPage().choseFilterWithCheckboxes("Производитель","Xiaomi").deviceInFilteringResults("Смартфон Xiaomi Mi6 4/64GB");
        Assert.assertEquals(new YandexMarketDevicePage().tabsInDevice("Характеристики").getDeviceFeatureValue("Видеопроцессор"),"Adreno 540");
        Assert.assertEquals(new YandexMarketDevicePage().tabsInDevice("Характеристики").getDeviceFeatureValue("Тип разъема для зарядки"),"USB Type-C");



    }
}
