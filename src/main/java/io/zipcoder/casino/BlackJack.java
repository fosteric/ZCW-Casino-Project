package io.zipcoder.casino;

public class BlackJack extends CardGame implements Gambling {

    Console aConsole = new Console();
    int wageAmount;
    int totalChips;
    Player aPlayer;

    int aPlayerScore = Game.playerScore;
    int aHouseScore = Game.houseScore;

    //assuming this to be a random card rank in int
    int aGetRank = Card.getRank();


    public int wageMoney() {
        return 0;
    }

    public boolean playGame() {
        return false;
    }


    //Player making the starting bet
    public int startingBet() {
        wageAmount = aConsole.getIntInput("Please make your starting bet:");
        if (wageAmount <= totalChips) {
            System.out.println("Your current bet amount is: " + wageAmount);
            return wageAmount;
        } else {
            System.out.println("Insufficient Chips!");
            //Recursion - this runs the method again and asks user to make the starting bet again
            return startingBet();
        }
    }

    //initial player card value
    public int startPlayerHand() {
        return aPlayerScore = aGetRank + aGetRank;
    }

    //initial house card value
    public int startHouseHand() {
        return aHouseScore = aGetRank + aGetRank;
    }


    public void blackJack(String[] args) {
        While(aPlayerScore <= 21


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


    }


