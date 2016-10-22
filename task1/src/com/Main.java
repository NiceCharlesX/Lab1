
package com;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        Model a = new Model();
        a.setName(str);
        a.print();
        a.expression();
        a.trueorfalse();
        if (!a.isFlag()){
            System.out.println("Error!");
        }
        else{
            String sim = input.nextLine();
            a.setSim(sim);
            if (sim.contains("!simplify")){
                a.simplify();
            }
            else if (sim.contains("!d/d")){
                a.derivative();
            }
            else {
                System.out.println("Error!");
            }
        }
    }
}



