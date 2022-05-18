package com.company.mekanlar;

import com.company.Player;
import com.company.engeller.Bear;

public class Nehir extends BattleLocation {
    public Nehir(Player player) {
        super(player, "River", new Bear(), "water",2);
    }
}
