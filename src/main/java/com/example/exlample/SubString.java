package com.example.exlample;

import java.util.HashMap;
import java.util.Map;
public class SubString {
    public static void main(String[] args) {
        String t = "abcdefg";
        String s = "gfc";
        int result = solve(t, s);
        System.out.println(result); // Выводит 1
    }
    public static int solve(String t, String s) {
        // Создаем хэш-таблицу для подсчета количества каждой буквы в строке S
        Map<Character, Integer> sMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        int sLength = s.length();
        int tLength = t.length();
        // Создаем хэш-таблицу для подсчета количества каждой буквы в текущей подстроке S' в тексте T
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < sLength; i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        // Проверяем, совпадают ли хэш-таблицы для первой подстроки S' и строки S
        if (sMap.equals(tMap)) {
            return 0; // Если совпадают, возвращаем индекс 0
        }
        // Переходим к следующим подстрокам S' в тексте T
        for (int i = sLength; i < tLength; i++) {
            char prevChar = t.charAt(i - sLength);
            char nextChar = t.charAt(i);
            // Обновляем хэш-таблицу для текущей подстроки S' в тексте T
            tMap.put(prevChar, tMap.get(prevChar) - 1);
            if (tMap.get(prevChar) == 0) {
                tMap.remove(prevChar);
            }
            tMap.put(nextChar, tMap.getOrDefault(nextChar, 0) + 1);
            // Проверяем, совпадают ли хэш-таблицы для текущей подстроки S' и строки S
            if (sMap.equals(tMap)) {
                return i - sLength + 1; // Если совпадают, возвращаем индекс первого вхождения
            }
        }
        return -1; // Если подстрока S' не нашлась, возвращаем -1
    }
}