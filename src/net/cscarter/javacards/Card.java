package net.cscarter.javacards;

public class Card {
    private String _suit;
    private String _value;

    public Card(String s, String v) {
        this._suit = s;
        this._value = v;
    }  //ctor

    public String getSuit(){
        return this._suit;
    }

    public String getValue(){
        return this._value;
    }
}  //Card