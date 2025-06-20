//Jose Giovanni Tapia Lopez

//June 20 2025

//Card game with OOD

//The program is able run and identify pairs and three of a kind in a player's hand and while providng points to the player
//While outputting the players hand showing the suit, rank, and value of the cards pulled.


// package cardGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CardGame {

	//Data structures to hold onto the deck of Cards
	private static ArrayList<Card> deckOfCards = new ArrayList<Card>();
	private static ArrayList<Card> playerCards = new ArrayList<Card>();
	private static int playerPoints = 0; // Point system for the player


	public static void main(String[] args) { // begining of the main method 

        //Reading the txt file that contaisn the possible cards, which can be pulled and if not pulls an error message.
		Scanner input = null;
		try {
			input = new Scanner(new File("cards.txt"));
		} catch (FileNotFoundException e) {
			// error
			System.out.println("error");
			e.printStackTrace();
		}

        //keeps reading the file if sucessfully opened
		while(input.hasNext()) {
			String[] fields  = input.nextLine().split(",");

			//	create a new card object and reads it from the txt file contain the deck of cards which later
            //get added to the dynamic array deckOfCards
			Card newCard = new Card(fields[0], fields[1].trim(),
					Integer.parseInt(fields[2].trim()), fields[3]);
			deckOfCards.add(newCard);	
		}

		shuffle(); //use the shuffle method to shuffle deck

		// deal the player 5 cards 
        for(int i = 0; i < 6; i++) {
            playerCards.add(deckOfCards.remove(0)); 
        }
        // adds to to the playerCards and removes it from the deckOfCards for for no repeats 
        
        //printing the amount of cards the player has and looping over to read the cards.
        System.out.println("players cards");
        for(Card c: playerCards)
            System.out.println(c);

        // Award points for pairs giving points to the player
        if (checkFor2Kind()) {
            playerPoints += 5; // 5 points for a pair
            System.out.println("You got a pair! +5 points");
        }
        if(checkFor3Kind()){
            playerPoints += 10; // 10 points for a three of a kind
            System.out.println("You got a three of a kind! +10 points");
        }

        System.out.println("Total points: " + playerPoints); //prints total points by adding pairs together.

    }

    public static void shuffle() {
        Collections.shuffle(deckOfCards); //a manner of shuffling the deck of cards
    }

    //check for 2 of a kind in the players hand
    public static boolean checkFor2Kind() {
        for (int i = 0; i < playerCards.size(); i++) {
            for (int j = i + 1; j < playerCards.size(); j++) {
                // Compare ranks for pairs
                if (playerCards.get(i).getRank().equals(playerCards.get(j).getRank()))
                    return true;
            }
        }
        return false;
    }

    //added 3 of a kind and point system to the card game.
    //check for a 3 of a kind in the players hand
    public static boolean checkFor3Kind() {
        for (int i = 0; i < playerCards.size(); i++) {
            int count = 1;
            for (int j = 0; j < playerCards.size(); j++) {
                if (i != j && playerCards.get(i).getRank().equals(playerCards.get(j).getRank())) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }
}


