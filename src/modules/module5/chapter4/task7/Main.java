package modules.module5.chapter4.task7;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream b = new ByteArrayInputStream(new byte[]{1, 2, 4, 10});
        System.out.println(sumOfStream(b));;

    }

    public static int sumOfStream(InputStream inputStream) throws IOException {
        int result = 0;
        int buffer;
        while ((buffer = inputStream.read()) != -1) {
            result += (byte) buffer;
        }
        return result;
    }

}
