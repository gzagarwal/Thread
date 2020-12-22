package com.multithread.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 *
 * Nothing will process all threads will just execute in this scenario
 */
public class MultiThread {


    public static void main(String[] args) throws InterruptedException {
        List<Integer> streamList = Stream.of(new Integer[]{20, 3435, 40, 10, 4, 6, 9}).collect(Collectors.toList());

        List<FactorialThread> threadList = new ArrayList<>();
        for (int i : streamList) {
            FactorialThread thread = new FactorialThread(i);
            threadList.add(thread);
            Thread sss = new Thread(thread);
            sss.start();
        }


        for (int l = 0; l < threadList.size(); l++) {
            FactorialThread lkkk = threadList.get(l);
            if (lkkk.isFinished()) {
                System.out.println("Nothing will process "+ lkkk.getResult());
            } else {
                System.out.println("Processing for the factorial NUmber [{}]" + l + " " + lkkk.factorial);
            }
        }
    }
}
