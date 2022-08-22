package com.test.tennis;

import java.util.HashMap;
import java.util.Map;

public class Tennis {

  private String firstPlayer;

  private String secondPlayer;

  private int firstPlayerScore;

  private int secondPlayerScore;

  public Tennis(String firstPlayer, String secondPlayer) {
    this.firstPlayer = firstPlayer;
    this.secondPlayer = secondPlayer;
  }

  public String score() {

    Map<Integer, String> map = new HashMap<>();
    map.put(0, "love");
    map.put(1, "fifteen");
    map.put(2, "thirty");
    map.put(3, "forty");

    if (isEven()) {
      if (isBothGamePoint()) {
        return "deuce";
      }
      return map.get(this.firstPlayerScore) + " all";
    }

    if (isOneGamePoint()) {
      String playerName =
          this.firstPlayerScore > this.secondPlayerScore ? this.firstPlayer : this.secondPlayer;
      if (isBothGamePoint()) {
        if (isDiffLargerThan2()) {
          return playerWin(playerName);
        }
        return playerAdv(playerName);
      }
      if (isOneOverGamePoint()) {
        return playerWin(playerName);
      }
    }
    return map.get(this.firstPlayerScore) + " " + map.get(this.secondPlayerScore);
  }

  private String playerAdv(String playerName) {
    return playerName + " adv";
  }

  private boolean isOneOverGamePoint() {
    return this.firstPlayerScore > 3 || this.secondPlayerScore > 3;
  }

  private String playerWin(String playerName) {
    return playerName + " win";
  }

  private boolean isOneGamePoint() {
    return this.firstPlayerScore >= 3 || this.secondPlayerScore >= 3;
  }

  private boolean isDiffLargerThan2() {
    return Math.abs(this.firstPlayerScore - this.secondPlayerScore) >= 2;
  }

  private boolean isBothGamePoint() {
    return this.firstPlayerScore >= 3 && this.secondPlayerScore >= 3;
  }

  private boolean isEven() {
    return this.firstPlayerScore == this.secondPlayerScore;
  }


  public void addFirstPlayerScore() {
    this.firstPlayerScore++;
  }

  public void addSecondPlayerScore() {
    this.secondPlayerScore++;
  }
}
