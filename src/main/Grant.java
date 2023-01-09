package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Grant {
    String name;
    Business business;
    Double grantAmount;
    int year;


    public static List<Grant> Fielder(List<String[]> list,List<Business> businessList){
        List<Grant> grants = new ArrayList<>();
        Grant grant = new Grant();
        Iterator<String[]> iter = list.iterator();
        Iterator<Business> businessIter = businessList.iterator();

        while(iter.hasNext()) {
            String[] line = iter.next();
            if(!Objects.equals(line[0], "")) {
                Business business = businessIter.next();
                grant.name = line[0];
                grant.grantAmount = Double.parseDouble(line[2].replace("$", "").replace(",", ""));
                grant.year = Integer.parseInt(line[3]);
                grant.business = business;
                grants.add(grant);
                //System.out.println(grant.year);
            }
        }
        return grants;
    }
}
