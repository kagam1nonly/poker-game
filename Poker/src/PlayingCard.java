public class PlayingCard
{
    private int rank;
    private String suit;

    // Default constructor
    PlayingCard()
    {
        rank =  1;
        suit = "Heart";
    }
    // Second constructor to specify the rank and suit
    PlayingCard(int rank, String suit)
    {
        this.rank = rank;
        this.suit = suit;
    }
    // Return the rank of the card (1-13)
    public int getRank()
    {
        return this.rank;
    }

    // Return the suit of the card ("Heart", "Spade", "Diamond", "Club")
    public String getSuit()
    {
        return suit;
    }


    // Returns the name of the rank as string (e.g., "1 -> Ace" "2", "3", ..., "Jack", "Queen", "King")


    // Returns a string representation of the card (e.g., "Ace of Heart")
    public String toString()
    {
        String rankStr = "";
        switch (rank)
        {
            case 1 -> rankStr = "Ace";
            case 11 -> rankStr = "Jack";
            case 12 -> rankStr = "Queen";
            case 13 -> rankStr = "King";
            default -> rankStr = Integer.toString(rank);
        }
        return rankStr + " of " + getSuit();
    }
}