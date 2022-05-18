package com.company.itemler;

public class Armor {

    private int id;
    private String isim;
    private int block;
    private int fiyat;

    public Armor(int id, String isim, int block, int fiyat) {
        this.id = id;
        this.isim = isim;
        this.block = block;
        this.fiyat = fiyat;

    }

    public static Armor[] armors() {
        Armor[] armorList = new Armor[4];
        armorList[0] = new Armor(0, "hafif", 10, 50);
        armorList[1] = new Armor(1, "orta", 15, 70);
        armorList[2] = new Armor(2, "ağır", 20, 85);
        armorList[3] = new Armor(3,"boş",2,0);
        return armorList;
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

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public static Armor getArmorObjById(int id) {
        for (Armor i : armors()) {
            if (i.id == id) return i;

        }
        return null;
    }
}
