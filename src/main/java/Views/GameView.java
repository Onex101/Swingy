package Views;

import Models.Game;
import Models.Mobs.Monster;

public interface GameView {
    void display(Game game);

    void displayEncounter();

    void displayMonster(Monster monster);

    void displayFightLost();

    void displayFightWon(Monster monster);

    void displayRunSuccess();

    void displayRunFailed();

    void switchDisplay();

    void displayWin();
}
