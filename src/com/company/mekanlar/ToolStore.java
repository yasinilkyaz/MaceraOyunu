package com.company.mekanlar;

import com.company.Player;
import com.company.itemler.Armor;
import com.company.itemler.Weapon;

public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "ToolStore");
    }
    @Override
    public boolean onLocation() {
        System.out.println("You are in the ToolStore");
        boolean showMenu = true;
        while(showMenu){
            System.out.println("1 - Weapons");
            System.out.println("2 - Armors");
            System.out.println("3 - Exit");
            System.out.print("Make a choice : ");
            int selectedCase = input.nextInt();

            while(selectedCase<1 || selectedCase >3){
                System.out.println("Your choice is not in the range please try again");
                selectedCase=input.nextInt();
            }
            switch (selectedCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Have fun");
                    showMenu = false;
                    break;
            }
        }

        return true;
    }
    public void printWeapon(){
        System.out.println("Weapons");
        for(Weapon w : Weapon.weapons()){
            System.out.println(w.getId() +"- Name : "
                    + w.getIsim() + " Damage : "
                    + w.getHasar() + " Price : "
                    + w.getPara());
        }
        System.out.println("0 - Exit");
    }
    public void buyWeapon(){
        System.out.print("Pick up your gun and start fighting");
        int selectedWeaponID = input.nextInt();
        while(selectedWeaponID<0 || selectedWeaponID > Weapon.weapons().length){
            System.out.println("Your choice is not in the range please try again");
            selectedWeaponID=input.nextInt();
        }
        if(selectedWeaponID!=0){
            //bir obje oluşacak
            Weapon selectedWeapon = Weapon.getWeaponObjById(selectedWeaponID);

            if (selectedWeapon != null) {
                if(selectedWeapon.getPara() > this.getPlayer().getMoney()){
                    System.out.println("Your money is not enough");
                }else{
                    System.out.println(selectedWeapon.getIsim() + " is your new gun !");
                    int balance = this.getPlayer().getMoney()-selectedWeapon.getPara();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your money : " + this.getPlayer().getMoney());
                    System.out.println("Your previous gun : "
                            + this.getPlayer().getInventory().getWeapon().getIsim());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Your new gun : "
                            + this.getPlayer().getInventory().getWeapon().getIsim());
                }
            }
        }

    }
    public void printArmor(){
        System.out.println("Armors");

        for(Armor a : Armor.armors()){
            System.out.println(a.getId() +
                    "- Name : " + a.getIsim()
                    + " Block : " + a.getBlock()
                    + " Price : " + a.getFiyat());
        }
        System.out.println("0 - Exit");
    }

    public void buyArmor(){
        System.out.print("Pick up your armor and start fighting");
        int selectedArmorID = input.nextInt();
        while(selectedArmorID<0 || selectedArmorID > Armor.armors().length){
            System.out.println("Your choice is not in the range please try again");
            selectedArmorID=input.nextInt();
        }
        if(selectedArmorID!=0){
            Armor selectedArmor = Armor.getArmorObjById(selectedArmorID);

            if (selectedArmor != null) {
                if(selectedArmor.getFiyat() > this.getPlayer().getMoney()){
                    System.out.println("Your money is not enough");
                }else{
                    System.out.println(selectedArmor.getIsim() + " is your new gun !");
                    int balance = this.getPlayer().getMoney()-selectedArmor.getFiyat();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your money : " + this.getPlayer().getMoney());
                    System.out.println("Your previous armor : "
                            + this.getPlayer().getInventory().getWeapon().getIsim());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Your new armor : "
                            + this.getPlayer().getInventory().getArmor().getIsim());
                }
            }
        }

    }

}
