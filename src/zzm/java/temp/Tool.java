package zzm.java.temp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Tool {
    public static void main(String []args){
        File file = new File("E:\\programs\\java\\summary\\src\\zzm\\java\\temp\\1.txt");
        try {
            BufferedReader fbr= new BufferedReader(new FileReader(file));
            String buffer = null;
            while((buffer = fbr.readLine())!= null){
                String[] strings = buffer.split(",");
                System.out.println("1");
                Set<String> stringSet = Arrays.stream(strings).collect(Collectors.toSet());
                File fileTemp = new File("E:\\programs\\java\\summary\\src\\zzm\\java\\temp\\1.txt");
//                if(!fileTemp.exists()){
//                    fileTemp.createNewFile();
//                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
