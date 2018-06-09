package io.zipcoder.casino.Leviathan.Games.GameUtilities;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DrawYahtzeeDice {

    public StringBuilder drawYahtzeeDice(int x, int y, int z, int a, int b){
        DiceBuilder die1 = new DiceBuilder(x-1);
        DiceBuilder die2 = new DiceBuilder(y-1);
        DiceBuilder die3 = new DiceBuilder(z-1);
        DiceBuilder die4 = new DiceBuilder(a-1);
        DiceBuilder die5 = new DiceBuilder(b-1);

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

        return(sb);
    }
}
