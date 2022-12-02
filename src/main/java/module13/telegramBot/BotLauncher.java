package module13.telegramBot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class BotLauncher {
    public static void main(String[] args) throws TelegramApiException {



        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new CurrencyBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


}
