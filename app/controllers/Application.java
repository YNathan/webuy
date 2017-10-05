package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static String szDbPassword = "sh123456";

    public static Result index() {
        System.out.println("\n[INFO] WeBuy Server say new Session\n");
        printNiceForm();
        return redirect("assets/index.html");
    }

    private static void printNiceForm() {
        String ANSI_RESET = "\u001B[0m";
        //Okay, ... I cheated and used normal black for brown
        //and bright yellow for tan. Don't tell!
        String RED_FILL = "\u001B[0;41m ";
        String BLUE_FILL = "\u001B[0;44m ";
        String CYAN_FILL = "\u001B[0.46m ";
        String YELLOW_FILL = "\u001B[1;43m ";
        String WHITE_FILL = "\u001B[0;47m ";
        String BLACK_FILL = "\u001B[0;40m ";
        String BROWN_FILL = "\u001B[0;40m ";
        String GREEN_FILL = "\u001B[0;42m ";

        System.out.println(
                WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + ANSI_RESET
        );

        System.out.println(
                WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + RED_FILL + RED_FILL +
                        RED_FILL + RED_FILL + RED_FILL +
                        WHITE_FILL + WHITE_FILL + YELLOW_FILL +
                        YELLOW_FILL + YELLOW_FILL + WHITE_FILL +
                        WHITE_FILL + ANSI_RESET
        );


        System.out.println(
                WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        RED_FILL + RED_FILL + RED_FILL +
                        RED_FILL + RED_FILL + RED_FILL +
                        RED_FILL + RED_FILL + RED_FILL +
                        YELLOW_FILL + YELLOW_FILL + WHITE_FILL +
                        WHITE_FILL + ANSI_RESET
        );


        System.out.println(
                WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        BROWN_FILL + BROWN_FILL + BROWN_FILL +
                        YELLOW_FILL + YELLOW_FILL + BLACK_FILL +
                        YELLOW_FILL + WHITE_FILL + RED_FILL +
                        RED_FILL + RED_FILL + WHITE_FILL +
                        WHITE_FILL + ANSI_RESET
        );


        System.out.println(
                WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + BROWN_FILL +
                        YELLOW_FILL + BROWN_FILL + YELLOW_FILL +
                        YELLOW_FILL + YELLOW_FILL + BLACK_FILL +
                        YELLOW_FILL + YELLOW_FILL + YELLOW_FILL +
                        RED_FILL + RED_FILL + WHITE_FILL +
                        WHITE_FILL + ANSI_RESET
        );


        System.out.println(
                WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + BROWN_FILL +
                        YELLOW_FILL + BROWN_FILL + BROWN_FILL +
                        YELLOW_FILL + YELLOW_FILL + YELLOW_FILL +
                        BLACK_FILL + YELLOW_FILL + YELLOW_FILL +
                        YELLOW_FILL + RED_FILL + WHITE_FILL +
                        WHITE_FILL + ANSI_RESET
        );


        System.out.println(
                WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + BROWN_FILL +
                        BROWN_FILL + YELLOW_FILL + YELLOW_FILL +
                        YELLOW_FILL + YELLOW_FILL + BLACK_FILL +
                        BLACK_FILL + BLACK_FILL + BLACK_FILL +
                        RED_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + ANSI_RESET
        );


        System.out.println(
                WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + YELLOW_FILL + YELLOW_FILL +
                        YELLOW_FILL + YELLOW_FILL + YELLOW_FILL +
                        YELLOW_FILL + YELLOW_FILL + RED_FILL +
                        RED_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + ANSI_RESET
        );


        System.out.println(
                WHITE_FILL + YELLOW_FILL + YELLOW_FILL +
                        YELLOW_FILL + RED_FILL + RED_FILL +
                        RED_FILL + RED_FILL + BLUE_FILL +
                        RED_FILL + RED_FILL + RED_FILL +
                        BLUE_FILL + RED_FILL + RED_FILL +
                        WHITE_FILL + WHITE_FILL + BROWN_FILL +
                        WHITE_FILL + ANSI_RESET
        );


        System.out.println(
                WHITE_FILL + YELLOW_FILL + YELLOW_FILL +
                        YELLOW_FILL + RED_FILL + RED_FILL +
                        RED_FILL + RED_FILL + RED_FILL +
                        BLUE_FILL + RED_FILL + RED_FILL +
                        RED_FILL + BLUE_FILL + RED_FILL +
                        WHITE_FILL + BROWN_FILL + BROWN_FILL +
                        WHITE_FILL + ANSI_RESET
        );


        System.out.println(
                WHITE_FILL + WHITE_FILL + YELLOW_FILL +
                        WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        RED_FILL + RED_FILL + RED_FILL +
                        BLUE_FILL + BLUE_FILL + BLUE_FILL +
                        BLUE_FILL + CYAN_FILL + BLUE_FILL +
                        BLUE_FILL + BROWN_FILL + BROWN_FILL +
                        WHITE_FILL + ANSI_RESET
        );


        System.out.println(
                WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + BLUE_FILL + BLUE_FILL +
                        BLUE_FILL + CYAN_FILL + BLUE_FILL +
                        BLUE_FILL + BLUE_FILL + BLUE_FILL +
                        BLUE_FILL + BROWN_FILL + BROWN_FILL +
                        WHITE_FILL + ANSI_RESET
        );


        System.out.println(
                WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + BROWN_FILL +
                        BROWN_FILL + BLUE_FILL + BLUE_FILL +
                        BLUE_FILL + BLUE_FILL + BLUE_FILL +
                        BLUE_FILL + BLUE_FILL + BLUE_FILL +
                        BLUE_FILL + BROWN_FILL + BROWN_FILL +
                        WHITE_FILL + ANSI_RESET
        );


        System.out.println(
                WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + BROWN_FILL + BROWN_FILL +
                        BROWN_FILL + BLUE_FILL + BLUE_FILL +
                        BLUE_FILL + BLUE_FILL + BLUE_FILL +
                        BLUE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + ANSI_RESET
        );


        System.out.println(
                WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + BROWN_FILL + BROWN_FILL +
                        WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + ANSI_RESET
        );


        System.out.println(
                WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + WHITE_FILL + WHITE_FILL +
                        WHITE_FILL + ANSI_RESET
        );
    }


    public static void smiling() {
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░█████████");
        System.out.println("░░███████░░░░░░░░░░███▒▒▒▒▒▒▒▒███");
        System.out.println("░░█▒▒▒▒▒▒█░░░░░░░███▒▒▒▒▒▒▒▒▒▒▒▒▒███");
        System.out.println("░░░█▒▒▒▒▒▒█░░░░██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██");
        System.out.println("░░░░█▒▒▒▒▒█░░░██▒▒▒▒▒██▒▒▒▒▒▒██▒▒▒▒▒███");
        System.out.println("░░░░░█▒▒▒█░░░█▒▒▒▒▒▒████▒▒▒▒████▒▒▒▒▒▒██");
        System.out.println("░░░█████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██");
        System.out.println("░░░█▒▒▒▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒██");
        System.out.println("░██▒▒▒▒▒▒▒▒▒▒▒▒▒█▒▒▒██▒▒▒▒▒▒▒▒▒▒██▒▒▒▒██");
        System.out.println("██▒▒▒███████████▒▒▒▒▒██▒▒▒▒▒▒▒▒██▒▒▒▒▒██");
        System.out.println("█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒████████▒▒▒▒▒▒▒██");
        System.out.println("██▒▒▒▒▒▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██");
        System.out.println("░█▒▒▒███████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██");
        System.out.println("░██▒▒▒▒▒▒▒▒▒▒████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█");
        System.out.println("░░████████████░░░█████████████████﻿");
    }

}
