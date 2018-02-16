package net.cscarter.javacards;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    protected ArrayList<Card> _cards;
    protected String _name;

    Player(String name){
        this._cards = new ArrayList<Card>();
        this._name = name;
    }  //ctor

    public String getName(){
        return this._name;
    }  //getName

    public ArrayList<Card> showCards(){
        return this._cards;
    }  //showCards

    public Card showCard(int i){
        return this._cards.get(i);
    }  //showCard

    public void addCard(Card c){
        this._cards.add(c);
    }  //addCard

    public Card takeCard(int i){

        Card card = this._cards.get(i);
        this._cards.remove(i);
        return card;
    }  //takeCard

    public ArrayList<Card> takeCards(int i){

        ArrayList<Card> cards = this._cards;
        this._cards.clear();
        return cards;
    }  //takeCards

    public int cardCount(){
        return this._cards.size();
    }  //cardCount

    public void shuffle(int times) {
        int s = this._cards.size();
        Random rnd = new Random();
        int counter = 0;
        while (counter < times) {
            int r1 = rnd.nextInt(s);
            int r2 = rnd.nextInt(s);
            if (r1 == r2) {
                continue;
            } else {
                Card tempCard = this._cards.get(r1);
                this._cards.set(r1, this._cards.get(r2));
                this._cards.set(r2, tempCard);
                counter++;
            }
        }
    }  //shuffle
}  //Player
