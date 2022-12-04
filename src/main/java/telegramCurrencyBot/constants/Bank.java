package telegramCurrencyBot.constants;

public enum Bank {
    PRIVAT("ПриватБанк"),
    MONO("MonoBank"),
    NBU("НБУ");

    private final String bankName;
    Bank(String name) {
        bankName = name;
    }

    public String getBankName() {
        return bankName;
    }
}
