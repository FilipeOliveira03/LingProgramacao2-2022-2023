package pt.ulusofona.lp2.deisiJungle;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        GameManager manager = new GameManager();
        String[][] array = {
                { "1", "Elefante","E" },
                { "2", "Leão","L" },
        };

        boolean resultadoReal = manager.createInitialJungle(8, 6, array);
    }
}
