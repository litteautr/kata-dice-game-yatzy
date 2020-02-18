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
        DiceRoll rolledDice = new DiceRoll(4, 4, 4, 4, 4);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.yatzy();

        assertThat(score).isEqualTo(50);
    }

    @Test
    public void should_score_0_for_a_missed_yatzy_roll() {
        DiceRoll rolledDice = new DiceRoll(4, 4, 4, 4, 1);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.yatzy();

        assertThat(score).isEqualTo(0);
    }


    @Test
    public void should_sum_all_one_dice_for_a_ones_roll() {
        DiceRoll rolledDice = new DiceRoll(1, 2, 1, 4, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.ones();

        assertThat(score).isEqualTo(2);
    }

    @Test
    public void should_score_0_for_a_missed_ones_roll() {
        DiceRoll rolledDice = new DiceRoll(6, 2, 2, 4, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.ones();

        assertThat(score).isEqualTo(0);
    }

    @Test
    public void should_sum_all_two_dice_for_a_twos_roll() {
        DiceRoll rolledDice = new DiceRoll(1, 2, 3, 2, 6);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.twos();

        assertThat(score).isEqualTo(4);
    }

    @Test
    public void should_sum_all_three_dice_for_a_threes_roll() {
        DiceRoll rolledDice = new DiceRoll(1, 2, 3, 2, 3);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.threes();

        assertThat(score).isEqualTo(6);
    }

    @Test
    public void should_sum_all_four_dice_for_a_fours_roll() {
        DiceRoll rolledDice = new DiceRoll(4, 4, 4, 5, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.fours();

        assertThat(score).isEqualTo(12);
    }

    @Test
    public void should_sum_all_five_dice_for_a_five_roll() {
        DiceRoll rolledDice = new DiceRoll(4, 4, 4, 5, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.fives();

        assertThat(score).isEqualTo(10);
    }

    @Test
    public void should_sum_all_six_dice_for_a_sixes_roll() {
        DiceRoll rolledDice = new DiceRoll(4, 4, 6, 5, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.sixes();

        assertThat(score).isEqualTo(6);
    }

    @Test
    public void should_sum_the_two_matching_dice_for_a_pair_roll() {
        DiceRoll rolledDice = new DiceRoll(3, 4, 3, 5, 6);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.pair();

        assertThat(score).isEqualTo(6);
    }

    @Test
    public void should_score_0_for_a_missed_pair_roll() {
        DiceRoll rolledDice = new DiceRoll(1, 3, 4, 6, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.pair();

        assertThat(score).isEqualTo(0);
    }

    @Test
    public void should_sum_the_four_matching_dice_for_a_two_pair_roll() {
        DiceRoll rolledDice = new DiceRoll(3, 3, 5, 4, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.twoPair();

        assertThat(score).isEqualTo(16);
    }

    @Test
    public void should_score_0_for_a_missed_two_pair_roll() {
        DiceRoll rolledDice = new DiceRoll(3, 1, 5, 5, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.twoPair();

        assertThat(score).isEqualTo(0);
    }

    @Test
    public void should_sum_the_three_matching_dice_for_a_three_of_a_kind_roll() {
        DiceRoll rolledDice = new DiceRoll(3, 3, 3, 4, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.threeOfAKind();

        assertThat(score).isEqualTo(9);
    }

    @Test
    public void should_score_0_for_a_missed_three_of_a_kind_roll() {
        DiceRoll rolledDice = new DiceRoll(1, 3, 4, 6, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.threeOfAKind();

        assertThat(score).isEqualTo(0);
    }

    @Test
    public void should_sum_the_four_matching_dice_for_a_four_of_a_kind_roll() {
        DiceRoll rolledDice = new DiceRoll(3, 3, 3, 3, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.fourOfAKind();

        assertThat(score).isEqualTo(12);
    }

    @Test
    public void should_score_0_for_a_missed_four_of_a_kind_roll() {
        DiceRoll rolledDice = new DiceRoll(1, 3, 4, 6, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.fourOfAKind();

        assertThat(score).isEqualTo(0);
    }

    @Test
    public void should_score_15_for_a_small_straight_roll() {
        DiceRoll rolledDice = new DiceRoll(2, 3, 4, 5, 1);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.smallStraight();

        assertThat(score).isEqualTo(15);
    }

    @Test
    public void should_score_0_for_a_missed_small_straight_roll() {
        DiceRoll rolledDice = new DiceRoll(1, 2, 2, 4, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.smallStraight();

        assertThat(score).isEqualTo(0);
    }

    @Test
    public void should_score_20_for_a_large_straight_roll() {
        DiceRoll rolledDice = new DiceRoll(6, 2, 3, 4, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.largeStraight();

        assertThat(score).isEqualTo(20);
    }

    @Test
    public void should_score_0_for_a_missed_large_straight_roll() {
        DiceRoll rolledDice = new DiceRoll(1, 2, 2, 4, 5);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.largeStraight();

        assertThat(score).isEqualTo(0);
    }

    @Test
    public void should_sum_all_dice_for_a_full_house_roll() {
        DiceRoll rolledDice = new DiceRoll(6, 2, 2, 2, 6);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.fullHouse();

        assertThat(score).isEqualTo(18);
    }

    @Test
    public void should_score_0_for_a_missed_full_house_roll() {
        DiceRoll rolledDice = new DiceRoll(2, 3, 4, 5, 6);
        Yatzy yatzy = new Yatzy(rolledDice);

        int score = yatzy.fullHouse();

        assertThat(score).isEqualTo(0);
    }
}
