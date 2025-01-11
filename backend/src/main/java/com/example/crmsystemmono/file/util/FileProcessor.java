package com.example.crmsystemmono.file.util;

import org.springframework.stereotype.*;

import java.util.*;

@Component
public class FileProcessor {

    public static Double calcToMB(Long size) {

        return size.doubleValue() / 1_000_000;
    }

    public static String fileExtension(String originalName) {
        return originalName.substring(originalName.lastIndexOf(".") + 1);
    }

    public static String getFileName(String originalName, String delimetr) {
        return originalName.substring(0, originalName.indexOf(delimetr));
    }

    public static String createPath(List<String> items, String delimetr) {
        StringBuilder stringBuilder = new StringBuilder();

        items.forEach(item -> {
            stringBuilder.append(item);
            stringBuilder.append(delimetr);
        });
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

//    public static String accessName(String access) {
//        switch (access) {
//            case "public" -> {
//                return "Публичный";
//            }
//            case "project" -> {
//                return "Проект";
//            }
//            case "user" -> {
//                return "Пользователи";
//            }
//            default -> {
//                return "Публичный";
//            }
//        }
//    }


}
