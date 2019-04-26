import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

public class InitMarketPage {

    public InitMarketPage() {
        Configuration.timeout=10000;
        Selenide.open("https://market.yandex.ru/");
    }
}
