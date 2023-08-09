package com.example.exlample;

import java.util.HashMap;
import java.util.Map;

public class rrdduullrr {
    public static void main(String[] args) {
        String directions = "RRRRRR";
        int[] loopCoordinates = findLongestLoop(directions);
        if (loopCoordinates != null) {
            System.out.println("(" + loopCoordinates[0] + ", " + loopCoordinates[1] + ")");
        } else {
            System.out.println("В маршруте нет петель");
        }
    }

    public static int[] findLongestLoop(String directions) {
        Map<Character, Integer> directionCounts = new HashMap<>();
        int x = 0;
        int y = 0;
        int maxLength = 0;
        int[] loopCoordinates = null;
        int startIndex = 0;
        for (int i = 0; i < directions.length(); i++) {
            char direction = directions.charAt(i);
            switch (direction) {
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
            }
            if (directionCounts.containsKey(direction)) {
                int loopLength = calculateLoopLength(x, y, directionCounts.get(direction));
                if (loopLength > maxLength) {
                    maxLength = loopLength;
                    startIndex = directionCounts.get(direction);
                }
            } else {
                directionCounts.put(direction, i);
            }
        }
        if (maxLength > 0) {
            loopCoordinates = new int[]{startIndex, startIndex + maxLength};
        }
        return loopCoordinates;
    }
    public static int calculateLoopLength(int x, int y, int startIndex) {
        return Math.abs(x - startIndex) + Math.abs(y);
    }}