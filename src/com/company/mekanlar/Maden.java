package com.company.mekanlar;

import com.company.Player;
import com.company.engeller.Snake;
import com.company.mekanlar.BattleLocation;

public class Maden extends BattleLocation {
    public Maden(Player player) {
        super("Mine", player, new Snake(), 5);
    }

    @Override
    public boolean onLocation() {


        if (this.getPlayer().isWater()
                && this.getPlayer().isFirewood()
                && this.getPlayer().isWater()
                && this.getPlayer().isSnakeDone()) {
            System.out.println("\nCONGRATS !!! ALL JOBS ARE DONE !!! YOU COMPLETED THE GAME");
            System.exit(0);
        } else {
            System.out.println("You are in the Safe House");
            System.out.println("Your healthy is renewed");
            this.getPlayer().setHealth(this.getPlayer().getOrigHealth());
        }

        return true;
    }
}
