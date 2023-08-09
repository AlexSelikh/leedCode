package com.example.exlample;

import java.util.HashMap;
import java.util.Map;

public class Bankomat {
    private Map<Integer, Integer> bills = new HashMap<>();

    public Bankomat() {
        bills.put(50, 10);
        bills.put(100, 10);
        bills.put(500, 10);
        bills.put(1000, 10);
        bills.put(5000, 10);
    }

    public void issueBill(int amount) {
        if (amount % 50!= 0) {
            System.out.println("Недопустимая сумма");
            return;
        }

        int billAmount = 50;
        int billCount = 0;

        while (amount >= billAmount) {
            int count = bills.get(billAmount);
            if (count > 0) {
                bills.put(billAmount, count - 1);
                billCount++;
                amount -= billAmount;
            } else {
                break;
            }
        }

        if (billCount > 0) {
            System.out.println("Вы выдали " + billCount + " купюр " + billAmount + "₽");
        } else {
            System.out.println("Недостаточно средств");
        }
    }

    public void returnBill(int amount) {
        if (amount % 50!= 0) {
            System.out.println("Недопустимая сумма");
            return;
        }

        int billAmount = 50;
        int billCount = 0;

        while (amount >= billAmount) {
            int count = bills.get(billAmount);
            if (count < 10) {
                bills.put(billAmount, count + 1);
                billCount++;
                amount -= billAmount;
            } else {
                break;
            }
        }

        if (billCount > 0) {
            System.out.println("Вы вернули " + billCount + " купюр " + billAmount + "₽");
        } else {
            System.out.println("Недостаточно купюр");
        }
    }
}

