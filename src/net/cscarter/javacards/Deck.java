package net.cscarter.javacards;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> _cards;
    private String[] _suits = {"\u2660", "\u2663", "\u2665", "\u2666"};

    private String[] _values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public Deck() {
        _cards = new ArrayList<Card>();
        int counter = 0;
        for (String s : _suits) {
            for (String v : _values) {
                _cards.add(new Card(s, v));
                counter++;
            }
        }
    }  //ctor

    public ArrayList<Card> getCards(){
        ArrayList<Card> allCards = new ArrayList<Card>(this._cards);
        this._cards.clear();
        return allCards;
    }  //getCards

    public Card getCard(int i){
        Card card = new Card(this._cards.get(i).getSuit(), this._cards.get(i).getValue());
        this._cards.remove(i);
        return card;
    }  //getCard
}  //Deck