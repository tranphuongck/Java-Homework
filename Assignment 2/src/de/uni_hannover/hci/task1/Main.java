package de.uni_hannover.hci.task1;
import de.uni_hannover.hci.task1.model.Fraction;
//import model.Fraction;

public class Main {
    public static void main(String[] args){
    	//Aufgabe a
        int a = 15;
        int b = 65;
        Fraction f = new Fraction(a, b);
        System.out.println(f.str());
        f.setNumerator(16);
        System.out.println(f.str());
        f.setValues(7, 21);
        System.out.println(f.str());
        
        //Aufgabe b
        Fraction f1 = new Fraction (1, 2);
        Fraction f2 = new Fraction (2, 3);
        Fraction f3 = Fraction.add(f1 , f2);
        System.out.println(f3.str());
        
        //Aufgabe c
        Fraction f4 = new Fraction (1, 2);
        Fraction f5 = new Fraction (2, 3);
        Fraction f6 = Fraction.multiply(f4 , f5);
        System.out.println(f6.str());
    }
}        
