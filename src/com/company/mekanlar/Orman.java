package com.company.mekanlar;

import com.company.Player;
import com.company.engeller.Wampire;

public class Orman extends BattleLocation{
    public Orman(Player player) {
        super(player, "Forrest", new Wampire(), "firewood",3);
    }
}
