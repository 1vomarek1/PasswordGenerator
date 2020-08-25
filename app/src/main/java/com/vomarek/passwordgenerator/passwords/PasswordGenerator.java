package com.vomarek.passwordgenerator.passwords;

public class PasswordGenerator {
    final int def = 12;
    public int length = def;

    public boolean letters = true;
    public boolean numbers = true;
    public boolean symbols = false;

    public void update(final Boolean letters, final Boolean numbers, final Boolean symbols) {

        if (letters != null) this.letters = letters;
        if (numbers != null) this.numbers = numbers;
        if (symbols != null) this.symbols = symbols;

    }

    public String generate() {

        String allowedCharacters = "";

        if (letters) allowedCharacters += "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (numbers) allowedCharacters += "0123456789";
        if (symbols) allowedCharacters += "!@#$%?&*";

        if (allowedCharacters.equals("")) allowedCharacters += "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        final int length = getLength();

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(allowedCharacters.split("")[(int) Math.floor(Math.random() * allowedCharacters.split("").length)]);
        }

        return password.toString();
    }

    public Integer getLength() {

        if (length > 30) return def;
        return length;

    }

}
