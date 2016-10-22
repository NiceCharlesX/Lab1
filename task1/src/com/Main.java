
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
            while(input.hasNextLine())
            {
                String sim = input.nextLine();
                a.setSim(sim);
                if (sim.contains("!simplify")){
                    a.simplify();
                    System.out.println();
                }
                else if (sim.contains("!d/d")){
                    a.derivative();
                    System.out.println();
                }
                else {
                    System.out.println("Error!");
                }
            }
        }
    }
}



