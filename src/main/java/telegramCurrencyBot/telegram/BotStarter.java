package telegramCurrencyBot.telegram;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class BotStarter {
    private CurrencyBot currencyBot;

    public BotStarter() {
        currencyBot = new CurrencyBot();

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(currencyBot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

