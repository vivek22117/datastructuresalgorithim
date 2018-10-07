package com.doubledigit.algorithim.chapter1.algorithimChapterOne;

import javafx.util.Pair;

import java.math.BigInteger;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Vivek Kumar Mishra on 07/10/2018.
 */
public class FibSeriesAndFactorialByStream {

    public static void main(String[] args) {
        Pair<BigInteger, BigInteger> pair = new Pair<>(BigInteger.ONE, BigInteger.ONE);
        UnaryOperator<Pair<BigInteger, BigInteger>> f = (x) -> new Pair<>(x.getValue(), x.getKey().add(x.getValue()));
        UnaryOperator<Pair<BigInteger, BigInteger>> g = y -> new Pair<>(y.getKey().add(BigInteger.valueOf(1)), y.getValue().multiply(y.getKey().add(BigInteger.valueOf(1))));

        String fibSeries = Stream.iterate(pair, f).map(Pair::getKey).limit(10).map(BigInteger::toString).collect(Collectors.joining(","));
        System.out.println("Fib Series.. " + fibSeries);

        String factorialSeries = Stream.iterate(pair, g).map(Pair::getValue).limit(10).map(BigInteger::toString).collect(Collectors.joining(","));

        System.out.println("Factorial Series... "+ factorialSeries);
    }

}
