package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numOvers;
        Team teamA = new Team();
        Team teamB = new Team();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of team one: ");
        teamA.teamName = sc.nextLine();
        System.out.println("Enter the name of team two: ");
        teamB.teamName = sc.nextLine();
        System.out.println("Enter the number of overs you want to play: ");
        numOvers = sc.nextInt();sc.nextLine();
        System.out.println("Enter the details of "+ teamA.teamName + " players");
        for(int i=0;i<11;i++){

            System.out.println("Enter the name of player " + (i+1));
            Player Pi = new Player(sc.nextLine());
            teamA.teamMembers.add(Pi);
        }
        System.out.println("Enter the details of "+ teamB.teamName + " players");
        for(int i=0;i<11;i++){

            System.out.println("Enter the name of player " + (i+1));
            Player Pi = new Player(sc.nextLine());
            teamB.teamMembers.add(Pi);
        }
        GameManager newGame = new GameManager();
        newGame.play(teamA, teamB, numOvers);
    }
}