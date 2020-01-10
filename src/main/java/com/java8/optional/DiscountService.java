package com.java8.optional;

import java.util.Optional;

public class DiscountService {

    public String getDiscountLine(Customer customer){

        return customer.getCard()
                // flatMap to work on Optional<Optional<Integer>>
                .flatMap(this::getDiscountPercentage)
                .map(d -> "Discount% " + d).orElse("");
    }

    private Optional<Integer> getDiscountPercentage(MemberCard card) {
        if(card.getFidelityPoint() >= 100){
            return Optional.of(10);
        }

        if(card.getFidelityPoint() >= 50){
            return Optional.of(3);
        }

        return Optional.empty();
    }


    public static void main(String[] args) {
        DiscountService discountService = new DiscountService();
        System.out.println(discountService.getDiscountLine(new Customer("Vivek", new MemberCard(66))));
        System.out.println(discountService.getDiscountLine(new Customer("Vivek", new MemberCard(3))));
        System.out.println(discountService.getDiscountLine(new Customer()));
    }
}


class Customer {

    String name;
    MemberCard card;

    public Customer() {
    }

    public Customer(String name, MemberCard card) {
        this.name = name;
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Handle null pointer exception for Customer with no member card
    public Optional<MemberCard> getCard() {
        return Optional.ofNullable(card);
    }

    public void setCard(MemberCard card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name=" + name +
                ", card=" + card +
                '}';
    }
}

class MemberCard{
    Integer fidelityPoint;

    public MemberCard(Integer fidelityPoint) {
        this.fidelityPoint = fidelityPoint;
    }

    public MemberCard() {
    }

    public Integer getFidelityPoint() {
        return fidelityPoint;
    }

    public void setFidelityPoint(Integer fidelityPoint) {
        this.fidelityPoint = fidelityPoint;
    }
}