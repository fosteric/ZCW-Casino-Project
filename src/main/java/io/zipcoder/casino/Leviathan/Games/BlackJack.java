package io.zipcoder.casino.Leviathan.Games;
import io.zipcoder.casino.Leviathan.Interfaces.*;
import io.zipcoder.casino.Leviathan.*;
import  io.zipcoder.casino.Leviathan.Games.GameUtilities.*;

public class BlackJack extends CardGame implements Gambling {

    Console aConsole = new Console();
    int wageAmount;
    int totalChips;
    Player aPlayer;

    public BlackJack(Player aPlayer){
        this.aPlayer = aPlayer;
    }

    int aPlayerScore = Game.playerScore;
    int aHouseScore = Game.houseScore;

    //assuming this to be a random card rank in int
    //Card aCard = new Card(Rank.ACE,Suit.CLUBS);
    //Rank aGetRank = aCard.getRank();

    Deck deck = new Deck();


    String playerDecision;


    public boolean playGame() {
        return false;
    }



    //Player making the starting bet
    public int wageMoney() {

        totalChips=aPlayer.getTotalChips();

        wageAmount = aConsole.getIntInput("Please make your starting bet:");
        if (wageAmount <= totalChips) {
            aConsole.println("Your current bet amount is: " + wageAmount);
            return wageAmount;
        } else {
            aConsole.println("Insufficient Chips!");
            //Recursion - this runs the method again and asks user to make the starting bet again
            return wageMoney();
        }
    }

    //initial player card value
    public int startPlayerHand() {
        return aPlayerScore = deck(Card()); //= aGetRank + aGetRank;
    }

    //initial house card value
    public int startHouseHand() {
        return aHouseScore; //= aGetRank + aGetRank;
    }


    //ask for player's next move
    public String blackJack(String playerDecision) {
        if(startPlayerHand() < 21){
            playerDecision = aConsole.getStringInput("Please make a call:\nHit\nStand\nRaise Bet");
        }
        return playerDecision;
    }



    //Hit
    public int hit(int playerHand) {


        return 0;
    }


    //Stand
    public int stand(int playerHand) {


        return 0;
    }

    //Raise bet
    public int raiseBet(int wageAmount) {


        return 0;
    }







}


//    public boolean playGame(Player aPlayer) {
//        return false;
//    }
//
//
//    public int wageMoney() {
//        return 0;
//    }
//
//
//
//    private static final String HOLD_CONSTANT = "hold";
//
//
//    public void blackJack (String[] args){
//
//        //user input for Int
//        int betAmount = 0;
//
//        //user input for String
//        String decision;
//
//
//
//
//
//
//        int aPlayerScore = Game.playerScore;
//
//        int aHouseScore = Game.houseScore;
//
//
//
//
//        //How do I make this work??
//        //Card aCard = new Card();
//        //or
//        //int aCard = Card.getRank;
//
//
//        ////////public int startTheGame(int playerScore, int houseScore, int getRank)
//
//        //playerScore = Card.getRank() + Card.getRank();
//
//        //houseScore = Card.getRank() + Card.getRank();
//
//
//
//
//
//        while(!HOLD_CONSTANT.equals(decision) || playerScore < 21) {
//
//            //IF statement that asks for userInput after each loop(?)
//            //add sum values of two cards to playerScore hand
//            //add sum values of two cards to houseScore hand
//
//           decision = aConsole.getStringInput("Please make a call:\nHit\nStand");
//
//
//            If(decision.equals("Hit")) {
//
//                If(decision.equals("Ace") && playerScore > 10) {
//                    playerScore + 1;
//                }
//                else{
//                    playerScore + 11;
//                }
//            }
//            else if(aConsole.getStringInput().equals("Stand"))
//
//
//
//    }
//
//    If(playerScore > 21){
//
//        }
//
//
//    }




