package module13.telegramBot;


import java.util.List;

public interface CurrencyRateApiService {
    List<RateResponseDto> getRates();
}
