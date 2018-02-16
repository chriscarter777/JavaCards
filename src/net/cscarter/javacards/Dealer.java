package net.cscarter.javacards;

public class Dealer extends Player {

    public Dealer(String name){
        super(name);
    }  //ctor

    public void getDeck(){
        Deck deck = new Deck();
        this._cards = deck.getCards();
    }  //getDeck

    public Card dealCard(){
        int lastIndex = this._cards.size() - 1;
        Card c = this._cards.get(lastIndex);
        this._cards.remove(lastIndex);
        return c;
    }  //dealCard
}  //Dealer
