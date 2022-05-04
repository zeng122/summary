package zzm.java.File;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class InsertFile {
    public static void main(String[] args) throws FileNotFoundException {

        InsertFile insertFile = new InsertFile();
        insertFile.fun1();
//        File file = new File("E://1.txt");
//        OutputStream outputStream = new FileOutputStream(file);
//        OutputStreamWriter writer=new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
//
//        try {
//            writer.write("1111");
//            writer.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }



    public void fun1(){
        File file1 = new File("C:\\Users\\13429\\Desktop\\1.xlsx");
        File file2 = new File("C:\\Users\\13429\\Desktop\\222.xlsx");
        try {
            InputStream inputStream = new FileInputStream(file1);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            OutputStream os = new FileOutputStream(file2);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            byte[] buff = new byte[1024];

            //int i = bufferedInputStream.read(buff);

            int length = 0;
            while ((length = bufferedInputStream.read(buff)) != -1) {
                bos.write(buff, 0, length);
            }
            bos.flush();
            os.close();
            bos.close();
            inputStream.close();
//            while (i != -1) {
//                os.write(buff, 0, buff.length);
//                os.flush();
//                i = bufferedInputStream.read(buff);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
