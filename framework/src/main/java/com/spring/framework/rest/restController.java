package com.spring.framework.rest;

import org.geotools.referencing.GeodeticCalculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restController {
    @GetMapping("/")
    public String fuckingFirstHelu(){
        return "Helu";
    }

    @GetMapping("/distWithCalculation")
    public double calculateDistanceBetweenCoordinates(){
        // The math module contains a function
        // named toRadians which converts from
        // degrees to radians.
        // 23.0281712, 72.5315311
        // 23.02945467968247, 72.52893175483776

        // 1:: 23.02817741334458, 72.53149901220907
        // 2:: 23.03219549587904, 72.52509885806678

        // 1:: 23.028259818059013, 72.53154305797756
        // 2:: 23.03202324124126, 72.52528722639227


        // 1:: 23.028463184344183, 72.53120891988675
        // 2:: 23.02829025560441, 72.53155269596606

        // 1:: 23.028588352518923, 72.53171143714017
        // 2:: 23.024373325469092, 72.52993770419948
        double lon1 = Math.toRadians(72.53171143714017);
        double lon2 = Math.toRadians(72.52993770419948);
        double lat1 = Math.toRadians(23.028588352518923);
        double lat2 = Math.toRadians(23.024373325469092);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return((c * r) * 1000);
//        return 0;
    }

    @GetMapping("/distWithMath")
    public double getDistantWithLib(){
        double lon1 = Math.toRadians(72.5315311);
        double lon2 = Math.toRadians(72.52893175483776);
        double lat1 = Math.toRadians(23.0281712);
        double lat2 = Math.toRadians(23.02945467968247);

        double earthRadius = 3958.75; // miles (or 6371.0 kilometers)
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lon2-lon1);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double dist = earthRadius * c;
        return dist;
    }
    // pushing from personal account
}
