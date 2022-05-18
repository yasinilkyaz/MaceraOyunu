package com.company.mekanlar;

import com.company.Player;
import com.company.engeller.Engel;

import java.util.Random;
import java.util.Scanner;

public abstract class  BattleLocation extends Mekan {

    Engel obstacle;
    private String award;
    private int maxObstacle;
    private static Random random;

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public BattleLocation(Player player, String name, Engel obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
        random=new Random();
    }
    public BattleLocation(String name, Player player, Engel obstacle, int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.maxObstacle=maxObstacle;
        random=new Random();

    }

    public Engel getObstacle() {
        return obstacle;
    }

    public void setObstacle(Engel obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.maxObstacle)+1;
    }

    public static Random getRandom() {
        return random;
    }

    public static void setRandom(Random random) {
        BattleLocation.random = random;
    }

    @Override
    public boolean onLocation(){

        int obsNumber=randomObstacleNumber();
        System.out.println("You are at" + this.getIsim());
        System.out.println("Be careful because " +obsNumber+ " " + this.getObstacle().getIsim() + " lives here");
        System.out.println("<F>ight OR <R>un");
        String selectedAction=input.nextLine();
        selectedAction=selectedAction.toUpperCase();
        if(selectedAction.equals("F") && combat(obsNumber)){
            System.out.println("You killed all enemies in " + this.getIsim());
            return true;

        }
        if(this.getPlayer().getHealth()<=0){
            System.out.println("You DEAD !!!");

            return false;
        }

        return true;
    }

    public boolean combat(int obsNumber){
        for(int i=0;i<obsNumber;i++){
            this.getObstacle().setCan(this.getObstacle().getDoluCan());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth()>0 && this.getObstacle().getCan() > 0){
                System.out.println("<H>it OR <R>un");
                String selectedCombat=input.nextLine().toUpperCase();
                if(selectedCombat.equals("H")){
                    chooseHit();
                }else{
                    return false;
                }
            }
            if(this.getObstacle().getCan()<this.getPlayer().getHealth()){
                defeatObstacles(i);
            }
            else{
                return false;
            }
            completeLocation(i,obsNumber);
        }
        return true;

    }
    public void afterHit(){
        System.out.println("Your Health : " + this.getPlayer().getHealth());
        System.out.println("Your enemy's Health : " + this.getObstacle().getCan());
    }
    public void playerStats(){
        System.out.println("Player Statistics");
        System.out.println("------------------");
        System.out.println("Health : " + this.getPlayer().getHealth());
        System.out.println("Your Gun : " +this.getPlayer().getInventory().getWeapon().getIsim());
        System.out.println("Damage : " + this.getPlayer().getTotalDamage());
        System.out.println("Money : " + this.getPlayer().getMoney());
        System.out.println("Your Armor : " +this.getPlayer().getInventory().getArmor().getIsim());
        System.out.println("Your Blocking Power : " +this.getPlayer().getInventory().getArmor().getBlock());

    }
    public void obstacleStats(int i){
        System.out.println(i+1 + "." + this.getObstacle().getIsim() + "Statistics");
        System.out.println("Health : " + this.getObstacle().getCan());
        System.out.println("Damage : " + this.getObstacle().getHasar());
        System.out.println("Award : " + this.getObstacle().getOdul());
    }
    public void chooseHit(){
        int randomHit= random.nextInt(100);

        if (randomHit<50) {
            attack();
            defend();
        }else{
            if (this.getObstacle().getCan()>0) {
                defend();
                attack();
            }
        }
    }
    public void attack(){
        System.out.println("You Hitted !!!");
        int obstacleHealth=this.getObstacle().getCan()-this.getPlayer().getTotalDamage();
        this.getObstacle().setCan(obstacleHealth);
        afterHit();
    }
    public void defend(){
        System.out.println(this.getObstacle().getIsim() + " Hitted !!");
        int obstacleTotalDamage=this.getObstacle().getHasar()-this.getPlayer().getInventory().getArmor().getBlock();
        obstacleTotalDamage= Math.max(obstacleTotalDamage, 0);
        this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleTotalDamage);
        afterHit();
    }
    public void defeatObstacles(int obsNumber){
        System.out.println("You kileed : " + obsNumber + " " + this.getObstacle().getIsim());
        System.out.println("You earned : " + this.getObstacle().getOdul());
        int balance=this.getPlayer().getMoney()+this.getObstacle().getOdul();
        this.getPlayer().setMoney(balance);
        System.out.println("Your money is: "+this.getPlayer().getMoney()+ " now");
    }
    public void completeLocation(int i, int obsNumber){

        if (i+1 == obsNumber && this.getAward() != null) {
            System.out.println("\nCongratulations!! You Killed Them All !! You have some "+this.getAward().toUpperCase()+" now");
            if(this.getObstacle().getIsim().equals("Zombie")) this.getPlayer().getInventory().setFood(true);
            if(this.getObstacle().getIsim().equals("Vampire")) this.getPlayer().getInventory().setFirewood(true);
            if(this.getObstacle().getIsim().equals("Bear")) this.getPlayer().getInventory().setWater(true);
            if(this.getObstacle().getIsim().equals("Snake")) this.getPlayer().getInventory().setSnakeDone(true);
        }
    }

}
