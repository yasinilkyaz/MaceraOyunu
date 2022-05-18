package com.company.mekanlar;

import com.company.Player;

public class NormalLoc extends Mekan{
    public NormalLoc(Player player, String isim) {
        super(player, isim);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
