package org.mindidea.design.d6builder;


public abstract class AbstractHouse {
    // 打地基
    abstract void buildBasic();
    // 砌墙
    abstract void buildWalls();
    // 封顶
    abstract void roofed();

    public void build() {
        buildBasic();
        buildWalls();
        roofed();
    }
}
