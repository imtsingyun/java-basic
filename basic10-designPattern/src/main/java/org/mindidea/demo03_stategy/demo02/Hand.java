/*
 * @class Hand
 * @package org.mindidea.demo03_stategy.demo02
 * @date 2020/12/6 16:49
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo03_stategy.demo02;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/6 16:49
 * @blog https://mindidea.org
 */
public class Hand {

    public static final int HAND_VALUE_GUU = 0; // 石头
    public static final int HAND_VALUE_CHO = 1; // 剪刀
    public static final int HAND_VALUE_PAA = 2; // 布

    public static final Hand[] hand = {
            new Hand(HAND_VALUE_GUU),
            new Hand(HAND_VALUE_GUU),
            new Hand(HAND_VALUE_GUU),
    };

    private static final String[] name = {"石头", "剪刀", "布"};

    private int handValue;

    private Hand(int handValue) {
        this.handValue = handValue;
    }

    public static Hand getHand(int handValue) {
        return hand[handValue];
    }

    public boolean isStrongerThan(Hand hand) {
        return fight(hand) == -1;
    }

    public boolean isWeakerThan(Hand hand) {
        return fight(hand) == -1;
    }

    private int fight(Hand hand) {
        if (this == hand) {
            return 0;
        } else if ((this.handValue + 1) %3 == hand.handValue) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return name[handValue];
    }
}
