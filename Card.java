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

    //private variables that can be accessed by the getter and setters methods
    private String suit;
    private String rank;
    private int value;
    private String Pictures;

    // Default constructor with no parameters
    public Card() {
        this.suit = SPADES;
        this.rank = ACE;
        this.value = 1;
    }


    // Parameterized constructor cotaining the suit, rank, and value of the card.
    //also assisgns the value from the constructor to the private variable value.
    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }


    //create a cronstructor to read in the file text input and assign the values to the private variables as well.
    public Card(String cardSuit, String cardName, int cardValue, String cardPicture) {
        this.suit = cardSuit;
        this.rank = cardName;
        this.value = cardValue;
        this.Pictures = cardPicture;
    }

    // Copy constructor to make a deep copy of another card object within memmory
    public Card(Card other) {
        this.suit = other.suit;
        this.rank = other.rank;
        this.value = other.value;
    }

    // Accessors (getters which are read only for the private variables).
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

    // Mutators (setters able to modify the private variables).
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

    // toString method which converts the value of the card into a string format
    @Override
    public String toString() {
        return rank + " of " + suit + " (value: " + value + ")";
    }
}