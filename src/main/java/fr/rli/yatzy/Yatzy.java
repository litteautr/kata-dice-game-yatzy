package fr.rli.yatzy;

public class Yatzy {

    public static final int YATZY_SCORE = 50;
    public static final int MISSED_ROLL_SCORE = 0;
    public static final int SMALL_STRAIGHT_SCORE = 15;
    public static final int LARGE_STRAIGHT_SCORE = 20;
    public static final String SMALL_STRAIGHT_VALUE = "12345";
    public static final String LARGE_STRAIGHT_VALUE = "23456";

    private DiceRoll diceRoll;

    public Yatzy(DiceRoll diceRoll) {
        this.diceRoll = diceRoll;
    }

    public int score(YatzyCategory category) {
        return category.score(diceRoll);
    }
}




