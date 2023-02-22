package org.example.controller;

import org.example.model.Player;
import org.example.model.Team;
import org.example.view.Scoreboard;

import java.util.ArrayList;

public class GameManager {
    private static final int INT_MAX = (int)1e9;
    public void play(Team teamA, Team teamB, int numOvers){
        Inning i1 = new Inning();
        Inning i2 = new Inning();
        i1.playInning(teamA, numOvers, INT_MAX);
        i2.playInning(teamB, numOvers, teamA.getTotalScore()+1);
    }

}

