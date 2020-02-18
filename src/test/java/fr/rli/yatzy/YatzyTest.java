package fr.rli.yatzy;

import org.junit.jupiter.api.Test;

import static fr.rli.yatzy.YatzyCategory.*;
import static org.assertj.core.api.Assertions.assertThat;

public class YatzyTest {

    @Test
    public void should_sum_all_dice_for_a_chance_roll() {
        DiceRoll rolledDice = new DiceRoll(2, 3, 4, 5, 1);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(CHANCE);

        assertThat(score).isEqualTo(15);
    }

    @Test
    public void should_score_50_for_a_yatzy_roll() {
        DiceRoll rolledDice = new DiceRoll(4, 4, 4, 4, 4);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(YATZY);

        assertThat(score).isEqualTo(50);
    }

    @Test
    public void should_score_0_for_a_missed_yatzy_roll() {
        DiceRoll rolledDice = new DiceRoll(4, 4, 4, 4, 1);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(YATZY);

        assertThat(score).isEqualTo(0);
    }


    @Test
    public void should_sum_all_one_dice_for_a_ones_roll() {
        DiceRoll rolledDice = new DiceRoll(1, 2, 1, 4, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(ONES);

        assertThat(score).isEqualTo(2);
    }

    @Test
    public void should_score_0_for_a_missed_ones_roll() {
        DiceRoll rolledDice = new DiceRoll(6, 2, 2, 4, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(ONES);

        assertThat(score).isEqualTo(0);
    }

    @Test
    public void should_sum_all_two_dice_for_a_twos_roll() {
        DiceRoll rolledDice = new DiceRoll(1, 2, 3, 2, 6);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(TWOS);

        assertThat(score).isEqualTo(4);
    }

    @Test
    public void should_sum_all_three_dice_for_a_threes_roll() {
        DiceRoll rolledDice = new DiceRoll(1, 2, 3, 2, 3);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(THREES);

        assertThat(score).isEqualTo(6);
    }

    @Test
    public void should_sum_all_four_dice_for_a_fours_roll() {
        DiceRoll rolledDice = new DiceRoll(4, 4, 4, 5, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(FOURS);

        assertThat(score).isEqualTo(12);
    }

    @Test
    public void should_sum_all_five_dice_for_a_five_roll() {
        DiceRoll rolledDice = new DiceRoll(4, 4, 4, 5, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(FIVES);

        assertThat(score).isEqualTo(10);
    }

    @Test
    public void should_sum_all_six_dice_for_a_sixes_roll() {
        DiceRoll rolledDice = new DiceRoll(4, 4, 6, 5, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(SIXES);

        assertThat(score).isEqualTo(6);
    }

    @Test
    public void should_sum_the_two_matching_dice_for_a_pair_roll() {
        DiceRoll rolledDice = new DiceRoll(3, 4, 3, 5, 6);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(PAIR);

        assertThat(score).isEqualTo(6);
    }

    @Test
    public void should_score_0_for_a_missed_pair_roll() {
        DiceRoll rolledDice = new DiceRoll(1, 3, 4, 6, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(PAIR);

        assertThat(score).isEqualTo(0);
    }

    @Test
    public void should_sum_highest_dice_value_for_a_pair_roll() {
        DiceRoll rolledDice = new DiceRoll(5, 3, 6, 6, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(PAIR);

        assertThat(score).isEqualTo(12);
    }

    @Test
    public void should_sum_the_four_matching_dice_for_a_two_pair_roll() {
        DiceRoll rolledDice = new DiceRoll(3, 3, 5, 4, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(TWO_PAIR);

        assertThat(score).isEqualTo(16);
    }

    @Test
    public void should_score_0_for_a_missed_two_pair_roll() {
        DiceRoll rolledDice = new DiceRoll(3, 1, 5, 5, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(TWO_PAIR);

        assertThat(score).isEqualTo(0);
    }

    @Test
    public void should_sum_the_three_matching_dice_for_a_three_of_a_kind_roll() {
        DiceRoll rolledDice = new DiceRoll(3, 3, 3, 4, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(THREE_OF_A_KIND);

        assertThat(score).isEqualTo(9);
    }

    @Test
    public void should_score_0_for_a_missed_three_of_a_kind_roll() {
        DiceRoll rolledDice = new DiceRoll(1, 3, 4, 6, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(THREE_OF_A_KIND);

        assertThat(score).isEqualTo(0);
    }

    @Test
    public void should_sum_the_four_matching_dice_for_a_four_of_a_kind_roll() {
        DiceRoll rolledDice = new DiceRoll(3, 3, 3, 3, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(FOUR_OF_A_KIND);

        assertThat(score).isEqualTo(12);
    }

    @Test
    public void should_score_0_for_a_missed_four_of_a_kind_roll() {
        DiceRoll rolledDice = new DiceRoll(1, 3, 4, 6, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(FOUR_OF_A_KIND);

        assertThat(score).isEqualTo(0);
    }

    @Test
    public void should_score_15_for_a_small_straight_roll() {
        DiceRoll rolledDice = new DiceRoll(2, 3, 4, 5, 1);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(SMALL_STRAIGHT);

        assertThat(score).isEqualTo(15);
    }

    @Test
    public void should_score_0_for_a_missed_small_straight_roll() {
        DiceRoll rolledDice = new DiceRoll(1, 2, 2, 4, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(SMALL_STRAIGHT);

        assertThat(score).isEqualTo(0);
    }

    @Test
    public void should_score_20_for_a_large_straight_roll() {
        DiceRoll rolledDice = new DiceRoll(6, 2, 3, 4, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(LARGE_STRAIGHT);

        assertThat(score).isEqualTo(20);
    }

    @Test
    public void should_score_0_for_a_missed_large_straight_roll() {
        DiceRoll rolledDice = new DiceRoll(1, 2, 2, 4, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(LARGE_STRAIGHT);

        assertThat(score).isEqualTo(0);
    }

    @Test
    public void should_sum_all_dice_for_a_full_house_roll() {
        DiceRoll rolledDice = new DiceRoll(6, 2, 2, 2, 6);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(FULL_HOUSE);

        assertThat(score).isEqualTo(18);
    }

    @Test
    public void should_score_0_for_a_missed_full_house_roll() {
        DiceRoll rolledDice = new DiceRoll(2, 3, 4, 5, 6);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.score(FULL_HOUSE);

        assertThat(score).isEqualTo(0);
    }
}
