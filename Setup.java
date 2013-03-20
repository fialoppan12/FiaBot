package fiaBot;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
 
public class Setup {
 
       
        public static ArrayList<String> lasin() {
        //LÄSA FILER
               
        File tavlare = new File("C:\\Users\\Fias_Lap\\workspace\\fiaBot\\src\\input.txt");
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
        ArrayList<String> list = new ArrayList<String>();
       
        try {
 
        fis = new FileInputStream(tavlare);
        bis = new BufferedInputStream(fis);
        dis= new DataInputStream(fis);
        BufferedReader br = new BufferedReader(new InputStreamReader(dis));
        String line;
       
        while((line=br.readLine())!=null) {
                String s = line.toString();
                list.add(s);
               
                }
                fis.close();
                bis.close();
                dis.close();
               
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                } catch (IOException e) {
                        e.printStackTrace();
                }      
        return list;
        }
       
        public static ArrayList<String> pokemonIChooseYou() {
        //LÄSA FILER
               
        File tavlare = new File("C:\\Users\\Fias_Lap\\workspace\\fiaBot\\src\\hasBirds.txt");
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
        ArrayList<String> list = new ArrayList<String>();
 
        try {
 
        fis = new FileInputStream(tavlare);
        bis = new BufferedInputStream(fis);
        dis= new DataInputStream(fis);
        BufferedReader br = new BufferedReader(new InputStreamReader(dis));
        String line;
        String singleBird="";
       
        while((line=br.readLine())!=null) {
                String s = line.toString();
                for (String bird : readBirds()) {
                        list.add(s+" "+bird);
                        singleBird=bird;
                }
                list.add(singleBird+" "+s);
                list.add(s);
               
                }
                fis.close();
                bis.close();
                dis.close();
               
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        return list;
       
        }
       
       
        public static ArrayList<String> readBirds() {
        //LÄSA FILER
               
        File ord = new File("C:\\Users\\Fias_Lap\\workspace\\fiaBot\\src\\birds.txt");
 
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
        ArrayList<String> list = new ArrayList<String>();
       
       
        try {
 
        fis = new FileInputStream(ord);
        bis = new BufferedInputStream(fis);
        dis= new DataInputStream(fis);
        BufferedReader br = new BufferedReader(new InputStreamReader(dis));
        String line;
       
        while((line=br.readLine())!=null) {
                String s = line.toString();
                list.add(s);
                }
       
                fis.close();
                bis.close();
                dis.close();
               
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        return list;
        }
       
       
}

