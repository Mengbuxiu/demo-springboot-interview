package com.java.book.java_network_programing._4_12;

import com.java.book.java_network_programing._4_11.LookupTask;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Alin
 * @desc //读取文件，并为每一行创建一个
 * {@link com.java.book.java_network_programing._4_11.LookupTask}
 * @date 2020/4/9
 */
public class PooledWebLog {
    private final static int NUM_THREADS = 4;

    public static void main(String[] args) {
        final ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        final LinkedList<LogEntry> results = new LinkedList<>();
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(args[0]), StandardCharsets.UTF_8
                ))) {
            for (String entry = in.readLine(); entry != null; entry = in.readLine()){
                final LookupTask task = new LookupTask(entry);
                final Future<String> future = executor.submit(task);
                results.add(new LogEntry(entry, future));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (LogEntry result : results) {
            try {
                System.out.println(result.future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }

    private static class LogEntry {
        String entry;
        Future<String> future;
        public LogEntry(String entry, Future<String> future) {
            this.entry = entry;
            this.future = future;
        }

        @Override
        public String toString() {
            return "LogEntry{" +
                    "entry='" + entry + '\'' +
                    ", future=" + future +
                    '}';
        }
    }
}
