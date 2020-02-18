package fr.rli.yatzy;

import java.util.function.ToIntFunction;

public enum YatzyCategory {

    ONES(diceRoll -> diceRoll.sumMatchingDiceForDiceValue(1)),
    TWOS(diceRoll -> diceRoll.sumMatchingDiceForDiceValue(2)),
    THREES(diceRoll -> diceRoll.sumMatchingDiceForDiceValue(3)),
    FOURS(diceRoll -> diceRoll.sumMatchingDiceForDiceValue(4)),
    FIVES(diceRoll -> diceRoll.sumMatchingDiceForDiceValue(5)),
    SIXES(diceRoll -> diceRoll.sumMatchingDiceForDiceValue(6)),
    PAIR(diceRoll -> calculateScoreForMatchingDice(diceRoll, 2)),
    TWO_PAIR(YatzyCategory::calculateScoreForTwoPair),
    THREE_OF_A_KIND(diceRoll -> calculateScoreForMatchingDice(diceRoll, 3)),
    FOUR_OF_A_KIND(diceRoll -> calculateScoreForMatchingDice(diceRoll, 4)),
    FULL_HOUSE(YatzyCategory::calculateScoreFullHouse),
    SMALL_STRAIGHT(diceRoll -> "12345".equals(diceRoll.toOrderedString()) ? 15 : 0),
    LARGE_STRAIGHT(diceRoll -> "23456".equals(diceRoll.toOrderedString()) ? 20 : 0),
    YATZY(diceRoll -> diceRoll.allDiceHaveSameNumber() ? 50 : 0),
    CHANCE(diceRoll -> diceRoll.getDiceValues().stream().reduce(0, Integer::sum));

    public static final int MISSED_ROLL_SCORE = 0;

    private final ToIntFunction<DiceRoll> scoringRule;

    YatzyCategory(ToIntFunction<DiceRoll> scoringRule) {
        this.scoringRule = scoringRule;
    }

    public int score(DiceRoll diceRoll) {
        return scoringRule.applyAsInt(diceRoll);
    }

    private static Integer calculateScoreForMatchingDice(DiceRoll diceRoll, int nbOfOccurence) {
        int[] countDiceByValue = diceRoll.countDiceByValue();

        for (int currentDiceValue = 6; currentDiceValue > 0; currentDiceValue--) {
            if (countDiceByValue[currentDiceValue - 1] >= nbOfOccurence) {
                return currentDiceValue * nbOfOccurence;
            }
        }

        return MISSED_ROLL_SCORE;
    }

    private static Integer calculateScoreForTwoPair(DiceRoll diceRoll) {
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


    public static int calculateScoreFullHouse(DiceRoll diceRoll) {
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
}
