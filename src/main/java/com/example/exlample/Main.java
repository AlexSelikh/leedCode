package com.example.exlample;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;


public class Main {


    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5};
        int[] ar2 = {6, 7, 8, 9, 10};

        ///List<Integer> stream3= Arrays.asList(stream,stream1);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbers2 = Arrays.asList(6, 7, 8, 9, 10);
        List<List<Integer>> total = Arrays.asList(numbers1, numbers2);
        List<Integer> final1 = total.stream()
                .flatMap(Collection::stream)
                .filter(t -> t % 2 != 0)
                .map(t -> t * 2)
                .collect(Collectors.toList());

        System.out.println(final1);
    }
}
class Test{
    public static void main(String[] args) {
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> { System.out.println("map: " + s);
                    return s.toUpperCase(); })
                .anyMatch(s -> { System.out.println("anyMatch: " + s);
                    return s.startsWith("A"); });

    }
}
 class FindClosest {
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 5, 6, 7, 8, 8, 9 };
        System.out.println(findClosest(arr, 5));
        System.out.println(findClosest(arr, 11));
        System.out.println(findClosest(arr, 4));

    }
    public static int findClosest(int[] arr, int target) {
        int closest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - target) < Math.abs(closest - target)) {
                closest = arr[i];
            }
        }
        return closest;
    }
}
class ArraysEquals{
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 5};
        boolean areEqual = areArraysEqual(array1, array2);
        if (areEqual) {
            System.out.println("Массивы одинаковы");
        } else {
            System.out.println("Массивы различаются");
        }
        Boolean t =Arrays.equals(array1, array2);
        System.out.println(t);
    }
    public static boolean areArraysEqual(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
}
class SecondMin2{
    public static void main(String[] args) {
        int[] array = {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        Arrays.sort(array);
        int secondMin = array[1];
        System.out.println("Второй по минимальности элемент: " + secondMin);
    }
}
class SecondMin {
    public static void main(String[] args) {
        int[] array = new int[]{64, 42, 73, 41, 32, 53, 16, 24,24, 57, 42, 74, 55, 36};
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min1) {
                min2 = min1;
                min1 = array[i];
            } else if (array[i] < min2 && array[i] != min1) {
                min2 = array[i];
            }
        }
        System.out.println("Второй по минимальности элемент: " + min2);
    }

}


class ValidParentheses {
    public static void main(String[] args) {
        String s = "()";

    }

    public boolean isValid(String s) {
        return s.equals("()") || s.equals("[]") || s.equals("{}") || s.equals("()[]{}");

    }
}

class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 3, 3, 3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum); /*(oldValue, newValue) -> oldValue + newValue);*/
        }
        List<Integer> l = new ArrayList<>(map.keySet());
        l.sort((a, b) -> map.get(b) - map.get(a));
        for (int i = 0; i < k; i++) {
            ans[i] = l.get(i);
        }
        return ans;
    }

}


class twoSums {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 8, 0};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int result = target - num;
            if (map.containsKey(result)) {
                return new int[]{map.get(result), num};
            }
            map.put(num, num);

        }
        return new int[]{};
    }
}


class containsDuplicates {
    public static void main(String[] args) {
        int[] nums = {2, 0, 1, 1, 4, 5};

        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }

}


class longestCommonPrefixs {
    public static void main(String[] args) {
        String[] strs = {"a", "bb", "ac"};
        System.out.println(longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strings) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < strings.length - 1; i++) {
            for (int j = 0; j <= strings[i].length(); j++) {
                if (strings[i].charAt(j) == strings[i + 1].charAt(j)) {
                    sb.append(strings[i].charAt(j));
                } else {
                    if (strings[i].charAt(j) != strings[i + 1].charAt(j)) {
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}

class LongesWord {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("Java", "Python", "C++", "JavaScript", "Ruby");
        String longest = words.stream().max(Comparator.comparing(String::length)).orElse("");
        System.out.println(longest);
    }
}

class AverageWord {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("John", 25),
                new User("Alice", 30),
                new User("Bob", 17),
                new User("Emma", 22),
                new User("Mike", 19)
        );
        double avAge = users.stream().mapToInt(User::getAge).filter(age -> age > 18).average().orElse(0);
        System.out.println(avAge);
    }

    @AllArgsConstructor
    @Getter
    @Setter
    protected static class User {
        String name;
        Integer age;
    }
}

class SumKvadratov {
    public static void main(String[] args) {

        List<Integer> total = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum1 = total.stream().filter(nums -> nums % 2 != 0).mapToInt(nums -> nums * nums).sum();
        System.out.println(sum1);

    }
}

class SortStrings {
    public static void main(String[] args) {

        List<String> str = Arrays.asList("Apple", "banana", "apple", "Orange", "banana", "orange");
        List<String> str1 = str.stream().map(String::toLowerCase).distinct().sorted().collect(Collectors.toList());
        System.out.println(str1);
    }
}

class ThreeAAA {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("cat", "apple", "bat", "Antarctica", "dog", "banana", "catapult");

        long count = words.stream()
                .filter(word -> word.toLowerCase().chars().filter(ch -> ch == 'a').count() == 3)
                .count();

        System.out.println(count);
    }
}

class NameA {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("Alice", "Bob", "Anna", "Andrew", "Alex", "Amy", "Amanda");
        List<String> wordsFinal = words.stream()
                .distinct()
                .filter(w -> w.startsWith("A"))
                .filter(s -> s.length() >= 5)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(wordsFinal);

    }
}

