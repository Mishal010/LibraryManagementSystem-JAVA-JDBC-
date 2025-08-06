package com.library.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EnvLoader {
    public static void loader(String filePath){
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = reader.readLine())!=null){
                if(line.trim().isEmpty()||line.startsWith("#")) continue;
                String[] parts = line.split("=",2);
                if(parts.length == 2){
                    System.setProperty(parts[0],parts[1]);
                }
            }
        }catch(IOException e){
            System.out.println("Failed to load .env: "+e.getMessage());
        }
    }
}
