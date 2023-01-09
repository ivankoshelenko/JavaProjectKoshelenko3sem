package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Grant {
    String street;
    String name;
    Business business;
    int workers;
    Double grantAmount;
    int year;


    public static List<Grant> Fielder(List<String[]> list,List<Business> businessList){
        List<Grant> grants = new ArrayList<>();
        Grant grant = new Grant();
        Iterator<String[]> iter = list.iterator();
        Iterator<Business> businessIter = businessList.iterator();

        while(iter.hasNext()) {
            String[] line = iter.next();
            if(line[0] != "") {
                Business business = businessIter.next();
                grant.name = line[0];
                grant.street = line[1];
                grant.grantAmount = Double.parseDouble(line[2].replace("$", "").replace(",", ""));
                grant.year = Integer.parseInt(line[3]);
                grant.business = business;
                if(line[5] != "")
                    grant.workers = Integer.parseInt(line[5]);
                else
                    grant.workers = 0;
                grants.add(grant);
                //System.out.println(grant.year);
            }
        }
        return grants;
    }
}
