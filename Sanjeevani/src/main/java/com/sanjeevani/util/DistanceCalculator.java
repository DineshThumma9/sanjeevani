package com.sanjeevani.util;

import com.sanjeevani.model.Location;




public class DistanceCalculator {



        private static final double EARTH_RADIUS = 6371.0;

        public static double calculateDistance(Location loc1, Location loc2) {
            double lat1 = Math.toRadians(loc1.getLatitude());
            double lon1 = Math.toRadians(loc1.getLongitude());
            double lat2 = Math.toRadians(loc2.getLatitude());
            double lon2 = Math.toRadians(loc2.getLongitude());

            double dlat = lat2 - lat1;
            double dlon = lon2 - lon1;

            double a = Math.sin(dlat / 2) * Math.sin(dlat / 2) +
                    Math.cos(lat1) * Math.cos(lat2) *
                            Math.sin(dlon / 2) * Math.sin(dlon / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

            return EARTH_RADIUS * c;
        }
}
