package com.example.java;

import java.io.File;

public class LogDirectoryCreator {
    public static void createLogDirectory() {
        String userHome = System.getProperty("user.home");
        File logDir = new File(userHome, "logs");
        if (!logDir.exists()) {
            if (logDir.mkdirs()) {
                System.out.println("Log directory created at: " + logDir.getAbsolutePath());
            } else {
                System.err.println("Failed to create log directory at: " + logDir.getAbsolutePath());
            }
        }
    }
}