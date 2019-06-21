package org.ss.nivantis.nivantisapirest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.ss.nivantis.nivantisapirest.dao.PharmacieRepository;
import org.ss.nivantis.nivantisapirest.model.Pharmacie;

import java.util.*;

public class PharmacieService {

    @Autowired
    PharmacieRepository pharmacieRepository;
    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }
        else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            dist = dist * 1.609344;
            return (dist);
        }
    }

    public String GetProche(String latitude,String longitude){

        SortedMap<Double,Long> sm =
                new TreeMap<Double,Long>();

        for(int i=0;i<pharmacieRepository.findAll().size(); i++) {
            Pharmacie pharmacie = pharmacieRepository.findAll().get(i);
            sm.put(distance(Double.parseDouble(latitude), Double.parseDouble(longitude), Double.parseDouble(pharmacie.getLatitude()),
                    Double.parseDouble(pharmacie.getLongitude())),pharmacie.getId());
        }
        Set s = sm.entrySet();
        Iterator i = s.iterator();
        while (i.hasNext())
        {
            Map.Entry m = (Map.Entry)i.next();

            double key = (double)m.getKey();
            long value = (long)m.getValue();
        }
        Object[] test = sm.keySet().toArray();

        Object keyfinal  = sm.keySet().toArray()[0];
        Pharmacie proche = pharmacieRepository.findPharmacieById(sm.get(keyfinal));
        String sortie = "http://pboucher.ddns.net/dorade/index.htm"+"?pos="+proche.getLatitude()+","+proche.getLongitude()+"?distance="+test[0].toString();
        return sortie;
    }
}
