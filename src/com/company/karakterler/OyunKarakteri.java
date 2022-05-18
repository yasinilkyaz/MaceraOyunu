package com.company.karakterler;

public abstract class OyunKarakteri {
    private int id;
    private String isim;
    private int hasar;
    private int can;
    private int para;

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

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }

    public int getPara() {
        return para;
    }

    public void setPara(int para) {
        this.para = para;
    }

    public OyunKarakteri (int id,String isim,int hasar,int can,int para){

        this.id=id;
        this.isim=isim;
        this.hasar=hasar;
        this.can=can;
        this.para=para;



    }

}
