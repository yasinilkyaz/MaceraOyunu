package com.company.engeller;

import java.util.Random;

public class Snake extends Engel {
    private Random random;
    private int damage;

    public Snake() {
        super(1, "yılan", 10, 20, 20, 10);
    }
}
