package io.zipcoder.casino;

public class BlackJack extends CardGame implements Gambling{


    public boolean playGame(Player aPlayer) {
        return false;
    }

    public int wageMoney() {
        return 0;
    }

    //int handValue = 0;

    private static final String HOLD_CONSTANT = "hold";


    public void blackJack (String[] args){

        //user input for Int
        int betAmount = 0;

        //user input for String
        String decision;


        Console aConsole = new Console();


        ////////public int startTheGame(int playerScore, int houseScore, int getRank)



        playerScore = Card.getRank() + Card.getRank();

        houseScore = Card.getRank() + Card.getRank();



        while(!HOLD_CONSTANT.equals(decision) || playerScore < 21) {

            //IF statement that asks for userInput after each loop(?)
            //add sum values of two cards to playerScore hand
            //add sum values of two cards to houseScore hand

           decision = aConsole.getStringInput("Please make a call:\nHit\nStand");


            If(decision.equals("Hit")) {

                If(decision.equals("Ace") && playerScore > 10) {
                    playerScore + 1;
                }
                else{
                    playerScore + 11;
                }
            }
            else if(aConsole.getStringInput().equals("Stand"))



    }

    If(playerScore > 21){

        }


    }


    }


