[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=19824761)
# cardsWithOOD

Jose Giovanni Tapia Lopez 

June 20 2025

added a point system to the card game on the CardGame file, which 
rewards point if the player has a pair of 2 or 3 within their hand.


        // Award points for pairs I added to give points for pairs and three of a kind
        if (checkFor2Kind()) {
            playerPoints += 5; // Example: 10 points for a pair
            System.out.println("You got a pair! +5 points");
        }
        if(checkFor3Kind()){
            playerPoints += 10; // Example: 20 points for a three of a kind
            System.out.println("You got a three of a kind! +10 points");
        }

        System.out.println("Total points: " + playerPoints);

    //checking for 3 of a kinda during this iteration 
    public static boolean checkFor3Kind() {
        for (int i = 0; i < playerCards.size(); i++) {
            int count = 1;
            for (int j = 0; j < playerCards.size(); j++) {
                if (i != j && playerCards.get(i).getRank().equals(playerCards.get(j).getRank())) {
                    count++;
                }
            }
            if (count == 3) {
                return true; // Found exactly 3 of a kind
            }
        }
        return false;
    }