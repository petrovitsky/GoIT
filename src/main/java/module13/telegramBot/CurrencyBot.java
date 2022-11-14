package module13.telegramBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.ChatMemberUpdated;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CurrencyBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "CurrencyBot";
    }
    @Override
    public String getBotToken() {
        return "5766905218:AAHEToxEQvJLYQQQZoe5QgyrWfKJWcyqSJU";
    }
    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString() );
            System.out.println("update.getMessage().getText() = " + update.getMessage().getText());
            message.setText(update.getMessage().getText().toUpperCase());
            System.out.println("update.getMessage().getChatId() = " + update.getMessage().getChatId());

            try {
                Thread.sleep(1000);
                execute(message); // Call method to send the message
            } catch (TelegramApiException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
