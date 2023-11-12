package ru.netology.Dannie;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CardInfo {
    private String cardNumber;
    private String owner;
    private String month;
    private String year;
    private String cardCVC;
}