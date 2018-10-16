/*
    6.7 The Apocalypse - In the new post-apocalyptic world, the new queen is concerned about birth rate, and decrees
    that every family must have a daughter. Assume that families continue having children until a daughter, at which
    point they stop. What is the gender proportion of the new world. Solve with probability, and then write a
    simulation.


*/

import java.util.Random;

public class Apocalypse{
    public static void main(String[] args){
        invokeApocalypse(100000);
    }

    public static void invokeApocalypse(int numberOfFamilies){
        int male = 0;
        int female = 0;
        Random random = new Random();
        for(int i = 0; i < numberOfFamilies; i++){
            int birthValue=1;
            while(birthValue%2!=0){
                birthValue = random.nextInt();
                if(birthValue%2==0)
                    female++;
                else
                    male++;
            }
        }
        System.out.println("Male: "+male);
        System.out.println("Female: "+female);
        System.out.println("Male-To-Female Ratio: "+(float)male/female);
    }

}