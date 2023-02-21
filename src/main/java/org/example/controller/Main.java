package org.example.controller;

import org.example.model.Player;
import org.example.model.Team;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numOvers;
        Team teamA = new Team();
        Team teamB = new Team();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of team one: ");
        teamA.setTeamName(sc.nextLine());
        System.out.println("Enter the name of team two: ");
        teamB.setTeamName(sc.nextLine());
        System.out.println("Enter the number of overs you want to play: ");
        numOvers = sc.nextInt();sc.nextLine();
        //System.out.println("Enter the details of " + teamA.getTeamName() + " players");
        for(int i=0;i<11;i++){
            //System.out.println("Enter the name of player " + (i+1));
            Player Pi = new Player(teamA.getTeamName()+(i+1));
            teamA.getTeamMembers().add(Pi);
        }

        //System.out.println("Enter the details of " + teamB.getTeamName() + " players");
        for(int i=0;i<11;i++){
            //System.out.println("Enter the name of player " + (i+1));
            Player Pi = new Player(teamB.getTeamName()+(i+1));
            teamB.getTeamMembers().add(Pi);
        }
        GameManager newGame = new GameManager();
        newGame.play(teamA, teamB, numOvers);
    }
}