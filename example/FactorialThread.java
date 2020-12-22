package com.multithread.example;

import java.math.BigInteger;

public class FactorialThread implements Runnable {
    Integer factorial;
    BigInteger result;
    boolean isFinished = false;

    public FactorialThread(Integer factorial) {
        this.factorial = factorial;
    }

    public Integer getFactorial() {
        return factorial;
    }

    public BigInteger getResult() {
        return result;
    }

    public boolean isFinished() {
        return isFinished;
    }

    @Override
    public void run() {
        this.result = multiply();
        this.isFinished = true;

    }

    private BigInteger multiply() {
        FactorialThread thread = new FactorialThread(factorial);

        BigInteger output = BigInteger.ONE;
        for (int i = factorial; i > 0; i--) {
            if (Thread.interrupted()) {
                return BigInteger.TEN;
            }
            output = output.multiply(new BigInteger(Integer.toString(i)));
        }

        return output;
    }
}
