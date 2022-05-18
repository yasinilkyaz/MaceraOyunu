package com.company.mekanlar;

import com.company.Player;

import java.util.Scanner;

public abstract class Mekan {

    private Player player;
    private String isim;
    protected Scanner input = new Scanner(System.in);


    public Mekan (Player player, String isim) {
        this.player = player;
        this.isim=isim;
    }

    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public Scanner getInp() {
        return input;
    }

    public void setInp(Scanner inp) {
        this.input = input;
    }


}
