package com.company.javaLogic;

import java.util.*;

/**
 * The type Deck of card.
 */
public class DeckOfCard {

    /**
     * index values means
     * 0 : Club
     * 1 : Diamond
     * 2 : Heart
     * 3 : Spade
     */
    List<List<String>> cards = null;
    /**
     * The Remaining cards.
     */
    int remainingCards = 0;
    /**
     * The Rand.
     */
    Random rand = null;
    /**
     * The Suits.
     */
    List<String> suits = null;

    /**
     * Instantiates a new Deck of card.
     */
    public DeckOfCard() {
        resetCards();
    }


    /**
     * The entry point of application test.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        DeckOfCard deckOfCard = new DeckOfCard();
        for (int i = 0; i < 56; i++) {
            System.out.println(deckOfCard.pullCard());
        }
    }

    /**
     * Reset cards.
     */
    public void resetCards() {
        rand = new Random();
        remainingCards = 52;
        cards = new ArrayList<>();
        List<String> club = getCardsList();
        cards.add(club);
        List<String> diamond = getCardsList();
        cards.add(diamond);
        List<String> heart = getCardsList();
        cards.add(heart);
        List<String> spade = getCardsList();
        cards.add(spade);
        printDeck(cards);
        for (List<String> cardSuit : cards) {
            Collections.shuffle(cardSuit);
        }
        suits = new LinkedList<>();
        suits.add("Club");
        suits.add("Diamond");
        suits.add("Heart");
        suits.add("Spade");
        System.out.println("After shuffle:  ");
        printDeck(cards);
    }

    private void printDeck(List<List<String>> cards) {
        for (List<String> card : cards) {
            System.out.println(card);
        }
    }

    private List<String> getCardsList() {
        List<String> list = new LinkedList<>();
        list.add("A");
        for (int i = 2; i < 11; i++) {
            list.add(String.valueOf(i));
        }
        list.add("J");
        list.add("Q");
        list.add("K");
        return list;
    }


    /**
     * Pull card string.
     *
     * @return the string
     */
    public String pullCard() {
        if (remainingCards == 0) return "No card Available";
        int suit = rand.nextInt(cards.size());
        String card = suits.get(suit) + "-" + cards.get(suit).remove(rand.nextInt(cards.get(suit).size()));
        if (cards.get(suit).size() == 0) {
            cards.remove(suit);
            suits.remove(suit);
        }
        remainingCards--;
        return card;
    }
}
