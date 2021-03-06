package io.zipcoder.casino.Leviathan.Games.GameUtilities;

import java.util.ArrayList;
import java.util.Collections;


public class Deck {

    private ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                deck.add(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        this.deck = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                deck.add(new Card(rank, suit));
            }
        }
        Collections.shuffle(deck);
    }

    public Card draw() {
        return deck.remove(deck.size() - 1);
    }

    public int size() {
        return deck.size();
    }
}

