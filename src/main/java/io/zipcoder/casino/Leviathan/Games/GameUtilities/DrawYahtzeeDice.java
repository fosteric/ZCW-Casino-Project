package io.zipcoder.casino.Leviathan.Games.GameUtilities;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DrawYahtzeeDice {

    public StringBuilder drawYahtzeeDice(int... ints) {
        DiceBuilder die1 = new DiceBuilder(ints[0] - 1);
        DiceBuilder die2 = new DiceBuilder(ints[1] - 1);
        DiceBuilder die3 = new DiceBuilder(ints[2] - 1);
        DiceBuilder die4 = new DiceBuilder(ints[3] - 1);
        DiceBuilder die5 = new DiceBuilder(ints[4] - 1);

        List<Iterator<String>> dice = Arrays.asList(
                die1.iterator(),
                die2.iterator(),
                die3.iterator(),
                die4.iterator(),
                die5.iterator());
        StringBuilder sb = new StringBuilder();

        outer:
        while (true) {
            for (Iterator<String> iter : dice) {
                if (!iter.hasNext()) {
                    break outer;
                }
            }

            for (Iterator<String> iter : dice) {
                sb.append(iter.next()).append("   ");
            }
            sb.append("\r\n");
        }

        return (sb);
    }
}
