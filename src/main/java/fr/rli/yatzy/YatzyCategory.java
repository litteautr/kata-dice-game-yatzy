package fr.rli.yatzy;

import java.util.function.ToIntFunction;

public enum YatzyCategory {

    ONES(diceRoll -> diceRoll.sumMatchingDiceForDiceValue(1));

    private final ToIntFunction<DiceRoll> scoringRules;

    YatzyCategory(ToIntFunction<DiceRoll> scoringRules) {
        this.scoringRules = scoringRules;
    }

    public int score(DiceRoll diceRoll) {
        return scoringRules.applyAsInt(diceRoll);
    }
}
