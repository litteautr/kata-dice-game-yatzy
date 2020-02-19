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
    PAIR(diceRoll -> calculateScoreForMatchingDice(diceRoll, 2, 1)),
    TWO_PAIR(diceRoll -> calculateScoreForMatchingDice(diceRoll, 2, 2)),
    THREE_OF_A_KIND(diceRoll -> calculateScoreForMatchingDice(diceRoll, 3, 1)),
    FOUR_OF_A_KIND(diceRoll -> calculateScoreForMatchingDice(diceRoll, 4, 1)),
    FULL_HOUSE(YatzyCategory::calculateScoreFullHouse),
    SMALL_STRAIGHT(diceRoll -> SMALL_STRAIGHT_VALUE.equals(diceRoll.toOrderedString()) ? SMALL_STRAIGHT_SCORE : MISSED_ROLL_SCORE),
    LARGE_STRAIGHT(diceRoll -> LARGE_STRAIGHT_VALUE.equals(diceRoll.toOrderedString()) ? LARGE_STRAIGHT_SCORE : MISSED_ROLL_SCORE),
    YATZY(diceRoll -> diceRoll.allDiceHaveSameNumber() ? YATZY_SCORE : MISSED_ROLL_SCORE),
    CHANCE(DiceRoll::sumAllDice);

    private final ToIntFunction<DiceRoll> scoringRule;

    YatzyCategory(ToIntFunction<DiceRoll> scoringRule) {
        this.scoringRule = scoringRule;
    }

    public int score(DiceRoll diceRoll) {
        return scoringRule.applyAsInt(diceRoll);
    }

    private static int calculateScoreForMatchingDice(DiceRoll diceRoll, int nbOfMatchingDice, int nbOfMatchingFigure) {
        int[] countDiceByValue = diceRoll.countDiceByValue();

        int numberOfFoundFigure = 0;
        int score = 0;
        for (int currentDiceValue = MAXIMUM_DICE_VALUE; currentDiceValue > 0; currentDiceValue--) {
            if (countDiceByValue[currentDiceValue - 1] >= nbOfMatchingDice) {
                numberOfFoundFigure++;
                score += currentDiceValue * nbOfMatchingDice;
                if (numberOfFoundFigure == nbOfMatchingFigure) {
                    break;
                }
            }
        }

        return numberOfFoundFigure == nbOfMatchingFigure ? score : MISSED_ROLL_SCORE;
    }

    public static int calculateScoreFullHouse(DiceRoll diceRoll) {
        int[] countDiceByValue = diceRoll.countDiceByValue();

        boolean pairFound = false;
        boolean threeOfAKindFound = false;
        int score = 0;

        for (int currentDiceValue = MAXIMUM_DICE_VALUE; currentDiceValue > 0; currentDiceValue--) {
            if (countDiceByValue[currentDiceValue - 1] == 2) {
                pairFound = true;
                score += currentDiceValue * 2;
            } else if (countDiceByValue[currentDiceValue - 1] == 3) {
                threeOfAKindFound = true;
                score += currentDiceValue * 3;
            }
        }

        return pairFound && threeOfAKindFound ? score : MISSED_ROLL_SCORE;
    }
}