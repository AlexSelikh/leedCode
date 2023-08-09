package com.example.exlample;

import java.util.ArrayDeque;
public class MessageBuffer {
    private final ArrayDeque<String> queue;
    private final int maxSize;
    public MessageBuffer(int maxSize) {
        this.queue = new ArrayDeque<>();
        this.maxSize = maxSize;
    }
    public void write(String log) {
        if (queue.size() >= maxSize) {
            queue.poll(); // Удаляем старый лог, если достигнут максимальный размер
        }
        queue.offer(log); // Добавляем новый лог в очередь
    }
    public String read() {
        return queue.poll(); // Извлекаем и возвращаем первый лог из очереди
    }
}