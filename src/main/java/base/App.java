/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Liam Pido
 */

/*
Exercise 8 - Pizza Party

Division isn’t always exact, and sometimes you’ll write programs that will need to deal with the leftovers as a whole number instead of a decimal.

Write a program to evenly divide pizzas. Prompt for the number of people, the number of pizzas, and the number of slices per pizza.
Ensure that the number of pieces comes out even. Display the number of pieces of pizza each person should get.
If there are leftovers, show the number of leftover pieces.

Example Output

How many people? 8
How many pizzas do you have? 2
How many slices per pizza? 8
8 people with 2 pizzas (16 slices)
Each person gets 2 pieces of pizza.
There are 0 leftover pieces.

Challenges

Revise the program to ensure that inputs are entered as numeric values. Don’t allow the user to proceed if the value entered is not numeric.
Alter the output so it handles pluralization properly, for example: "Each person gets 2 pieces of pizza." or "Each person gets 1 piece of pizza." Handle the output for leftover pieces appropriately as well.
Create a variant of the program that prompts for the number of people and the number of pieces each person wants, and calculate how many full pizzas you need to purchase.
 */

package base;

import java.util.Scanner;

public class App {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        App myApp = new App();

        int people = myApp.inputPeople();
        int pizzas = myApp.inputPizzas();
        int slices = myApp.inputSlices(pizzas);
        myApp.output(people, pizzas, slices);
    }

    public void output(int people, int pizzas, int slices) {
        int pieces = 0;
        int leftover;

        if((slices % people) == 0) {
            pieces = (slices / people);
            leftover = 0;
        } else {
            leftover = (slices % people);
            pieces = ((slices - leftover) / people);
        }

        System.out.println(people + " people with " + pizzas + " pizzas (" + slices + " slices)");
        System.out.println("Each person gets " + pieces + " pieces of pizza.");
        System.out.println("There are " + leftover + " leftover pieces.");

    }

    private int inputSlices(int pizzas) {
        System.out.print("How many slices per pizza? ");
        String input = in.nextLine();
        int per = Integer.parseInt(input);
        return (per * pizzas);
    }

    public int inputPizzas() {
        System.out.print("How many pizzas do you have? ");
        String input = in.nextLine();
        return Integer.parseInt(input);
    }

    public int inputPeople() {
        System.out.print("How many people? ");
        String input = in.nextLine();
        return Integer.parseInt(input);
    }

}
