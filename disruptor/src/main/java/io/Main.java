package io;

import java.io.*;

public class Main {
    final static int num  = 4000000;
    public static void main(String[] args) throws IOException {
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream(new File("C:/Users/64363/Desktop/temp/11.tmp"))
        ));
        for (int i = 0;i < num; i++) {
            dos.writeInt(i);
        }
        if(null != dos){
            dos.close();
        }

        DataInputStream dis = new DataInputStream(new BufferedInputStream(
                new FileInputStream(new File("C:/Users/64363/Desktop/temp/11.tmp"))));
        for (int i = 0;i<num;i++) {
            dis.readInt();
        }
        if(null != dis){
            dis.close();
        }
    }
}
