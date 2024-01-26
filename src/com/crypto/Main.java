package com.crypto;

import com.crypto.model.Mode;
import com.crypto.service.BruteForceService;
import com.crypto.service.DecryptService;
import com.crypto.service.EncryptService;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select mode:");
        for (Mode mode : Mode.values()) {
            System.out.println(mode.ordinal() + 1 + ". " + mode.name());
        }

        int modeChoice = scanner.nextInt();
        Mode selectedMode = Mode.values()[modeChoice - 1];

        System.out.println("Enter file path:");
        String filePath = scanner.next();
        File file = new File(filePath);

        System.out.println("Enter key (if applicable):");
        int key = scanner.nextInt();

        switch (selectedMode) {
            case ENCRYPT:
                EncryptService encryptService = new EncryptService();
                encryptService.encrypt(file, key);
                break;
            case DECRYPT:
                DecryptService decryptService = new DecryptService();
                decryptService.decrypt(file, key);
                break;
            case BRUTE_FORCE:
                BruteForceService bruteForceService = new BruteForceService();
                bruteForceService.decrypt(file);
                break;
        }
    }
}
