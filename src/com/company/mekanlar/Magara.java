package com.company.mekanlar;

import com.company.Player;
import com.company.engeller.Zombie;
import com.company.mekanlar.BattleLocation;

public class Magara extends BattleLocation {
    public Magara(Player player) {
        super(player, "Cave", new Zombie(), "food",3);
    }

}
