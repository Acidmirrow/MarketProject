import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;


public class SearchMobile {

    @Test
    public void  searchMobile () throws InterruptedException {
        new YandexMarketMainPage ().choseHorizontalTabMenu("Все категории").focusCategory("Электроника").choiseSubCategory("Мобильные телефоны");
        new YandexMarketFiltrationPage().choseFilterWithCheckboxes("Производитель","Xiaomi").deviceInFilteringResults("Смартфон Xiaomi Mi6 4/64GB");

        sleep(2000);


    }
}
