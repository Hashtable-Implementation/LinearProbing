package com.kamaldwip.coding.hashtable.collisions.linearprobing;

public class Main {

    public static void main(String[] args) {

        Employee kamal = new Employee("Kamaldwip","Chaudhury",585199);
        Employee kishore = new Employee("Kishore","Choudhury",687125);
        Employee prateek = new Employee("Prateek","Sahu",565312);
        Employee parag = new Employee("Parag","Roy",654123);
        Employee kaushik = new Employee("Kaushik","Talukdar",585192);
        Employee abhinav = new Employee("Abhinav","Borgohain",585192);

        ArrayHashtable ht = new ArrayHashtable();

        ht.put("Choudhury",kishore);
        ht.put("Chaudhury",kamal);
        ht.put("Sahu",prateek);
        ht.put("Roy",parag);
        ht.put("Talukdar",kaushik);
        ht.put("Borgohain",abhinav);

        ht.printHashtable();

        System.out.println("Retrieve value for Roy : "+ht.get("Roy"));

        System.out.println("Retrieve value for Chaudhury : "+ht.get("Chaudhury"));

        ht.remove("Roy");

        ht.printHashtable();

        ht.remove("Chaudhury");

        ht.printHashtable();

        System.out.println("Retrieve value for Borgohain : "+ht.get("Borgohain"));


    }
}
