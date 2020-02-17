package fr.rli.yatzy;

import java.util.Collection;
import java.util.List;

import static java.text.MessageFormat.format;

public class DiceRoll {

    public static final int MINIMUM_DICE_VALUE = 1;
    public static final int MAXIMUM_DICE_VALUE = 6;

    private List<Integer> diceValues;

    public DiceRoll(int diceValue1, int diceValue2, int diceValue3, int diceValue4, int diceValue5) {
        diceValues = List.of(diceValue1, diceValue2, diceValue3, diceValue4, diceValue5);
        if (diceValues.stream().anyMatch(diceValue -> diceValue < MINIMUM_DICE_VALUE || diceValue > MAXIMUM_DICE_VALUE)) {
            throw new IllegalArgumentException(
                    format("Dice value must be between {0} and {1}.",
                            MINIMUM_DICE_VALUE, MAXIMUM_DICE_VALUE));
        }
    }

    public Collection<Integer> getDiceValues() {
        return diceValues;
    }
}
