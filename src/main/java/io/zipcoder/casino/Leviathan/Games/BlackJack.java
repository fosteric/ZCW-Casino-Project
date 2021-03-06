package io.zipcoder.casino.Leviathan.Games;

import io.zipcoder.casino.Leviathan.Interfaces.*;
import io.zipcoder.casino.Leviathan.*;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.*;

import java.util.ArrayList;
import java.util.List;

public class BlackJack extends CardGame implements Gambling {

    Console aConsole = new Console();
    int wageAmount;
    int totalChips;
    Player aPlayer;
    boolean playAgain = true;

    public BlackJack(Player aPlayer) {
        this.aPlayer = aPlayer;
    }

    int aPlayerScore = Game.playerScore;
    int aHouseScore = Game.houseScore;

    Deck deck = new Deck();

    String playerDecision;

    boolean win;

////////////////////////////////////////////////////////////////////////////////////

    //draws the initial two cards
    public List<Card> drawNewHand() {
        List<Card> hand = new ArrayList<>();
        hand.add(deck.draw());
        hand.add(deck.draw());
        return hand;
    }

    //get the sum int value of the drawn cards
    public int getHandTotal(List<Card> hand) {
        int sum = 0;
        int countAces = 0;

        for (Card c : hand) {
            Rank rank = c.getRank();
            int value = rank.getValue();

            if (value <= 10) {
                sum += value;
            }
            if (rank.equals(Rank.JACK) || rank.equals(Rank.QUEEN) || rank.equals(Rank.KING)) {
                sum += 10;
            }
            if (rank.equals(Rank.ACE)) {
                sum += 0;
            }
            if (rank.equals(Rank.ACE)) {
                countAces += 1;
            }
        }
        if (countAces == 0) {
            return sum;
        }
        if ((sum + 11 + (countAces - 1)) <= 21) {
            return sum + 11 + (countAces - 1);
        } else {
            return sum + countAces;
        }
    }

    //lets the player know of the starting hand
    public String handToString(List<Card> hand) {
        StringBuilder builder = new StringBuilder();
        for (Card c : hand) {
            String cardString = (c.getRank() + " of " + c.getSuit());
            builder.append(cardString).append("\n");
        }
        return builder.toString();
    }

    //lets the player know one of house's starting hand
    public String houseHandToString(List<Card> hand, int cardsToShow) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cardsToShow; i++) {
            builder.append(hand.get(i).getRank() + " of " + hand.get(i).getSuit() + "\n");
        }
        return builder.toString();
    }


    //draws a singe card
    public Card drawSingleCard() {

        return deck.draw();
    }

    //Gets the int value of a single drawn card
    public int getSingleCardValue(List<Card> hand) {
        int cardValue = 0;

        for (Card c : hand) {
            Rank rank = c.getRank();
            int value = rank.getValue();
            cardValue += value;
        }
        return cardValue;
    }

    public String drawnCardToString(Card card) {
        return card.getRank() + " of " + card.getSuit();
    }

