package de.uni_hannover.hci.task1.model;
//package model;

public class Fraction {
    int upper;
    int lower;

    public Fraction(int num, int denom){
        upper = num;
        lower = denom;
        reduce();
    }
    
    public String str() {
        String str =  String.format("%d/%d", upper, lower);
        return str;
    }

    public int getNumerator() {
        return upper;
    }

    public int getDenominator() {
        return lower;
    }

    public void setNumerator(int num) {
        upper = num;
    }

    public void setDenominator(int denom) {
        lower = denom;
    }

    private void reduce() {
        if (upper < lower) {
            for (int i = upper; i > 1; i--){
                if (upper % i == 0 && lower % i == 0) {
                    upper = upper / i;
                    lower = lower / i;
                    break;
                }
            }
        }
        else {
            for (int i = lower; i > 1; i--){
                if (lower % i == 0 && upper % i == 0) {
                    upper = upper / i;
                    lower = lower / i;
                    break;
                }
            }
        }
    }

    public void setValues (int num, int denom) {
        upper = num;
        lower = denom;
        reduce();
    }

    private void extend(int amount) {
        upper = upper * amount;
        lower = lower * amount;
    }

    public static Fraction add(Fraction summandA, Fraction summandB) {
        Fraction sum = new Fraction(1, 1);
        sum.lower = summandA.lower * summandB.lower;
        sum.upper = summandA.upper * summandB.lower + summandA.lower * summandB.upper;
        sum.reduce();
        return sum;
    }

    public static Fraction multiply(Fraction multiplicandA, Fraction multiplicandB) {
        Fraction prod = new Fraction(1, 1);
        prod.upper = multiplicandA.upper * multiplicandB.upper;
        prod.lower = multiplicandA.lower * multiplicandB.lower;
        prod.reduce();
        return prod;
    }
}        
