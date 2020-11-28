/*
 * @class Subject
 * @package org.mindidea.chapter4
 * @date 2020/11/28 18:57
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/28 18:57
 * @blog https://mindidea.org
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public List<Observer> getObservers() {
        return observers;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        if (state == this.state) {
            return;
        }
        this.state = state;
        notifyAllObserver();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObserver() {
        observers.stream().forEach(Observer::update);
    }
}
