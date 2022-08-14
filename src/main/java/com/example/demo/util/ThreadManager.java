package com.example.demo.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager {
    public static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
}
