/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.generatorofpassword;
import java.util.Random;
/**
 *
 * @author caleb
 */
public class Password {
    

    
    int length;
    String password;

    public Password() {
        this.length = 8; // Por defecto, la longitud sera de 8.
    }

    public Password(int length) {
        this.length = length;
    }
    
    public boolean isStrong(){
       boolean isStrong = false;
       final int minCharacter = 11;
       int countLetter= 0;
       int countLetterUp = 0;
       int countNumbers = 0;
      
       int size = this.password.length();
        if (size >= minCharacter) {
            for (int i = 0; i < size; i++) {
                 char character = this.password.charAt(i);
                if(Character.isDigit(character)){
                    countNumbers += 1;
                }
                else if(Character.isUpperCase(character)){
                    countLetterUp +=1;
                }
                else if(Character.isLowerCase(character)){
                    countLetter +=1;
                }
            }
            
            if( (countLetter > 1) & (countLetterUp > 2) & (countNumbers > 5) ){ //devuelve un booleano si es fuerte o no, para que sea fuerte debe tener mas de 2 mayúsculas, mas de 1 minúscula y mas de 5 números.
                isStrong = true;
            } 
        }

       return isStrong;
    }
    
    public String generatorPassword(){
       final  char characterNO[] ={':',';','<','>','=','?','@','[',']','^','_','`','¿','{','}','~'};
       String password = "";
       boolean value = true;
       Random random = new Random();
       int numbeRandom;
       char c;
        for (int i = 0; i < this.length; i++) {
             numbeRandom = (random.nextInt(122)+48);
             System.out.println(numbeRandom);
             c = (char) numbeRandom;
            System.out.println("i ="+i+"   "+c);
            for (char d : characterNO) {
                System.out.println("valor c y d "+c+" "+d);
                if(c==d){
                    i = i-1;
                    value = false;
                    System.out.println(value);
                    break;
                }
            }

            if(value){
                password += c;
            }
            value = true;
        }

       return password;
    }
}   
