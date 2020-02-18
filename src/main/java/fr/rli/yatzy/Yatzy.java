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
        for (int currentDiceValue = 6; currentDiceValue > 0; currentDiceValue--) {
            if (countDiceByValue[currentDiceValue - 1] >= 2) {
                numberOfPairFound++;
                score += currentDiceValue;
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

    public int fullHouse() {
        int[] countDiceByValue = diceRoll.countDiceByValue();

        boolean pairFound = false;
        boolean threeOfAKindFound = false;
        int pairMatchingDice = 0;
        int threeOfAKindMatchingDice = 0;
        int currentDiceValue;

        for (currentDiceValue = 6; currentDiceValue > 0; currentDiceValue--) {
            if (countDiceByValue[currentDiceValue - 1] == 2) {
                pairFound = true;
                pairMatchingDice = currentDiceValue;
            }
        }

        for (currentDiceValue = 6; currentDiceValue > 0; currentDiceValue--) {
            if (countDiceByValue[currentDiceValue - 1] == 3) {
                threeOfAKindFound = true;
                threeOfAKindMatchingDice = currentDiceValue;
            }
        }

        if (pairFound && threeOfAKindFound) {
            return pairMatchingDice * 2 + threeOfAKindMatchingDice * 3;
        } else {
            return MISSED_ROLL_SCORE;
        }
    }

    private Integer calculateScoreForMatchingDice(int nbOfOccurence) {
        int[] countDiceByValue = diceRoll.countDiceByValue();

        for (int currentDiceValue = 6; currentDiceValue > 0; currentDiceValue--) {
            if (countDiceByValue[currentDiceValue - 1] >= nbOfOccurence) {
                return currentDiceValue * nbOfOccurence;
            }
        }

        return MISSED_ROLL_SCORE;
    }
}




