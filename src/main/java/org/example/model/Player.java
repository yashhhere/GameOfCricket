package org.example;

public class Player {
 private String playerName;
 private int wicketTaken;
 private int runsScored;
 private int ballsFaced;

 public String getPlayerName() {
  return playerName;
 }

 public void setPlayerName(String playerName) {
  this.playerName = playerName;
 }

 public int getWicketTaken() {
  return wicketTaken;
 }

 public void setWicketTaken(int wicketTaken) {
  this.wicketTaken = wicketTaken;
 }

 public int getRunsScored() {
  return runsScored;
 }

 public void setRunsScored(int runsScored) {
  this.runsScored = runsScored;
 }

 public int getBallsFaced() {
  return ballsFaced;
 }

 public void setBallsFaced(int ballsFaced) {
  this.ballsFaced = ballsFaced;
 }

 public Player(String name){
  playerName = name;
 }

}
