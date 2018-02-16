package net.cscarter.javacards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
    static Player[] players;
    static Deck deck = new Deck();

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int playercount = askPlayerCount(br);
        int shufflecount = askShuffleCount(br);

        //create the dealer
        Dealer dealer = new Dealer("Dealer");

        //create the players
        players = new Player[playercount];
        for (int i = 0; i < playercount; i++){
            players[i] = new Player("Player " + i);
        }

        //dealer get a deck and shuffles
        dealer.getDeck();
        System.out.println("Before shuffling: ");
        showHand(dealer);
        dealer.shuffle(shufflecount);
        System.out.println("After shuffling: ");
        showHand(dealer);

        dealAllCards(dealer, players);

        System.out.println("After dealing: ");
        showHand(dealer);
        for (int i = 0; i < players.length; i++) {
            showHand(players[i]);
        }
    }  //main

    static int askPlayerCount(BufferedReader br) throws IOException {
        int pc;
        do{
            System.out.println("Enter number of players:");
            pc = Integer.parseInt(br.readLine());
        } while (pc < 1 || pc > 52);
        return pc;
    }  //askPlayerCount

    static int askShuffleCount(BufferedReader br) throws IOException {
        int sc;
        do {
            System.out.println("Enter times to shuffle:");
            sc = Integer.parseInt(br.readLine());
        } while (sc < 0);

        return sc;
    }  //askShuffleCount

    static void showHand(Player player){
        System.out.println(player.getName());
        System.out.println("--------------------------");
        ArrayList<Card> cards = player.showCards();
        for (int i = 0; i < cards.size(); i++) {
            System.out.print(cards.get(i).getSuit() + cards.get(i).getValue() + "   ");
        }
        System.out.println("\n");
    }  //showHand

    static void dealAllCards(Dealer dealer, Player[] players){
        int counter = 0;
        while(dealer.cardCount() > 0) {
            int targetPlayer = counter % (players.length);
            players[targetPlayer].addCard(dealer.dealCard());
            counter++;
        }
    }  //dealAllCards
}  //Main