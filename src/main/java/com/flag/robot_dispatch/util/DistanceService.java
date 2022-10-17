package com.flag.robot_dispatch.util;

import com.flag.robot_dispatch.model.Location;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
public class DistanceService {
    public DistanceService() {
    }

    public double getTotalDistance(Location vehicleLocation, Location pickUp, Location delivery) {
        return getDistance(vehicleLocation, pickUp)
                + getDistance(pickUp, delivery)
                + getDistance(delivery, vehicleLocation);
    }

    /**
     * distance = sqrt((x1 - x2)^2 + (y1 - y2)^2)
     */
    public double getDistance(Location a, Location b) {
        GeoPoint pointA = a.getGeoPoint();
        GeoPoint pointB = b.getGeoPoint();
        return Math.sqrt(
                Math.pow((pointA.getLat() - pointB.getLat()), 2) +
                        Math.pow((pointA.getLon() - pointB.getLon()), 2)
        );
    }
}
