package com.example.aspectj;


import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ArithmeticOperation {


    Scanner sc = new Scanner(System.in);    //taking values from console

    //Initially Assigning Numbers to 0
    int numberOne_initial=0;
    int numberTwo_initial=0;

    //Getter and Setters
    public int getNumberOne_initial() {
        return numberOne_initial;
    }

    public void setNumberOne_initial(int numberOne_initial) {
        this.numberOne_initial = numberOne_initial;
    }

    public int getNumberTwo_initial() {
        return numberTwo_initial;
    }

    public void setNumberTwo_initial(int numberTwo_initial) {
        this.numberTwo_initial = numberTwo_initial;
    }

     public int arithmeticMethods() throws Exception {

      this.setNumberOne_initial(sc.nextInt());
      this.setNumberTwo_initial(sc.nextInt());

        int numberOne_after=this.getNumberOne_initial();
        int numberTwo_after =this.getNumberTwo_initial();

            if(numberOne_after<0 & numberTwo_after<0){
                throw new ArithmeticException(" 'No negatives allowed' ");
            }
            else{
                return (numberOne_after+numberOne_after);
            }
    }
}

















