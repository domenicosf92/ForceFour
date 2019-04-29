package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int choice,column;
        String sign;
        GameBoard forceFour = new GameBoard();
        do {
            System.out.println("--Force Four game test-- \n0. Exit \n1. Add sign \n2. Reset board \n3. Print board status");
            System.out.println("Choice: ");
            choice=s.nextInt();
            switch (choice){
                case 0:
                    break;
                case 1:
                    System.out.println("Column: ");
                    column=s.nextInt();
                    System.out.println("Sign: ");
                    sign=s.next();
                    System.out.println(forceFour.setSign(column,sign));
                    break;
                case 2:
                    forceFour.resetBoard();
                    break;
                case 3:
                    forceFour.showGameBoard();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }while (choice!=0);
    }
}
