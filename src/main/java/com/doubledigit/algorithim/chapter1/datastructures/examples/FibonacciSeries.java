package com.doubledigit.algorithim.chapter1.datastructures.examples;

import javafx.util.Pair;

import java.math.BigInteger;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciSeries {
    private static final Pair<BigInteger, BigInteger> base = new Pair<>(BigInteger.ZERO, BigInteger.ONE);

    public static void main(String[] args) {
        UnaryOperator<Pair<BigInteger, BigInteger>> fib = new UnaryOperator<Pair<BigInteger, BigInteger>>() {
            @Override
            public Pair<BigInteger, BigInteger> apply(Pair<BigInteger, BigInteger> pair) {
                return new Pair<>(pair.getValue(), pair.getKey().add(pair.getValue()));
            }
        };

        String fibonacci = Stream.iterate(base, fib)
                .map(new Function<Pair<BigInteger, BigInteger>, BigInteger>() {
            @Override
            public BigInteger apply(Pair<BigInteger, BigInteger> pair) {
                return pair.getKey();
            }
        }).limit(20).map(new Function<BigInteger, String>() {
            @Override
            public String apply(BigInteger bigInteger) {
                return String.valueOf(bigInteger);
            }
        }).collect(Collectors.joining(","));

        String lastNumber = Stream.iterate(base, fib)
                .map(new Function<Pair<BigInteger, BigInteger>, BigInteger>() {
                    @Override
                    public BigInteger apply(Pair<BigInteger, BigInteger> pair) {
                        return pair.getKey();
                    }
                }).limit(20).map(new Function<BigInteger, String>() {
                    @Override
                    public String apply(BigInteger bigInteger) {
                        return String.valueOf(bigInteger);
                    }
                }).collect(Collectors.toList()).get(19);

        System.out.println("fibonacci = " + fibonacci);
        System.out.println("lastNumber = " + lastNumber);
    }
}
