package io.zipcoder.casino.Leviathan.Games.GameUtilities;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DrawSingleDie {

    public StringBuilder drawSingleDie(int x){
            DiceBuilder die1 = new DiceBuilder(x-1);

            List<Iterator<String>> dice = Arrays.asList(
                    die1.iterator());
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
            return sb;
        }
    }

