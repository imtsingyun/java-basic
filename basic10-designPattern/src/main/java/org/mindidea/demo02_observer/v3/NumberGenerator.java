/*
 * @class NumberGenerator
 * @package org.mindidea.demo02_observer.v3
 * @date 2020/11/29 12:18
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo02_observer.v3;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/29 12:18
 * @blog https://mindidea.org
 */
public abstract class NumberGenerator {

    private ArrayList observers = new ArrayList();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        Iterator it = observers.iterator();
        while (it.hasNext()) {
            Observer o = (Observer) it.next();
            o.update(this);
        }
    }

    public abstract int getNumber();

    public abstract void execute();
}
