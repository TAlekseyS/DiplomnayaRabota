package ru.netology.bankPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StartPage {
    private SelenideElement paymentButton = $(byText("Купить"));
    private SelenideElement creditButton = $(byText("Купить в кредит"));

    public PaymentGate checkPaymentButton() {
        paymentButton.click();
        return new PaymentGate();
    }

    public CreditGate checkCreditButton() {
        creditButton.click();
        return new CreditGate();
    }
}