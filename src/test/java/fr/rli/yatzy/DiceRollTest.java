package fr.rli.yatzy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void should_return_sum_of_matching_dice_for_a_dice_value() {
        DiceRoll diceRoll = new DiceRoll(1, 4, 1, 3, 1);

        int sum = diceRoll.sumMatchingDiceForDiceValue(1);

        assertThat(sum).isEqualTo(3);
    }

    @Test
    public void should_return_an_array_counting_number_of_dice_by_value() {
        DiceRoll diceRoll = new DiceRoll(1, 4, 2, 3, 1);

        int[] countDiceByValue = diceRoll.countDiceByValue();

        assertArrayEquals(new int[]{2, 1, 1, 1, 0, 0}, countDiceByValue);
    }

    @Test
    public void should_convert_dice_roll_to_an_ordered_string() {
        DiceRoll diceRoll = new DiceRoll(1, 4, 2, 3, 1);

        String diceRollAsString = diceRoll.toOrderedString();

        assertThat(diceRollAsString).isEqualTo("11234");
    }


}
