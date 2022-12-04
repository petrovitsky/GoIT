package telegramCurrencyBot.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class CurrencyRate {
    BigDecimal sell;
    BigDecimal buy;
    Currency currency;

    public CurrencyRate(BigDecimal sell, BigDecimal buy, Currency currency) {
        this.sell = sell;
        this.buy = buy;
        this.currency = currency;
    }
}