package com.kamaldwip.coding.hashtable.collisions.linearprobing;

public class ArrayHashtable {

    private StoredEmployee[] hashtable;

    public ArrayHashtable(){
        hashtable = new StoredEmployee[10];
    }

    private int hashKey(String key){
        return key.length()%hashtable.length;
    }

    private boolean occupied(int hashedKey){
        return hashtable[hashedKey]!= null;
    }

    public void put(String key, Employee employee){
        int hashedKey = hashKey(key);
        if(occupied(hashedKey)){
            int stopIndex = hashedKey;
            if(hashedKey == (hashtable.length - 1)){
                hashedKey = 0;
            }
            else {
                hashedKey++;
            }
            while (occupied(hashedKey) && hashedKey!=stopIndex){
                hashedKey = (hashedKey + 1)% hashtable.length;
            }

        }


        if(occupied(hashedKey)){
            System.out.println("Sorry, can't add ! An item already exists at "+hashedKey);
        } else{
            hashtable[hashedKey] = new StoredEmployee(key,employee);
        }

    }

    public Employee get(String key){
        int hashedKey = findKey(key);
        if(hashedKey == -1){
            return null;
        } else {
            return hashtable[hashedKey].getEmployee();
        }
    }

    public Employee remove(String key){
        int hashedKey = findKey(key);
        if(hashedKey == -1){
            return null;
        } else {
            Employee employee = hashtable[hashedKey].getEmployee();
            hashtable[hashedKey] = null;
            StoredEmployee[] oldHashtable = hashtable;
            hashtable = new StoredEmployee[oldHashtable.length];
            for(int i = 0; i < oldHashtable.length;i++){
                if(oldHashtable[i]!=null) {
                    put(oldHashtable[i].getKey(), oldHashtable[i].getEmployee());
                }
            }
            return employee;
        }

    }

    public int findKey(String key){
        int hashedKey = hashKey(key);
        if(hashtable[hashedKey]!= null &&
            hashtable[hashedKey].getKey().equals(key)){
            return hashedKey;
        }
        int stopIndex = hashedKey;
        if(hashedKey == (hashtable.length - 1)){
            hashedKey = 0;
        }
        else {
            hashedKey++;
        }

        while (hashtable[hashedKey]!= null
                && hashedKey!= stopIndex
                && !(hashtable[hashedKey].getKey().equals(key))){
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if(hashtable[hashedKey]!= null
            && hashtable[hashedKey].getKey().equals(key)){
            return hashedKey;
        }
        else {
            return -1;
        }

    }

    public void printHashtable(){
        for(int i = 0; i < hashtable.length; i++){
            if(hashtable[i] == null){
                System.out.println("Empty");
            } else {
                System.out.println(hashtable[i].getEmployee());
            }
        }
    }


}
