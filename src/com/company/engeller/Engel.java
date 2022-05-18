package com.company.engeller;

public class Engel {
    private int id;
    private String isim;
    private int hasar;
    private int can;
    private int doluCan;
    private int odul;

    public Engel(int id, String isim, int hasar, int can, int doluCan, int odul) {
        this.id = id;
        this.isim = isim;
        this.hasar = hasar;
        this.can = can;
        this.doluCan = doluCan;
        this.odul = odul;
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

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        if (can < 0) {
            can = 0;
        }

        this.can = can;
    }

    public int getDoluCan() {
        return doluCan;
    }

    public void setDoluCan(int doluCan) {
        this.doluCan = doluCan;
    }

    public int getOdul() {
        return odul;
    }

    public void setOdul(int odul) {
        this.odul = odul;
    }
}
