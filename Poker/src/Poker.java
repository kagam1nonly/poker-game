import java.util.*;

public class Poker
{
    /*
     * A simple poker game that shuffles a deck of cards (no GUI)
     */
    public static void main(String[] args)
    {
        // Create a deck of cards and shuffle it
        Stack<PlayingCard> deck = new Stack<>();
        for (int i = 1; i <= 13; i++)
        {
            deck.push(new PlayingCard(i, "Heart"));
            deck.push(new PlayingCard(i, "Diamond"));
            deck.push(new PlayingCard(i, "Spade"));
            deck.push(new PlayingCard(i, "Club"));
        }

        Collections.shuffle(deck);

        // Deal 5 cards to the player
        ArrayList<PlayingCard> hand = new ArrayList<>();
        hand.add(deck.pop());
        for (int i = 1; i < 5; i++)
        {
            hand.add(deck.pop());
        }

        // Sort the hand by rank
        hand.sort(new Comparator<PlayingCard>()
        {
            @Override
            public int compare(PlayingCard c1, PlayingCard c2)
            {
                return c2.getRank() - c1.getRank();
            }
        });

        // Find the highest card in the player's hand
        PlayingCard highestCard = hand.get(0);

        for (PlayingCard card : hand) {
            if (card.getRank() >= highestCard.getRank() || card.getRank() == 1) {
                highestCard = card;
            }
        }

        // Check for pairs, two pairs, three of a kind, and four of a kind
        Map<Integer, Integer> rankCounts = new HashMap<>();
        for (PlayingCard card : hand)
        {
            int rank = card.getRank();
            if (rankCounts.containsKey(rank))
            {
                rankCounts.put(rank, rankCounts.get(rank) + 1);
            }
            else
            {
                rankCounts.put(rank, 1);
            }
        }

        boolean isPair = false;
        boolean isTwoPair = false;
        boolean isThreeOfAKind = false;
        boolean isFourOfAKind = false;
        for (int count : rankCounts.values())
        {
            if (count == 2)
            {
                if (isPair)
                {
                    isTwoPair = true;
                }
                else
                {
                    isPair = true;
                }
            }
            else if (count == 3)
            {
                isThreeOfAKind = true;
            }
            else if (count == 4)
            {
                isFourOfAKind = true;
            }
        }

        // Check for flush
        boolean isFlush = true;
        String suit = hand.get(0).getSuit();
        for (PlayingCard card : hand)
        {
            if (!card.getSuit().equals(suit))
            {
                isFlush = false;
                break;
            }
        }

        // Check for straight
        boolean isStraight = true;
        int rank = hand.get(0).getRank();
        for (PlayingCard card : hand)
        {
            if (card.getRank() != rank - 1)
            {
                isStraight = false;
                break;
            }
            rank = card.getRank();
        }

        // Print the hand
        System.out.println("You have been dealt a hand of 5 cards: ");
        for (PlayingCard card : hand)
        {
            System.out.println(card);
        }

        if (isFlush && isStraight)
        {
            System.out.println("\nStraight Flush!");
        }
        else if (isFourOfAKind)
        {
            System.out.println("\nFour of a Kind!");
        }
        else if (isThreeOfAKind && isPair)
        {
            System.out.println("\nFull House!");
        }
        else if (isFlush)
        {
            System.out.println("\nFlush!");
        }
        else if (isStraight)
        {
            System.out.println("\nStraight!");
        }
        else if (isThreeOfAKind)
        {
            System.out.println("\nThree of a Kind!");
        }
        else if (isTwoPair)
        {
            System.out.println("\nTwo Pair!");
        }
        else if (isPair)
        {
            System.out.println("\nPair!");
        }
        else
        {
            // Print the highest card if no combination
            System.out.println("\nHigh Card! " + highestCard);
        }
    }
}