package io.zipcoder.casino.Leviathan;

import io.zipcoder.casino.Leviathan.Games.BlackJack;
import io.zipcoder.casino.Leviathan.Games.HigherCards;
import io.zipcoder.casino.Leviathan.Games.HigherDice;
import io.zipcoder.casino.Leviathan.Games.Yahtzee;
import io.zipcoder.casino.Leviathan.Interfaces.Game;


public class Table {

    Console aConsole = new Console();
    Game aGame;
    Player aPlayer;

    public Table(Player aPlayer) {
        this.aPlayer = aPlayer;
    }

    public void startGame() {
        boolean play = true;
        boolean played = false;
        aConsole.println("Welcome to The Leviathan Casino " + aPlayer.getName() + "!");

        while (play == true) {
            if (played == true) {
                aConsole.println("Welcome back to the selection table " + aPlayer.getName());
                aConsole.println("Your current chip total is " + aPlayer.getTotalChips());
            }
            int choice = 0;
            aConsole.println("Choose a game to play:");
            if (aPlayer.getTotalChips() > 0) {
                aConsole.println("1.Higher Dice\n2.Higher Card\n3.Black Jack\n4.Yahtzee\n5.Buy more Chips\n6.Cash Out\n\n");
                choice = aConsole.getIntInput("Enter your choice");
            } else {
                while (choice < 4) {
                    {
                        aConsole.println("It looks like you don't have any chips. You'll need chips to play any gambling games.");
                        //responseCounter++;
                        aConsole.println("4.Yahtzee\n5.Buy more Chips\n6.Cash Out\n\n");
                        choice = aConsole.getIntInput("Enter your choice");

                    }
                    while (choice == 5) {
                        int responseCounter = 1;
                        aConsole.println("I already told you. You're too young to buy chips, pal!");
                        responseCounter++;
                        aConsole.println("4.Yahtzee\n5.Buy more Chips\n6.Cash Out\n\n");
                        choice = aConsole.getIntInput("Enter your choice");
                        if (choice == 4) {
                            aGame = new Yahtzee(aPlayer);
                            aGame.playGame();
                            played = true;
                        }

                        responseCounter = 2;
                        aConsole.println("ENGLISH! Do you speak it?!");
                        responseCounter++;
                        aConsole.println("4.Yahtzee\n5.Buy more Chips\n6.Cash Out\n\n");
                        choice = aConsole.getIntInput("Enter your choice");
                        if (choice == 4) {
                            aGame = new Yahtzee(aPlayer);
                            aGame.playGame();
                            played = true;
                        }

                        responseCounter = 3;
                        aConsole.println("You still have exactly ZERO chips. I don't think you're understanding this.");
                        responseCounter++;
                        aConsole.println("4.Yahtzee\n5.Buy more Chips\n6.Cash Out\n\n");
                        choice = aConsole.getIntInput("Enter your choice");
                        if (choice == 4) {
                            aGame = new Yahtzee(aPlayer);
                            aGame.playGame();
                            played = true;
                        }

                        responseCounter = 4;
                        aConsole.println("Listen, I know you're only " + aPlayer.getAge() + ". You're not getting these chips, buddy.");
                        responseCounter++;
                        aConsole.println("4.Yahtzee\n5.Buy more Chips\n6.Cash Out\n\n");
                        choice = aConsole.getIntInput("Enter your choice");
                        if (choice == 4) {
                            aGame = new Yahtzee(aPlayer);
                            aGame.playGame();
                            played = true;
                        }

                        responseCounter = 5;
                        aConsole.println("No chips.");
                        responseCounter++;
                        aConsole.println("4.Yahtzee\n5.Buy more Chips\n6.Cash Out\n\n");
                        choice = aConsole.getIntInput("Enter your choice");
                        if (choice == 4) {
                            aGame = new Yahtzee(aPlayer);
                            aGame.playGame();
                            played = true;
                        }

                        responseCounter = 6;
                        aConsole.println("Still no chips.");
                        responseCounter++;
                        aConsole.println("4.Yahtzee\n5.Buy more Chips\n6.Cash Out\n\n");
                        choice = aConsole.getIntInput("Enter your choice");
                        if (choice == 4) {
                            aGame = new Yahtzee(aPlayer);
                            aGame.playGame();
                            played = true;
                        }

                        responseCounter = 7;
                        aConsole.println("Don't make me call you mom.");
                        responseCounter++;
                        aConsole.println("4.Yahtzee\n5.Buy more Chips\n6.Cash Out\n\n");
                        choice = aConsole.getIntInput("Enter your choice");
                        if (choice == 4) {
                            aGame = new Yahtzee(aPlayer);
                            aGame.playGame();
                            played = true;
                        }

                        responseCounter = 8;
                        aConsole.println("Were you born yesterday?");
                        responseCounter++;
                        aConsole.println("4.Yahtzee\n5.Buy more Chips\n6.Cash Out\n\n");
                        choice = aConsole.getIntInput("Enter your choice");
                        if (choice == 4) {
                            aGame = new Yahtzee(aPlayer);
                            aGame.playGame();
                            played = true;
                        }

                        responseCounter = 9;
                        aConsole.println("What's your name? " + aPlayer.getName() + " is it? Dumb name.");
                        responseCounter++;
                        aConsole.println("4.Yahtzee\n5.Buy more Chips\n6.Cash Out\n\n");
                        choice = aConsole.getIntInput("Enter your choice");
                        if (choice == 4) {
                            aGame = new Yahtzee(aPlayer);
                            aGame.playGame();
                            played = true;
                        }

                        responseCounter = 10;
                        aConsole.println("You're getting on my nerves " + aPlayer.getName().toUpperCase() + ". Now scram!");
                        responseCounter++;
                        aConsole.println("4.Yahtzee\n5.Buy more Chips\n6.Cash Out\n\n");
                        choice = aConsole.getIntInput("Enter your choice");
                        if (choice == 4) {
                            aGame = new Yahtzee(aPlayer);
                            aGame.playGame();
                            played = true;
                        }

                        responseCounter = 11;
                        aConsole.println("I hate you.");
                        responseCounter++;
                        aConsole.println("4.Yahtzee\n5.Buy more Chips\n6.Cash Out\n\n");
                        choice = aConsole.getIntInput("Enter your choice");
                        if (choice == 4) {
                            aGame = new Yahtzee(aPlayer);
                            aGame.playGame();
                            played = true;
                        }

                        responseCounter = 12;
                        aConsole.println("I'm goddamn serious man, I'm not giving you any chips.\nYou're not 21, and I'm not losing my sweet gig as a croupier's assistant giving away chips to some " +
                                aPlayer.getAge() + " year old named " + aPlayer.getName() + "!");
                        responseCounter++;
                        aConsole.println("4.Yahtzee\n5.Buy more Chips\n6.Cash Out\n\n");
                        choice = aConsole.getIntInput("Enter your choice");
                        if (choice == 4) {
                            aGame = new Yahtzee(aPlayer);
                            aGame.playGame();
                            played = true;
                        }

                        responseCounter = 13;
                        aConsole.println("Listen guy, do I need to get the bouncer over here?\nI'll do it, I'll get 'em!");
                        responseCounter++;
                        aConsole.println("4.Yahtzee\n5.Buy more Chips\n6.Cash Out\n\n");
                        choice = aConsole.getIntInput("Enter your choice");
                        if (choice == 4) {
                            aGame = new Yahtzee(aPlayer);
                            aGame.playGame();
                            played = true;
                        }

                        responseCounter = 14;
                        aConsole.println("This is your final warning, " + aPlayer.getName() + ". I'm really a nice guy, don't make me do this.");
                        responseCounter++;
                        aConsole.println("4.Yahtzee\n5.Buy more Chips\n6.Cash Out\n\n");
                        choice = aConsole.getIntInput("Enter your choice");
                        if (choice == 4) {
                            aGame = new Yahtzee(aPlayer);
                            aGame.playGame();
                            played = true;
                        }

                        if (responseCounter == 15) {
                            aConsole.println("Okay wise guy, you're OUTTA HERE!\n");
                            aConsole.println("[You've been thrown out of the casino by a croupier’s assistant. Are you proud of yourself?]\n(You shouldn't be)");
                            System.exit(0);
                            }



                    }
                    aConsole.println("4.Yahtzee\n5.Buy more Chips\n6.Cash Out\n\n");
                    choice = aConsole.getIntInput("Enter your choice");
                }
            }
            if (choice == 1)//Higher Dice
            {
                aGame = new HigherDice(aPlayer);
                aGame.playGame();
                played = true;
            } else if (choice == 2)//Higher Cards
            {
                aGame = new HigherCards(aPlayer);
                aGame.playGame();
                played = true;
            } else if (choice == 3) //BlackJack
            {
                aGame = new BlackJack(aPlayer);
                aGame.playGame();
                played = true;
            } else if (choice == 4) //Yahtzee
            {
                aGame = new Yahtzee(aPlayer);
                aGame.playGame();
                played = true;
            } else if (choice == 5) // Chips
            {
                if (aPlayer.getAge() > 20) {
                    aPlayer.setTotalChips(aPlayer.getTotalChips() + aConsole.getIntInput("How many more chips would you like?"));
                    aConsole.println("Great! Here you go! Good Luck!\n");
                } else {
                    aConsole.println("You are not old enough to gamble, so we won't be able to let you purchase any chips.\n");
                }
            } else if (choice == 6) // Cash Out
            {
                play = false;
                aConsole.println("Thank you for coming to the Leviathan Casino " + aPlayer.getName());
                aConsole.println("You've cashed out " + aPlayer.getTotalChips() + " chips");
                aConsole.println("Please come again!");
            } else {
                aConsole.println("That is not an option " + aPlayer.getName() + "... Do better\n");
            }
        }

    }
}






