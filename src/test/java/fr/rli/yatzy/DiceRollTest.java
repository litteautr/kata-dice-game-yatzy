package fr.rli.yatzy;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiceRollTest {

    @Test
    public void should_create_a_list_of_five_dice_value_when_creating_dice_roll() {
        DiceRoll diceRoll = new DiceRoll(1, 2, 3, 4, 5);

        assertThat(diceRoll).isNotNull();
        assertThat(diceRoll.getDiceValues()).contains(1, 2, 3, 4, 5);
    }

    @Test
    public void should_throw_an_illegalArgumentException_when_creating_dice_roll_with_wrong_value() {
        assertThrows(IllegalArgumentException.class, () -> new DiceRoll(0, 2, 3, 4, 5));
    }

    @Test
    public void should_return_true_when_all_dice_have_same_value() {
        DiceRoll diceRoll = new DiceRoll(1, 1, 1, 1, 1);

        assertTrue(diceRoll.allDiceHaveSameNumber());
    }
}
