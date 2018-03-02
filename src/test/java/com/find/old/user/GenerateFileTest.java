package com.find.old.user;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;



public class GenerateFileTest {

    private final static String PATH ="src/main/resources/";
    private final static String NAME   = "file.txt";
    private GenerateFile generateFile = new GenerateFile(PATH,NAME);

    @Test
    public void testGetGeneratePhoneNumber() throws Exception {
        //Given //When
       int number = generateFile.getGeneratePhoneNumber();
        int length = (int)(Math.log10(number)+1);
        //Then
        Assert.assertEquals(8,length);
    }

    @Test
    public void testgenerateText() throws Exception {
        //When //Given
        generateFile.generateText();
        File deleteFile = new File(PATH+NAME);


        //Then
        Assert.assertTrue(deleteFile.delete());
    }


}