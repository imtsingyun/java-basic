/*
 * @class MonitorVehicleTracker
 * @package org.mindidea.chapter04.demo04
 * @date 2020/12/6 13:53
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter04.demo04;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/6 13:53
 * @blog https://mindidea.org
 */
public class MonitorVehicleTracker {

    private final Map<String, MutablePoint> locations;


    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePoint> getLocations() {
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id) {
        MutablePoint loc = locations.get(id);
        return loc == null ? null : new MutablePoint(loc);
    }

    public synchronized void setLocation(String id, int x, int y) {
        MutablePoint loc = locations.get(id);
        if (loc == null) {
            throw new IllegalArgumentException("No such ID: " + id);
        }
        loc.x = x;
        loc.y = y;
    }

    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m) {
        Map<String, MutablePoint> result = new HashMap<String, MutablePoint>();
        for (String id : m.keySet()) {
            result.put(id, new MutablePoint(m.get(id)));
        }
        return Collections.unmodifiableMap(result);
    }
}

class MutablePoint {

    public int x;
    public int y;

    public MutablePoint() {
        x = 0;
        y = 0;
    }

    public MutablePoint(MutablePoint mutablePoint) {
        this.x = mutablePoint.x;
        this.y = mutablePoint.y;
    }
}