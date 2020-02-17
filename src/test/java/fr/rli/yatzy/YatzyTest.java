package fr.rli.yatzy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @Test
    public void should_sum_all_dice_for_a_chance_roll() {
        DiceRoll rolledDice = new DiceRoll(2, 3, 4, 5, 1);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.chance();

        assertThat(score).isEqualTo(15);
    }

    @Test
    public void should_score_50_for_a_yatzy_roll() {
        assertEquals(50, Yatzy.yatzy(4, 4, 4, 4, 4));
    }

    @Test
    public void should_score_50_for_a_missed_yatzy_roll() {
        assertEquals(0, Yatzy.yatzy(6, 6, 6, 6, 3));
    }


    @Test
    public void should_sum_all_one_dice_for_a_ones_roll() {
        assertEquals(2, Yatzy.ones(1, 2, 1, 4, 5));
        assertEquals(0, Yatzy.ones(6, 2, 2, 4, 5));
    }

    @Test
    public void should_sum_all_two_dice_for_a_twos_roll() {
        assertEquals(4, Yatzy.twos(1, 2, 3, 2, 6));
    }

    @Test
    public void should_sum_all_three_dice_for_a_threes_roll() {
        assertEquals(6, Yatzy.threes(1, 2, 3, 2, 3));
    }

    @Test
    public void should_sum_all_four_dice_for_a_fours_roll() {
        assertEquals(12, new Yatzy(4, 4, 4, 5, 5).fours());
    }

    @Test
    public void should_sum_all_five_dice_for_a_five_roll() {
        assertEquals(10, new Yatzy(4, 4, 4, 5, 5).fives());
    }

    @Test
    public void should_sum_all_six_dice_for_a_sixes_roll() {
        assertEquals(6, new Yatzy(4, 4, 6, 5, 5).sixes());
    }

    @Test
    public void should_sum_the_two_matching_dice_for_a_pair_roll() {
        assertEquals(6, Yatzy.score_pair(3, 4, 3, 5, 6));
    }

    @Test
    public void should_score_0_for_a_missed_pair_roll() {
        assertEquals(0, Yatzy.score_pair(1, 3, 4, 6, 5));
    }

    @Test
    public void should_sum_the_four_matching_dice_for_a_two_pair_roll() {
        assertEquals(16, Yatzy.two_pair(3, 3, 5, 4, 5));
    }

    @Test
    public void should_score_0_for_a_missed_two_pair_roll() {
        assertEquals(0, Yatzy.two_pair(3, 1, 5, 5, 5));
    }

    @Test
    public void should_sum_the_three_matching_dice_for_a_three_of_a_kind_roll() {
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 4, 5));
    }

    @Test
    public void should_score_0_for_a_missed_three_of_a_kind_roll() {
        assertEquals(0, Yatzy.three_of_a_kind(1, 3, 4, 6, 5));
    }

    @Test
    public void should_sum_the_four_matching_dice_for_a_four_of_a_kind_roll() {
        assertEquals(12, Yatzy.four_of_a_kind(3, 3, 3, 3, 5));
    }

    @Test
    public void should_score_0_for_a_missed_four_of_a_kind_roll() {
        assertEquals(0, Yatzy.four_of_a_kind(1, 3, 4, 6, 5));
    }

    @Test
    public void should_score_15_for_a_small_straight_roll() {
        assertEquals(15, Yatzy.smallStraight(2, 3, 4, 5, 1));
    }

    @Test
    public void should_score_0_for_a_missed_small_straight_roll() {
        assertEquals(0, Yatzy.smallStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void should_score_20_for_a_large_straight_roll() {
        assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5));
    }

    @Test
    public void should_score_0_for_a_missed_large_straight_roll() {
        assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void should_sum_all_dice_for_a_full_house_roll() {
        assertEquals(18, Yatzy.fullHouse(6, 2, 2, 2, 6));
    }

    @Test
    public void should_score_0_for_a_missed_full_house_roll() {
        assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6));
    }
}
