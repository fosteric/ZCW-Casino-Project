package io.zipcoder.casino.Leviathan.Games.GameUtilities;

import java.util.ArrayList;
import java.util.Collections;


public class Deck {

    public void shuffle() {
        Collections.shuffle(deck);

    }

    private ArrayList deck;

    public Deck() {
        this.deck = new ArrayList();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                deck.add(new Card(rank, suit));
            }
        }

        shuffle();
    }

    public Deck draw() {
        return (Deck) deck.remove(deck.size() - 1);
    }







//    public Card drawCard() {
//
//        String yourCard = Card.(rank) + " of " + Card.getSuit();
//
//        return yourCard;
//        return null;
//    }

}

