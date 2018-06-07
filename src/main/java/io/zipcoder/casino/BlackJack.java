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

        playerScore = Card.getRank() + Card.getRank();

        houseScore = Card.getRank() + Card.getRank();



        while(!HOLD_CONSTANT.equals(Console.getInput()) || playerScore < 21) {

            //IF statement that asks for userInput after each loop(?)
            //add sum values of two cards to playerScore hand
            //add sum values of two cards to houseScore hand

            Console.getInput();

            If(Console.getInput().equals("Hit")) {

                If(Card.getRank().equals("Ace") && playerScore > 10) {
                    playerScore + 1;
                }
                else{
                    playerScore + 11;
                }
            }
            else if(Console.getInput().equals("Stand"))



    }

    If(playerScore > 21){
            //Use console to printOut "Bust"
        }


    }


    }


