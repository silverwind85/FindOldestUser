package com.find.old.user;

import javafx.beans.binding.When;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.Assert.*;

public class FindOldUserTest {

    private final static String PATH ="src/main/resources/";
    private final static String NAME   = "file.txt";
    private GenerateFile generateFile = new GenerateFile(PATH,NAME);
    private FindOldUser findOldUser = new FindOldUser();

    @Test
    public void parseText() throws Exception {
        //Give
        generateFile.generateText();
        //When
        findOldUser.parseText(PATH+NAME);
    }
    @Test
    public void findOldestUser(){
        //Given When
        findOldUser.parseText(PATH+NAME);
        User result = findOldUser.findOldestUser();
        findOldUser.display();
        //Then
        Assert.assertEquals(Period.between(LocalDate.of(1907,03,03),LocalDate.now()),result.getAge());


    }

}