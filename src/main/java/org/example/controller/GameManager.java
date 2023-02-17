package org.example;

import java.util.ArrayList;

public class GameManager {
public void play(Team teamA, Team teamB, int numOvers)
{
    //innings 01
    ArrayList<Player> teamAPlayers = teamA.getTeamMembers();
    int index = 2;int target;
    Player striker = teamAPlayers.get(0);
    Player runner = teamAPlayers.get(1);
    outer:
    for(int i = 0; i<numOvers; i++){
        for(int bowl=0;bowl<6;bowl++){
            teamA.setTotalBalls(teamA.getTotalBalls()+1);
            int runs=(int)(Math.random()*8);
            if(runs==7){
                teamA.addWickets();
                if(index == 11)break outer;
                striker = teamAPlayers.get(index++);
            }
            // six
            else if(runs == 6){
                striker.setRunsScored(striker.getRunsScored()+6);
                teamA.addRuns(6);

            }
            // four
            else if(runs == 4){

                striker.setRunsScored(striker.getRunsScored()+4);
                teamA.setTotalScore(teamA.getTotalScore()+4);
            }

            else if(runs == 5 || runs == 3 || runs == 1){
                Player temp = striker;
                striker = runner;
                runner = temp;
                striker.setRunsScored(striker.getRunsScored()+runs);
                teamA.addRuns(runs);
            }

        }
    }
    target = teamA.getTotalScore()+1;
    //innings 02
    ArrayList<Player> teamBPlayers = teamB.getTeamMembers();
    int ind = 2;
    Player strike = teamBPlayers.get(0);
    Player nonStrike = teamBPlayers.get(1);
    outer:
    for(int i = 0; i<numOvers; i++){
        for(int bowl=0;bowl<6;bowl++){
            teamB.setTotalBalls(teamB.getTotalBalls()+1);
            int runs=(int)(Math.random()*8);
            if((runs==7) && teamB.getTotalScore()<target){
                teamB.addWickets();
                if(index == 11)break outer;
                strike = teamBPlayers.get(ind++);
            }
            // six
            else if(runs == 6 && teamB.getTotalScore()<target){
                strike.setRunsScored(strike.getRunsScored()+6);
                teamB.addRuns(6);

            }
            // four
            else if(runs == 4 && teamB.getTotalScore()<target){

                strike.setRunsScored(strike.getRunsScored()+4);
                teamB.setTotalScore(teamB.getTotalScore()+4);
            }

            else if((runs == 5 || runs == 3 || runs == 1) && teamB.getTotalScore()<target){
                strike.setRunsScored(strike.getRunsScored()+runs);
                Player temp = strike;
                strike = nonStrike;
                nonStrike = temp;
                teamB.addRuns(runs);
            }

        }
    }
    if(teamB.getTotalScore()>=target && teamB.getTotalWickets()<10 && teamB.getTotalBalls()<=numOvers*6){
        System.out.println(teamB.getTeamName() + " have won the match by "+ (10-teamB.getTotalWickets()));
    }
    else {
        System.out.println(teamB.getTeamName() + " have lost the match by "+(target - teamB.getTotalScore()) + " runs.");
    }
}
}
