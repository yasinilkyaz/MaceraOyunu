package com.company;

import com.company.karakterler.Archer;
import com.company.karakterler.Knight;
import com.company.karakterler.OyunKarakteri;
import com.company.karakterler.Samurai;

import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int origHealth;
    private int money;
    private String charName;
    private String playerName;
    private Inventory inventory;
    private Scanner input = new Scanner(System.in);

    public int getOrigHealth() {
        return origHealth;
    }

    public void setOrigHealth(int origHealth) {
        this.origHealth = origHealth;
    }



    public Player(String playerName) {
        this.playerName = playerName;
        this.inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void printInfo(){
        System.out.println("your gun : " + this.getInventory().getWeapon().getIsim()
                + " your armor : " + this.getInventory().getArmor().getIsim()
                + " your block : " + this.getInventory().getArmor().getBlock()
                + " your damage : " + this.getTotalDamage()
                + " your health : " + this.getHealth()
                + " your money : " + this.getMoney());
    }

    //butun karakter turlerini GameChar turunde bir diziye atıp for-each'le donuyoruz verilerini dinamik alak icin
    public void selectChar(){
        //polymorphism
        OyunKarakteri charList[] = {new Samurai(), new Archer(), new Knight()};
        for(OyunKarakteri OyunKarakteri:charList){
            System.out.println(
                    "\t Character ID : " + OyunKarakteri.getId() +
                            "\t Character name : " + OyunKarakteri.getIsim() +
                            "\t Damage : " + OyunKarakteri.getHasar() +
                            "\t Health : " + OyunKarakteri.getCan() +
                            "\t Money : " + OyunKarakteri.getPara());
        }
        System.out.println("***************");
        System.out.println("Please choose a character : ");

        int selectedChar = input.nextInt();
        switch (selectedChar){
            case 1:

                initPlayer(new Samurai());
                break;
            case 2:

                initPlayer(new Archer());
                break;
            case 3:

                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Character name : " + this.getCharName() +
                " Damage : " + this.getDamage() +
                " Health : " + this.getHealth() +
                " Money : " + this.getMoney());
    }

    //GameChar Turunde bir veri alıp secilen karakterin degerlerini player'ın degerlerine atiyor
    public void initPlayer(OyunKarakteri gameChar){
        this.setDamage(gameChar.getHasar());
        this.setHealth(gameChar.getCan());
        this.setOrigHealth(gameChar.getCan());
        this.setMoney(gameChar.getPara());
        this.setCharName(gameChar.getIsim());
    }
    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getHasar();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public boolean isWater(){
        return this.getInventory().isWater();
    }
    public boolean isFood(){
        return this.getInventory().isFood();
    }
    public boolean isFirewood(){
        return this.getInventory().isFirewood();
    }
    public boolean isSnakeDone(){
        return this.getInventory().isSnakeDone();
    }
}