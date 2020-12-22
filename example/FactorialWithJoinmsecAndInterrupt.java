package com.multithread.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 *
 *             // BUt as the first value is like 1000000 then it will take time and rest of the records also stop processing.
 *            // List<Integer> streamList = Stream.of(new Integer[]{11000000,20, 3435, 40, 10, 4, 6, 9}).collect(Collectors.toList());
 *             // to not to have blocking Use case we can have time limit in msec in the join method
 *             sss.join(2000);// so it will wait for 2 secs and then process the other thread values., but process will not terminate.
 *             //SO to terminate the threads we have two options , Either Interrupt
 *
 *             Interrupt is the option.
 */
public class FactorialWithJoinmsecAndInterrupt {


    public static void main(String[] args) throws InterruptedException {
        List<Integer> streamList = Stream.of(new Integer[]{11000000,20, 3435, 40, 10, 4, 6, 9}).collect(Collectors.toList());

        List<FactorialThread> threadList = new ArrayList<>();
        for (int i : streamList) {
            FactorialThread thread = new FactorialThread(i);
            threadList.add(thread);
            Thread sss = new Thread(thread);

            sss.start();
            sss.join(2000);
            sss.interrupt();
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


