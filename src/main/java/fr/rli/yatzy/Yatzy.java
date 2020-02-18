package fr.rli.yatzy;

import java.util.stream.Collectors;

public class Yatzy {

    public static final int YATZY_SCORE = 50;
    public static final int MISSED_ROLL_SCORE = 0;
    public static final int SMALL_STRAIGHT_SCORE = 15;
    public static final int LARGE_STRAIGHT_SCORE = 20;
    public static final String SMALL_STAIGHT_VALUE = "12345";
    public static final String LARGE_STAIGHT_VALUE = "23456";

    private DiceRoll diceRoll;

    public Yatzy(DiceRoll diceRoll) {
        this.diceRoll = diceRoll;
    }

    public int chance() {
        return diceRoll.getDiceValues().stream().reduce(0, Integer::sum);
    }

    public int yatzy() {
        return diceRoll.allDiceHaveSameNumber() ? YATZY_SCORE : 0;
    }

    public int ones() {
        return diceRoll.sumMatchingDiceForDiceValue(1);
    }

    public int twos() {
        return diceRoll.sumMatchingDiceForDiceValue(2);
    }

    public int threes() {
        return diceRoll.sumMatchingDiceForDiceValue(3);
    }

    public int fours() {
        return diceRoll.sumMatchingDiceForDiceValue(4);
    }

    public int fives() {
        return diceRoll.sumMatchingDiceForDiceValue(5);
    }

    public int sixes() {
        return diceRoll.sumMatchingDiceForDiceValue(6);
    }

    public int pair() {
        return calculateScoreForMatchingDice(2);
    }

    public int threeOfAKind() {
        return calculateScoreForMatchingDice(3);
    }

    public int fourOfAKind() {
        return calculateScoreForMatchingDice(4);
    }

    public int twoPair() {
        int[] countDiceByValue = diceRoll.countDiceByValue();

        int numberOfPairFound = 0;
        int score = 0;
        for (int i = 6; i > 0; i--) {
            if (countDiceByValue[i - 1] >= 2) {
                numberOfPairFound++;
                score += i;
            }
        }

        if (numberOfPairFound == 2) {
            return score * numberOfPairFound;
        } else {
            return MISSED_ROLL_SCORE;
        }
    }

    public int smallStraight() {
        return SMALL_STAIGHT_VALUE.equals(diceRoll.toOrderedString()) ? SMALL_STRAIGHT_SCORE : MISSED_ROLL_SCORE;
    }

    public int largeStraight() {
        return LARGE_STAIGHT_VALUE.equals(diceRoll.toOrderedString()) ? LARGE_STRAIGHT_SCORE : MISSED_ROLL_SCORE;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;


        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }

    private Integer calculateScoreForMatchingDice(int nbOfOccurence) {
        int[] countDiceByValue = diceRoll.countDiceByValue();

        for (int i = 6; i > 0; i--) {
            if (countDiceByValue[i - 1] >= nbOfOccurence) {
                return i * nbOfOccurence;
            }
        }

        return MISSED_ROLL_SCORE;
    }
}




