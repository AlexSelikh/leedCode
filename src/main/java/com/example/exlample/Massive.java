package com.example.exlample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Massive {
    public static void main(String[] args) {
        int[] numbers = {1, 4, 5, 2, 3, 9, 8, 11, 0};
        String result = compressNumbers(numbers);
        System.out.println(result); // Выводит "0-5,8-9,11"
    }
    public static String compressNumbers(int[] numbers) {
        // Сортируем массив чисел

        Arrays.sort(numbers);
        List<String> ranges = new ArrayList<>();
        int start = numbers[0];
        int end = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == end + 1) {
                // Если текущее число продолжает числовой ряд, обновляем конец диапазона
                end = numbers[i];
            } else {
                // Иначе, добавляем текущий диапазон в список и обновляем начало и конец диапазона
                ranges.add(getRangeString(start, end));
                start = numbers[i];
                end = numbers[i];
            }
        }
        // Добавляем последний диапазон в список
        ranges.add(getRangeString(start, end));
        // Объединяем все диапазоны в одну строку, разделяя их запятой
        return String.join(",", ranges);
    }
    public static String getRangeString(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        } else {
            return start + "-" + end;
        }
    }
}