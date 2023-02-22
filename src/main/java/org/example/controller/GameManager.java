package org.example.controller;

import org.example.model.Player;
import org.example.model.Team;
import org.example.view.Scoreboard;

import java.util.ArrayList;

public class GameManager {
public void play(Team teamA, Team teamB, int numOvers)
{
    //innings 01
    ArrayList<Player> teamAPlayers = teamA.getTeamMembers();
    int index = 2;
    int target;
    Player striker = teamAPlayers.get(0);
    Player runner = teamAPlayers.get(1);
    outer:
    for(int i = 0; i<numOvers; i++){
        for(int bowl=0;bowl<6;bowl++){
            teamA.setTotalBalls(teamA.getTotalBalls()+1);
            int runs;
            if(index>6){
                runs = striker.getRunABall("bowler");
            }
            else {
                runs = striker.getRunABall("batsman");
            }
            if(runs==5 || runs >= 7){
                striker.setBallsFaced(striker.getBallsFaced()+1);
                striker.setOut(true);
                teamA.addWickets();
                if(index == 11)break outer;
                striker = teamAPlayers.get(index++);
            }
            else if(runs == 6 || runs == 4 ||runs ==2 || runs == 0){
                striker.setRunsScored(striker.getRunsScored()+runs);
                striker.setBallsFaced(striker.getBallsFaced()+1);
                teamA.addRuns(runs);

            }
            else if(runs == 3 || runs == 1){
                striker.setRunsScored(striker.getRunsScored()+runs);
                striker.setBallsFaced(striker.getBallsFaced()+1);
                Player temp = striker;
                striker = runner;
                runner = temp;
                teamA.setTotalScore(teamA.getTotalScore()+runs);
            }
        }
    }
    target = teamA.getTotalScore()+1;
    //innings 02
    ArrayList<Player> teamBPlayers = teamB.getTeamMembers();
    int in = 2;
    Player strike = teamBPlayers.get(0);
    Player nonStrike = teamBPlayers.get(1);
    outer2:
    for(int i = 0; i<numOvers; i++){
        for(int bowl=0;bowl<6;bowl++){
            int runs;
            teamB.setTotalBalls(teamB.getTotalBalls()+1);
            if(in>6){
                runs = strike.getRunABall("bowler");
            }
            else {
                runs = strike.getRunABall("batsman");
            }
            if((runs>=7 || runs == 5) && teamB.getTotalScore()<target){
                strike.setOut(true);
                strike.setBallsFaced(strike.getBallsFaced()+1);
                teamB.addWickets();
                if(in == 11)break outer2;
                strike = teamBPlayers.get(in++);
            }
            // six
            else if(runs == 6 || runs == 4 || runs == 2 || runs == 0){
                strike.setRunsScored(strike.getRunsScored()+runs);
                strike.setBallsFaced(strike.getBallsFaced()+1);
                teamB.addRuns(runs);
            }
            else if((runs == 3 || runs == 1)){
                strike.setRunsScored(strike.getRunsScored()+runs);
                strike.setBallsFaced(strike.getBallsFaced()+1);
                Player temp = strike;
                strike = nonStrike;
                nonStrike = temp;
                teamB.setTotalScore(teamB.getTotalScore()+runs);
            }
           if(teamB.getTotalScore()>=target)break outer2;
        }
    }
    Scoreboard sb = new Scoreboard();
    sb.printScore(teamA, teamB, numOvers);
}
}
