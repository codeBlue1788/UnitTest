import com.test.tennis.Tennis;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class test {

  private Tennis tennis;

  @BeforeEach
  void setUp() {
    tennis = new Tennis("tom", "jerry");
  }

  @Test
  void name() {
    System.out.println("hello world");
  }

  @Test
  void love_all() {
    Assertions.assertEquals("love all", tennis.score());
  }

  @Test
  void fifteen_all() {
    addFirstPlayerScore(1);
    addSecondPlayer(1);

    Assertions.assertEquals("fifteen all", tennis.score());
  }


  @Test
  void thirty_all() {
    addFirstPlayerScore(2);
    addSecondPlayer(2);

    Assertions.assertEquals("thirty all", tennis.score());
  }

  @Test
  void deuce() {
    addFirstPlayerScore(3);
    addSecondPlayer(3);

    Assertions.assertEquals("deuce", tennis.score());
  }

  @Test
  void fifteen_love() {
    addFirstPlayerScore(1);

    Assertions.assertEquals("fifteen love", tennis.score());
  }

  @Test
  void tom_win() {
    addFirstPlayerScore(5);
    addSecondPlayer(3);

    Assertions.assertEquals("tom win", tennis.score());
  }

  @Test
  void jerry_win() {
    addFirstPlayerScore(5);
    addSecondPlayer(7);

    Assertions.assertEquals("jerry win", tennis.score());
  }


  @Test
  void tom_adv() {
    addFirstPlayerScore(4);
    addSecondPlayer(3);

    Assertions.assertEquals("tom adv", tennis.score());
  }

  @Test
  void tom_win_4_0() {
    addFirstPlayerScore(4);
    addFirstPlayerScore(4);

    Assertions.assertEquals("tom win", tennis.score());
  }

  @Test
  void forty_thirty() {
    addFirstPlayerScore(3);
    addSecondPlayer(2);

    Assertions.assertEquals("forty thirty", tennis.score());
  }



  private void addSecondPlayer(int num) {
    for (int i = 0; i < num; i++) {
      tennis.addSecondPlayerScore();
    }
  }

  private void addFirstPlayerScore(int num) {
    for (int i = 0; i < num; i++) {
      tennis.addFirstPlayerScore();
    }
  }
}
