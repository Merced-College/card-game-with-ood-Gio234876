public class Card {

    // Suit constants
    public static final String HEARTS = "Hearts";
    public static final String DIAMONDS = "Diamonds";
    public static final String CLUBS = "Clubs";
    public static final String SPADES = "Spades";

    // Rank constants
    public static final String ACE = "Ace";
    public static final String KING = "King";
    public static final String QUEEN = "Queen";
    public static final String JACK = "Jack";

    private String suit;
    private String rank;
    private int value;
    private String Pictures;

    // Default constructor
    public Card() {
        this.suit = SPADES;
        this.rank = ACE;
        this.value = 1;
    }

      // Parameterized constructor
    // public Card(String suit, String rank) {
    //     this.suit = suit;
    //     this.rank = rank;
    //     this.value = determineValue(rank);
    // }

    // Parameterized constructor
    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }


    //create a cronstructor to read in the file text input.
    public Card(String cardSuit, String cardName, int cardValue, String cardPicture) {
        this.suit = cardSuit;
        this.rank = cardName;
        this.value = cardValue;
        this.Pictures = cardPicture;
    }

    // Copy constructor
    public Card(Card other) {
        this.suit = other.suit;
        this.rank = other.rank;
        this.value = other.value;
    }

    // Accessors (getters)
    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

    public String getPictures() {
        return Pictures;
    }

    // Mutators (setters)
    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPictures(String pictures) {
        this.Pictures = pictures;
    }

    // toString method
    @Override
    public String toString() {
        return rank + " of " + suit + " (value: " + value + ")";
    }
}