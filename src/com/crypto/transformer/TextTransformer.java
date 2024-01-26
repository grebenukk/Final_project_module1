package com.crypto.transformer;

import com.crypto.model.Alphabet;

public class TextTransformer {

    public String moveLetterOnRightPositions(int pos, String text) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            int index = Alphabet.ALPHABET_EN.indexOf(Character.toLowerCase(ch));
            if (index != -1) {
                int shiftedIndex = (index + pos + Alphabet.ALPHABET_EN.size()) % Alphabet.ALPHABET_EN.size();
                char shiftedChar = Alphabet.ALPHABET_EN.get(shiftedIndex);
                result.append(Character.isUpperCase(ch) ? Character.toUpperCase(shiftedChar) : shiftedChar);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public String moveLetterOnLeftPositions(int pos, String text) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            int index = Alphabet.ALPHABET_EN.indexOf(Character.toLowerCase(ch));
            if (index != -1) {
                int shiftedIndex = (index - pos + Alphabet.ALPHABET_EN.size()) % Alphabet.ALPHABET_EN.size();
                char shiftedChar = Alphabet.ALPHABET_EN.get(shiftedIndex);
                result.append(Character.isUpperCase(ch) ? Character.toUpperCase(shiftedChar) : shiftedChar);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
