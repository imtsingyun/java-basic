package org.mindidea.design.d6builder;

public class CommonHouse extends AbstractHouse {
    @Override
    void buildBasic() {
        System.out.println("common house build basic");
    }

    @Override
    void buildWalls() {
        System.out.println("common house build walls");
    }

    @Override
    void roofed() {
        System.out.println("common house roofed");
    }
}
