package ByteReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteReader {

    public static void main(String[] args) {
        // Начала отсчета
        long start = System.currentTimeMillis();

        FileInputStream myFile = null;
        FileOutputStream myFileTwo = null;

        try {
            myFile = new FileInputStream("src\\ByteReader\\files\\777.jpg");
            myFileTwo = new FileOutputStream("src\\ByteReader\\files\\777.dat");

            while (true) {
                int intValueOfByte = myFile.read();
                System.out.println(" " + intValueOfByte);

                try {
                    myFileTwo.write(intValueOfByte);
                } catch (IOException e) {
                    System.out.println("Невозможно записать файл" + e.toString());
                }

                if (intValueOfByte == -1) break;
            }
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл" + e.toString());
        } finally {
            try {
                myFile.close();
                myFileTwo.close();
                System.out.println("Чтение файла успешно завершено");
                System.out.println("Запись файла успешно завершена");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        long timeWorkCode = System.currentTimeMillis() - start;
        System.out.println("Скорость выполнения программы: " + timeWorkCode + " миллисекунд или " + timeWorkCode / 1000 + " секунд");
    }

}