package CopyFiles;

import java.io.*;

public class CopyFiles {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Параметра должно быть 2!");
            System.exit(0);
        }

        FileInputStream fileIn = null;
        BufferedInputStream buff = null;

        FileOutputStream fileOut = null;
        BufferedOutputStream buffOut = null;

        try {
            fileIn = new FileInputStream(args[0]);
            buff = new BufferedInputStream(fileIn);

            fileOut = new FileOutputStream(args[1]);
            buffOut = new BufferedOutputStream(fileOut);

            while (true) {
                //прочитал файл
                int intValueOfByte = buff.read();

                if (intValueOfByte == -1) break;

                try {
                    buffOut.write(intValueOfByte);
                } catch (IOException e) {
                    System.out.println("Невозможно записать файл" + e.toString());
                }
            }

        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл" + e.toString());
        } finally {
            try {
                buff.close();
                fileIn.close();

                buffOut.flush();
                buffOut.close();
                fileOut.close();

            } catch (Exception e2) {
                e2.printStackTrace();
            }
            System.out.println("Чтение файла успешно завершено");
            System.out.println("Запись файла успешно завершена");
        }
    }
}
