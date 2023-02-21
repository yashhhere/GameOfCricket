package org.example.model;

public class Player {
 private String playerName;
 private int wicketTaken;
 private int runsScored;
 private int ballsFaced;
 private boolean isOut;
 public boolean ifBallFaced(){
   if(getBallsFaced()!=0)return true;
   else return false;
 }

 public boolean isOut() {
  return isOut;
 }

 public void setOut() {
  isOut = true;
 }

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
