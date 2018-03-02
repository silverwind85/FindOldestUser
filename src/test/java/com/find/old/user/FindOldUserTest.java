package com.find.old.user;

import javafx.beans.binding.When;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.Period;

import static org.junit.Assert.*;

public class FindOldUserTest {

    private final static String PATH ="src/main/resources/";
    private final static String NAME   = "file.txt";
    private final static String NAME_TEST   = "fileTest.txt";
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
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("src/main/resources/fileTest.txt", "UTF-8");
            writer.print("NEJSUTVJEZAFZSWKLYRRNLOUFNBFTE,GKOFFPUXWLAZDLJLANBCNPVIIYDOFR,1976-06-14,10913175\n" +
                    "PUFOTIDBWSSDKNMLXJGZGYRGCYOJLO,SOFVQAKGABDCUXJNYYWLONVLBTGHNS,1968-04-15,8534220\n" +
                    "BAXZIRPEQNPZKWDBMCBIFEYPQUGMKU,GGGXPLHLMICMFOYZAYJXJPLFUBSTTC,1984-03-28,66025616\n" +
                    "QYGJECYAOYVYWFBWLYKHRSPGORZFQW,PTADBVSNFIMCELSLLXHCTCUYMHBJWJ,1949-06-04,45988245\n" +
                    "BMOYNOLOLMYVZQZSCSBFJMVFXEZVSV,ETONGTTQTVPVTOYJDTVFUTZXLQCSGK,1953-05-27,3495762\n" +
                    "UFZNISVFRNUDGNCAVXUTEZYIPIUCAM,LUSEMRLZRTUTQMRHFGCYQYTKEYQIOD,2011-05-24,36217438\n" +
                    "GOULGMDFKSJXBWXSEUBRVPOPDNRCRK,SQYBZGQUUXYAZBVLDTDYGHZFGYZZRM,1907-03-03,2218176\n" +
                    "TNIKTTADQXAILLVRERZZGOWSCFXIBQ,OUICIRPCWXOVOWBHUHEEKHBHIUUWEK,1925-09-02,70279348\n" +
                    "RHBPUWWYSUGRBVKEXULBDLPJSHCFQT,AZEPHAJIOFGNEHXXFFWWRMAWCMMGBF,1972-11-18,20483354");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //Given When
        findOldUser.parseText(PATH+NAME_TEST);
        User result = findOldUser.findOldestUser();
        findOldUser.display();
        //Then
        Assert.assertEquals(Period.between(LocalDate.of(1907,03,03),LocalDate.now()),result.getAge());


    }

}