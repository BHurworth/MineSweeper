package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MineSweeperGame minesweeper = new MineSweeperGame();
        minesweeper.StartNewGame();
    }
}

//lunchtime tomorrow


/*
    - Functions longer than 50 lines should be scrutinized, classes longer than 200 lines also. These are general rules but if they're longer it often means you aren't doing SOC or DRY properly.
    - keep an eye on cyclomatic complexity: nested loops? Break the inner loop out into a well named function
    - SOC: are all the methods in this class _actually_ returning information about the object, making the object do something, or updating the object's state in some way?
    - Encapsulation: are your classes bundling in all the necessary data & logic? Do you find yourself passing the same arguments into the methods of an object frequently? If so should they be fields instead?
    - Abstraction/public interfaces/decoupling: are parts of your program highly coupled? If you made a non-breaking implementation change to one class, would it significantly change the way other parts of the program interact with it? Even large breaking changes to one class should require as few updates to other parts of the code as possible. To decouple code, use abstraction (e.g. abstract classes, interfaces, generics) and design patterns like the Adapter and Strategy patterns.
    - practice
 */