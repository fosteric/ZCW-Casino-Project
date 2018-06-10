package io.zipcoder.casino.Leviathan.Games.GameUtilities;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DiceBuilder implements Iterable<String> {
private static final String[][] lines = {
        {
        "+-------+",
        "|       |",
        "|   o   |",
        "|       |",
        "+-------+",
        },
        {
        "+-------+",
        "| o     |",
        "|       |",
        "|     o |",
        "+-------+",
        },
        {
        "+-------+",
        "| o     |",
        "|   o   |",
        "|     o |",
        "+-------+",
        },
        {
        "+-------+",
        "| o   o |",
        "|       |",
        "| o   o |",
        "+-------+",
        },
        {
        "+-------+",
        "| o   o |",
        "|   o   |",
        "| o   o |",
        "+-------+",
        },
        {
        "+-------+",
        "| o   o |",
        "| o   o |",
        "| o   o |",
        "+-------+",
        }
        };

private int value;

public DiceBuilder(int value) {
        if (value < 0 || value >= 7) {
        throw new IllegalArgumentException("Illegal die value");
        }
        this.value = value;
        }

public Iterator<String> iterator() {
        return Arrays.asList(lines[value]).iterator();
        }
        }

