package com.attendant.telegramBotAssistant;

import com.attendant.googleSpreadsheet.SheetsQuickstart;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class TelegramBotAssistant extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        sendMsg(update.getMessage().getChatId().toString(), message);
    }


    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        //setButtons(sendMessage);
        List<List<Object>> values = null;
        try {
            values = SheetsQuickstart.infoAttendantGoogleSpreadsheet();
        } catch (Exception e) {
            System.out.println("sendMsg catch");
            e.printStackTrace();
        }
        if (values != null) {
            for (List row : values) {
                ///////////////////////////////////////////////////////////////////////// тут
            }
        }
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText("Hello");
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public synchronized void setButtons(SendMessage sendMessage) {
        // Создаем клавиуатуру
//        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
//        sendMessage.setReplyMarkup(replyKeyboardMarkup);
//        replyKeyboardMarkup.setSelective(true);
//        replyKeyboardMarkup.setResizeKeyboard(true);
//        replyKeyboardMarkup.setOneTimeKeyboard(false);
//
//        // Создаем список строк клавиатуры
//        List<KeyboardRow> keyboard = new ArrayList<>();
//
//        // Первая строчка клавиатуры
//        KeyboardRow keyboard1 = new KeyboardRow();
//        // Добавляем кнопки в первую строчку клавиатуры
//        keyboard1.add(new KeyboardButton("USD rate UAH"));
//
//        // Вторая строчка клавиатуры
//        KeyboardRow keyboard2 = new KeyboardRow();
//        // Добавляем кнопки во вторую строчку клавиатуры
//        keyboard2.add(new KeyboardButton("EUR rate UAH"));
//
//        //Третья
//        KeyboardRow keyboard3 = new KeyboardRow();
//        // Добавляем кнопки в третью строчку клавиатуры
//        keyboard3.add(new KeyboardButton("RUB rate UAH"));
//
//        // Добавляем все строчки клавиатуры в список
//        keyboard.add(keyboard1);
//        keyboard.add(keyboard2);
//        keyboard.add(keyboard3);
//        // и устанваливаем этот список нашей клавиатуре
//        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    @Override
    public String getBotUsername() {
        return "AssistantAttendant";
    }

    @Override
    public String getBotToken() {
        return "701533339:AAGZpsNPVAblKnbq_kxkYOcTMX3F4gJKlSg";
    }
}
