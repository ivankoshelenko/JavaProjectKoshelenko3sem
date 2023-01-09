package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Business {
    String street;
    String name;
    int workers;
    public static List<Business> Fielder(List<String[]> list){
        List<Business> businesses = new ArrayList<>();
        Business business = new Business();
        Iterator<String[]> iter = list.iterator();
        iter.next();
        iter.remove();

        while(iter.hasNext()) {
            String[] line = iter.next();
            if(line[0] != "") {
                business.street = line[1];
                business.name = line[4];
                if(line[5] != "")
                    business.workers = Integer.parseInt(line[5]);
                else
                    business.workers = 0;

                businesses.add(business);
                //System.out.println(business.workers);
            }
        }
        return businesses;
    }
}
