package com.crypto.service;

import com.crypto.transformer.TextTransformer;

import java.io.*;

public class DecryptService {

    private TextTransformer textTransformer = new TextTransformer();

    public void decrypt(File file, int key) {
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            String dataFromFile = content.toString();

            String encryptedText = textTransformer.moveLetterOnLeftPositions(key, dataFromFile);

            String fileName = file.getName();
            String newFileName = fileName.replaceFirst("[.][^.]+$", "[DECRYPTED]$0");
            File resultFile = new File(file.getParentFile(), newFileName);

            try (FileWriter writer = new FileWriter(resultFile)) {
                writer.write(encryptedText);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
