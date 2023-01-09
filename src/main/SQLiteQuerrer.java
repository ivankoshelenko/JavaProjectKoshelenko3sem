package main;
import java.lang.reflect.Array;
import java.sql.*;
import java.util.*;

public class SQLiteQuerrer {
    public static void grantAmountQuery() throws ClassNotFoundException, SQLException {
        Connection co = null;
        try {
            Class.forName("org.sqlite.JDBC");
            co = DriverManager.getConnection("jdbc:sqlite:database.sqlite3");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String query = "select grantAmount from grants WHERE businessId in (select businessId from business WHERE businessName = 'Salon/Barbershop') ";
        Statement statement = co.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Double> idArray = new ArrayList<>();
        while (resultSet.next()) {
            idArray.add(( resultSet.getDouble(1)));
        }
        double sum = 0;
        for(double value: idArray){
            sum += value;
        }
        double average = sum / idArray.size();

        System.out.println(String.format("Средний размер гранта для бизнеса Salon/Barbershop %.2f",average));
    }
    public static void workersQuery() throws SQLException {
        Connection co = null;
        try {
            Class.forName("org.sqlite.JDBC");
            co = DriverManager.getConnection("jdbc:sqlite:database.sqlite3");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String query2= "select Sum(workers),businessName from business where businessId in ( select businessId from grants where  grantAmount <55000) Group By businessName";
        Statement statement = co.createStatement();
        ResultSet resultSet = statement.executeQuery(query2);
        HashMap<String,Integer> workers = new HashMap<>();
        while (resultSet.next()) {
            workers.put((resultSet.getString(2)),(resultSet.getInt(1)));
        }
        //Collection<Integer> values = workers.values();
        int max = 0;
        String business = "";
        for (String key : workers.keySet())
            if (workers.get(key) > max) {
                max = workers.get(key);
                business = key;
            }
        System.out.println("Наибольшее количество рабочих мест "+max + " в отрасли " + business);
    }
    public static List<Double> yearQuery() throws SQLException {
        Connection co = null;
        try {
            Class.forName("org.sqlite.JDBC");
            co = DriverManager.getConnection("jdbc:sqlite:database.sqlite3");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String yquery = "select year from grants group by year";
        Statement ystatement = co.createStatement();
        ResultSet yresultSet = ystatement.executeQuery(yquery);
        List<Integer> yearsArray = new ArrayList<>();
        while(yresultSet.next()){
            yearsArray.add(yresultSet.getInt(1));
        }
        List<Double> workersArray = new ArrayList<>();
        for(int year : yearsArray){
            String query3= " select avg(workers) from business where businessId in (select businessId from grants  where year = "+year+")";
            Statement statement = co.createStatement();
            ResultSet resultSet = statement.executeQuery(query3);
                workersArray.add(resultSet.getDouble(1));
        }
        return workersArray;
    }

}
