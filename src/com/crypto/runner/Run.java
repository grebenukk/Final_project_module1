package com.crypto.runner;

import com.crypto.constans.CommandArguments;
import com.crypto.service.BruteForceService;
import com.crypto.service.DecryptService;
import com.crypto.service.EncryptService;
import com.crypto.util.InputValidation;

import java.io.File;

public class Run {

    public static void run(String[] args) {
        InputValidation.validateInput(args);
        InputValidation.validateCommand(args[CommandArguments.COMMAND_ARGUMENT_POSITION]);
        InputValidation.validateFilePath(args[CommandArguments.FILE_PATH_ARGUMENT_POSITION]);

        String mode = args[CommandArguments.COMMAND_ARGUMENT_POSITION];
        String filePath = args[CommandArguments.FILE_PATH_ARGUMENT_POSITION];

        EncryptService encryptService = new EncryptService();
        DecryptService decryptService = new DecryptService();
        BruteForceService bruteForceService = new BruteForceService();

        switch (mode) {
            case "ENCRYPT":
                int key = Integer.parseInt(args[CommandArguments.KEY_ARGUMENT_POSITION]);
                encryptService.encrypt(new File(filePath), key);
                break;
            case "DECRYPT":
                key = Integer.parseInt(args[CommandArguments.KEY_ARGUMENT_POSITION]);
                decryptService.decrypt(new File(filePath), key);
                break;
            case "BRUTE_FORCE":
                bruteForceService.decrypt(new File(filePath));
                break;
        }
    }

}
