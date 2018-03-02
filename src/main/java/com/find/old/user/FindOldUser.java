package com.find.old.user;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FindOldUser {

    private List<User> users = new ArrayList<>();
    private String [] str;
    public List<User> parseText(String path) {

        File file = new File(path);

        BufferedReader bufRead = null;
        try {
            bufRead = new BufferedReader(new FileReader(file));
            String myLine = null;

            try {
                while ((myLine = bufRead.readLine()) != null) {
                    str = myLine.split(",");
                    users.add(new User(str[0],str[1], LocalDate.parse(str[2]),Integer.parseInt(str[3]),calculateAge(LocalDate.parse(str[2]))));

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


return users;
    }
    private Period calculateAge(LocalDate birthdate){

         return Period.between(birthdate, LocalDate.now()).normalized();
    }
    public User findOldestUser(){
        final Comparator<User> comp = (p1, p2) -> Integer.compare( p1.getAge().getDays(), p2.getAge().getDays());
        return  users.stream()
                .max(comp)
                .get();

    }
    public void display(){
        System.out.println("Number of Users: "
                + users.size()+ "\nOldest User: "
                + findOldestUser().getFirstName()
                +"\n"+findOldestUser().getLastName()
                +"\n"+findOldestUser().getAge().getYears()
                +"\n"+findOldestUser().getNumber());

    }
    public List<User> getUsers() {
        return users;
    }



}
