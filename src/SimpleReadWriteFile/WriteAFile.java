package SimpleReadWriteFile;

import java.io.FileWriter;
import java.io.IOException;

public class WriteAFile {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("src\\SimpleReadWriteFile\\files\\Foo.txt");
            writer.write("Дичь какая-то");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
