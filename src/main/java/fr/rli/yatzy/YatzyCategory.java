package fr.rli.yatzy;

import java.util.function.ToIntFunction;

import static fr.rli.yatzy.DiceRoll.MAXIMUM_DICE_VALUE;
import static fr.rli.yatzy.Yatzy.*;

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
    SMALL_STRAIGHT(diceRoll -> SMALL_STRAIGHT_VALUE.equals(diceRoll.toOrderedString()) ? SMALL_STRAIGHT_SCORE : MISSED_ROLL_SCORE),
    LARGE_STRAIGHT(diceRoll -> LARGE_STRAIGHT_VALUE.equals(diceRoll.toOrderedString()) ? LARGE_STRAIGHT_SCORE : MISSED_ROLL_SCORE),
    YATZY(diceRoll -> diceRoll.allDiceHaveSameNumber() ? YATZY_SCORE : MISSED_ROLL_SCORE),
    CHANCE(diceRoll -> diceRoll.sumAllDice());

    private final ToIntFunction<DiceRoll> scoringRule;

    YatzyCategory(ToIntFunction<DiceRoll> scoringRule) {
        this.scoringRule = scoringRule;
    }

    public int score(DiceRoll diceRoll) {
        return scoringRule.applyAsInt(diceRoll);
    }

    private static int calculateScoreForMatchingDice(DiceRoll diceRoll, int nbOfOccurence) {
        int[] countDiceByValue = diceRoll.countDiceByValue();

        for (int currentDiceValue = MAXIMUM_DICE_VALUE; currentDiceValue > 0; currentDiceValue--) {
            if (countDiceByValue[currentDiceValue - 1] >= nbOfOccurence) {
                return currentDiceValue * nbOfOccurence;
            }
        }

        return MISSED_ROLL_SCORE;
    }

    private static int calculateScoreForTwoPair(DiceRoll diceRoll) {
        int[] countDiceByValue = diceRoll.countDiceByValue();

        int numberOfPairFound = 0;
        int score = 0;
        for (int currentDiceValue = MAXIMUM_DICE_VALUE; currentDiceValue > 0; currentDiceValue--) {
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

        for (currentDiceValue = MAXIMUM_DICE_VALUE; currentDiceValue > 0; currentDiceValue--) {
            if (countDiceByValue[currentDiceValue - 1] == 2) {
                pairFound = true;
                pairMatchingDice = currentDiceValue;
            }
        }

        for (currentDiceValue = MAXIMUM_DICE_VALUE; currentDiceValue > 0; currentDiceValue--) {
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
