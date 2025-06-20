//Jose Giovanni Tapia Lopez
//June 20 2025
//Card game with OOD


// package cardGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CardGame {

	//these are our data structures to hold our cards
	private static ArrayList<Card> deckOfCards = new ArrayList<Card>();
	private static ArrayList<Card> playerCards = new ArrayList<Card>();
	private static int playerPoints = 0; // Point system for the player


	public static void main(String[] args) {

		Scanner input = null;
		try {
			input = new Scanner(new File("cards.txt"));
		} catch (FileNotFoundException e) {
			// error
			System.out.println("error");
			e.printStackTrace();
		}

		while(input.hasNext()) {
			String[] fields  = input.nextLine().split(",");
			//	public Card(String cardSuit, String cardName, int cardValue, String cardPicture) {
			Card newCard = new Card(fields[0], fields[1].trim(),
					Integer.parseInt(fields[2].trim()), fields[3]);
			deckOfCards.add(newCard);	
		}

		shuffle();

		// deal the player 5 cards (always remove from index 0 to avoid skipping cards)
        for(int i = 0; i < 5; i++) {
            playerCards.add(deckOfCards.remove(0));
        }
        
        System.out.println("players cards");
        for(Card c: playerCards)
            System.out.println(c);

        // Award points for pairs
        if (checkFor2Kind()) {
            playerPoints += 10; // Example: 10 points for a pair
            System.out.println("You got a pair! +10 points");
        }

        System.out.println("Total points: " + playerPoints);

    }//end main

    public static void shuffle() {
        Collections.shuffle(deckOfCards);
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
}//end class