class AvgOver {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(105, 76, 145, 312, 225, 178, 255);
        double avg = nums.stream()
                .filter(n -> n > 100).filter(n -> n % 10 == 5)
                .mapToInt(n -> n).average().orElse(0);
        System.out.println(avg);
    }
}

class ArraysIndexSeach {
    public static void main(String[] args) {
        int a = 7;
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 3, 5, 6));
        nums.add(a);
        List<Integer> numsf = nums.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(numsf.indexOf(a));
    }
}

class TestArraysIndexSeach {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 8, 9, 10};
        int a = 10;
        int indexOfA = 0;
        for (int i = 0; i < nums.length; i++) {
            if (a > nums[i]) {
                indexOfA++;
            } else {
                indexOfA = i;
                break;
            }
        }
        System.out.println(indexOfA);
    }
}

class removeElements {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 4, 2};
        int val = 4;

        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        int[] stream = stream(nums).filter(n -> n != val).toArray();
        /*nums = stream;*/

        System.out.println(Arrays.toString(stream));
        return stream.length;
    }
}

class Str {
    public static void main(String[] args) {
        String str = "aсс";

        System.out.println(compressString(str));
    }


    public static String compressString(String input) {
        StringBuilder compressedString = new StringBuilder();
        int count = 1;

        for (int i = 0; i < input.length(); i++) {
            if (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                count++;
            } else {
                compressedString.append(input.charAt(i));
                if (count > 1) {
                    compressedString.append(count);
                }
                count = 1;
            }
        }

        return compressedString.toString();
    }
}

class RomanToInteger {
    public static void main(String[] args) {
        String s = "LIV";
        System.out.println(s.length());
        System.out.println(romanToInt(s));


    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currValue = romanValues.get(s.charAt(i));

            if (currValue < prevValue) {
                result -= currValue;
            } else {
                result += currValue;
            }

            prevValue = currValue;
        }

        return result;
    }
}

class FindMissedNumber {
    public static void main(String[] args) {
        int[] inputArr1 = {2, 1, 4, 3, 6};
        System.out.println(findMissed(inputArr1)); // 3

        int[] inputArr2 = {1, 3, 4, 6, 5};
        System.out.println(findMissed(inputArr2)); // 2

        int[] inputArr3 = {1, 3};
        System.out.println(findMissed(inputArr3)); // 3
    }


    public static int findMissed(int[] inputArr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : inputArr) {
            freq.merge(num, 1, Integer::sum);
        }
        for (int i = 1; i <= inputArr.length; i++) {
            if (!freq.containsKey(i)) {
                return i;
            }
        }
        return -1; // если не найдено пропущенное число
    }

}

class Volwes {
    public static void main(String[] args) {
        String s = "aaabbbccc ddd";
        counrB(s);

    }

    public static void counrB(String s) {
        String[] arr = s.split("");
        String[] arrGl = {"a", "e", "u", "o"};
        int countGl = 0;
        int countSogl = 0;
        for (String value : arr) {
            if (!value.equals(" ")) {
                for (String str : arrGl) {
                    if (str.equals(value)) {
                        countGl++;
                    } else {
                        countSogl++;
                    }
                    break;
                }

            }
        }
        System.out.println("Колличесво согласных: " + countSogl);
        System.out.println("Колличество гласных: " + countGl);
    }

}

class tttt {
    public static void main(String[] args) {


        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });
    }
}



class Palindrom {
    public static void main(String[] args) {
        String s = "ads:da";

        System.out.println(isPalindrome(s));

    }
    public static boolean isPalindrome(String S) {

        int left = 0;
        int right = S.length() - 1;

        while (left < right) {
            char leftChar = S.charAt(left);
            char rightChar = S.charAt(right);


            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }


            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

class MinProduct {
    public static int findMinProduct(int[] sequence) {
        int minProduct = Integer.MAX_VALUE;
        for (int i = 0; i < sequence.length - 1; i++) {
            for (int j = i + 1; j < sequence.length; j++) {
                int product = sequence[i] * sequence[j];
                if (product < minProduct) {
                    minProduct = product;
                }
            }
        }
        return minProduct;
    }
    public static void main(String[] args) {
        int[] sequence = {9, 4, 2, 5, 3};
        int minProduct = findMinProduct(sequence);
        System.out.println("Минимальное произведение пары элементов: " + minProduct);
    }
}

class MyEnum1{
    public static void main(String[] args) {

    }
}
 final class MyEnum {
    public static final MyEnum VALUE1 = new MyEnum("VALUE1", 0);
    public static final MyEnum VALUE2 = new MyEnum("VALUE2", 1);
    public static final MyEnum VALUE3 = new MyEnum("VALUE3", 2);
    private final String name;
    private final int ordinal;
    private MyEnum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }
    public String name() {

        return name;
    }
    public int ordinal() {

        return ordinal;
    }
    public static MyEnum[] values() {
        return new MyEnum[] {
                VALUE1, VALUE2, VALUE3 };
    }
     public static MyEnum valueOf(String name) {
         for (MyEnum value : MyEnum.values()) {
             if (value.name().equals(name)) {
                 return value;
             }
         }
         throw new IllegalArgumentException("No enum constant with name " + name);
     }
}