////////////////////////////////////////////////////////////////////////////////////

    public void playGame() {

        while (playAgain == true) {

            aConsole.println("*** Welcome " + this.aPlayer.getName() +
                    ", let’s play BlackJack! ***\n");

            int wageAmount = wageMoney();

            //draw a fresh hand
            List<Card> playerHand = drawNewHand();

            //get the player's hand total
            int handTotal = getHandTotal(playerHand);

            //update player score with hand total
            aPlayerScore = handTotal;

            //show the player their hand
            String handString = handToString(playerHand);
            aConsole.println("\n You have drawn: \n" + handString);

            //display hand total
            aConsole.println("Your current hand value: " + aPlayerScore + "\n");

            //draw a fresh hand for house
            List<Card> houseHand = drawNewHand();

            //get the house hand total
            int houseHandTotal = getHandTotal(houseHand);

            //update house score with hand total
            aHouseScore = houseHandTotal;

            //show the player one of house's card
            //I need to figure out how I could only show one card
            String houseHandString = houseHandToString(houseHand, 1);
            aConsole.println("\n The house has drawn: \n" + houseHandString +
                    "And has one card faced down");

            //Decision
            while (aPlayerScore < 21) {
                //playerDecision = aConsole.getStringInput("Please make a call:\nHit\nStand\nRaise Bet");
                playerDecision = aConsole.getStringInput("Please make a call:\nHit\nStand");

                //Hit
                if (playerDecision.equalsIgnoreCase("Hit")) {
                    playerHit(playerHand);
                }
                if (playerDecision.equalsIgnoreCase("Stand")) {

                    //House start drawing cards
                    houseDraws(houseHand);
                    break;
                }
            }

            //House winning situation
            if (aPlayerScore > 21) {
                aConsole.println("Bust!");
                win = false;
                betChages(bet);
                aConsole.println("Your current available chips: \n" + aPlayer.getTotalChips());
            }else if ((aHouseScore >= aPlayerScore && aHouseScore < 21) || aHouseScore == 21) {
                aConsole.println("You lose\n" + "Your score: " + aPlayerScore +
                        "\nHouse score: " + aHouseScore);
                aConsole.println("\n Dealer's hand: \n" + handToString(houseHand));
                win = false;
                betChages(bet);
                aConsole.println("Your current available chips: \n" + aPlayer.getTotalChips());
            }

            //Player winning situation
            else if (aHouseScore < 21) {
                aConsole.println("You win!");
                win = true;
                betChages(bet);
                aConsole.println("Your current available chips: \n" + aPlayer.getTotalChips());
            } else {
                //aConsole.println("You win!");
                aConsole.println("You win!\n" + "Your score: " + aPlayerScore +
                        "\nHouse score: " + aHouseScore);
                win = true;
                betChages(bet);
                aConsole.println("Your current available chips: \n" + aPlayer.getTotalChips());
            }
            if ((aPlayer.getTotalChips() == 0) || aConsole.yesOrNo("Would you like to play again?").equalsIgnoreCase("no")) {
                playAgain = false;
            }
        }
    }

    private void playerHit(List<Card> playerHand) {
        //draw a new card
        Card drawSingleCard = drawSingleCard();
        playerHand.add(drawSingleCard);

        //update player score with card value
        aPlayerScore = getHandTotal(playerHand);

        //show the newly drawn card
        String newCardString = drawnCardToString(drawSingleCard);
        aConsole.println("\n You have drawn: \n" + newCardString);

        //display updated hand total
        aConsole.println("Your current hand value: " + aPlayerScore + "\n");
    }

    private void houseDraws(List<Card> houseHand) {
        while (aPlayerScore > aHouseScore && aHouseScore < 21) {
            //draw a new card
            Card drawSingleCard = drawSingleCard();
            houseHand.add(drawSingleCard);

            //update house score with card value
            aHouseScore = getHandTotal(houseHand);

            //show the newly drawn card
            String newCardString = drawnCardToString(drawSingleCard);
            aConsole.println("\n House have drawn: \n" + newCardString);
        }
    }

    int bet;
    public int wageMoney() {
        //int bet;
        totalChips = aPlayer.getTotalChips();
        bet = aConsole.getIntInput("Please make your starting bet:\n" +
                "You currently have: " + aPlayer.getTotalChips() + " chips.");
        if (bet > 0 && bet <= totalChips) {
            aConsole.println("Your current bet amount is: " + bet);
            return bet;
        } else if (bet == 0 || bet < 0) {
            aConsole.println("You need to bet at least 1 chip");
            return wageMoney();
        } if(bet > totalChips) {
            aConsole.println("Insufficient Chips!");

            //return wageMoney();
            return wageMoney();
        }
        return bet;
    }

    public void betChages(int wageAmount){
        totalChips = aPlayer.getTotalChips();
        if(win == true){
            aPlayer.setTotalChips(totalChips + wageAmount);
        } else{
            aPlayer.setTotalChips(totalChips - wageAmount);
        }
    }
}





