package io.zipcoder.casino.Leviathan.Games.GameUtilities;

import java.util.*;

public class Deck {

    private ArrayList deck;

    public Deck() {
        this.deck = new ArrayList();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                deck.add(new Card(rank, suit));
            }
        }

        Collections.shuffle(deck);
    }

//    public void lookThroughDeck() {
//
//        Iterator cardIterator = deck.iterator();
//        while (cardIterator.hasNext()) {
//            Card card = (Card) cardIterator.next();
//            System.out.println(card.getRank() + " of " + card.getSuit());
//        }
//
//    }


    public Card drawCard() {

//        String yourCard = Card.getRank() + " of " + Card.getSuit();

//        return yourCard;
        return null;
    }

}

