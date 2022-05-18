package com.company.itemler;

public class Weapon {
    private int id;
    private String isim;
    private int hasar;
    private int para;


    public Weapon(int id, String isim, int hasar, int para) {
        this.id = id;
        this.isim = isim;
        this.hasar = hasar;
        this.para = para;
    }

    public static Weapon getWeaponObjById(int id) {
        for (Weapon i : weapons()) {
            if (i.id == id) return i;

        }
        return null;
    }


    public static Weapon[] weapons() {

        Weapon[] weaponList = new Weapon[4];
        weaponList[0] = new Weapon(0, "yay", 20, 50);
        weaponList[1] = new Weapon(1, "kılıç", 40, 50);
        weaponList[2] = new Weapon(2, "nodaçhi", 35, 50);
        weaponList[3]= new Weapon(3,"Yumruk",5,0);
        return weaponList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getHasar() {
        return hasar;
    }

    public void setHasar(int hasar) {
        this.hasar = hasar;
    }

    public int getPara() {
        return para;
    }

    public void setPara(int para) {
        this.para = para;
    }
}
