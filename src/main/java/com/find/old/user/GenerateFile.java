package com.find.old.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Random;

public class GenerateFile {
    private String path;
    private String name;
    private Random random = new Random();

    public GenerateFile(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public GenerateFile(){

    }
    public void generateText(){
        File file = new File(path+name);
        try {
            PrintWriter outputStream = new PrintWriter(file);
            for (int col = 0;col<10;col++){
                outputStream.println(getSaltString()+","+getSaltString()+","+getGenerateDate()+","+getGeneratePhoneNumber());

            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
   private String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();

        while (salt.length() < 30) { // length of the random string.
            int index = (int) (random.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
    private LocalDate getGenerateDate(){

        int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        return  LocalDate.ofEpochDay(randomDay);

    }

    public static void main(String[] args) {
        GenerateFile genarateFile = new GenerateFile();
    }
public  int getGeneratePhoneNumber(){
            return random.nextInt(79645428);
        }

}
