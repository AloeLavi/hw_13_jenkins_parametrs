package com.demoqa.utils;

import java.util.Random;

public class RandomUtils {

    public static String getRandomHobby(){
        String[]  hobbyArray = new String[] {"Sports", "Reading", "Music"};
        int  randomIndex = new Random().nextInt(hobbyArray.length);
        return hobbyArray[randomIndex];
    }

    public static String getRandomSubject(){
        String[]  subjArray = new String[] {"Maths", "Accounting", "Arts", "Social Studies", "Chemistry", "English"};
        int  randomIndex = new Random().nextInt(subjArray.length);
        return subjArray[randomIndex];
    }

    public static String getRandomMonth(){
        String[]  monthArray = new String[] {"January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"};
        int  randomIndex = new Random().nextInt(monthArray.length);
        return monthArray[randomIndex];
    }


}
