import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;


public class SearchMobile {

    @Test
    public void  searchMobile () throws InterruptedException {
        new YandexMarketMainPage ().choseHorizontalTabMenu("Все категории").focusCategory("Электроника").choiseSubCategory("Мобильные телефоны");
        new YandexMarketFiltrationPage().choseFilterWithCheckboxes("Производитель","Xiaomi");

        sleep(2000);


    }
}
