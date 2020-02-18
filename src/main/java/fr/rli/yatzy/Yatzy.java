package fr.rli.yatzy;

public class Yatzy {

    private DiceRoll diceRoll;

    public Yatzy(DiceRoll diceRoll) {
        this.diceRoll = diceRoll;
    }

    public int score(YatzyCategory category) {
        return category.score(diceRoll);
    }
}




