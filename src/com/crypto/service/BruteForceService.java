package com.crypto.service;

import com.crypto.transformer.TextTransformer;

import java.io.*;

public class BruteForceService {
    private DecryptService decryptService = new DecryptService();
    private TextTransformer textTransformer = new TextTransformer();

    public void decrypt(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder content = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            String dataFromFile = content.toString();

            for (int i = 1; i < 35; i++) {
                String decryptedText = textTransformer.moveLetterOnLeftPositions(i, dataFromFile);
                int indexSymbol = decryptedText.indexOf(",");

                if (indexSymbol > 0) {
                    String nextSymbol = decryptedText.substring(indexSymbol + 1, indexSymbol + 2);
                    if (nextSymbol.equals(" ")) {
                        decryptService.decrypt(file, i);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
