import com.codeborne.selenide.Selenide;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Dannie.CardInfo;

import ru.netology.Dannie.DataGeneratorInfoForSQL;
import ru.netology.bankPages.StartPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.Dannie.DataGeneratorInfo.*;

public class CreditGateTest {


    @BeforeEach
    void setUp() {

        open("http://localhost:8080");
        DataGeneratorInfoForSQL.clearBD();
    }


    @SneakyThrows
    @Test
    void shouldStatusBuyCreditValidActiveCard() {
        CardInfo card = new CardInfo(getPasteApprovedCard(), getPasteApprovedCard(), getPasteNextYear(), getPasteVladelec(), getPasteCVC());
        val mainPage = new StartPage();
        mainPage.checkCreditButton().
                cardForm(card).
                checkApprovedForm();
        assertEquals("APPROVED", DataGeneratorInfoForSQL.getCreditGateStatus());
    }
}