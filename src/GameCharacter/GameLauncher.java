package GameCharacter;

import java.io.*;

public class GameLauncher {
    public static void main(String[] args) {

        GameCharacter one = new GameCharacter(50, "Эльф", new String[]{"лук", "стрелы", "кастет"});
        GameCharacter two = new GameCharacter(200, "Троль", new String[]{"голые руки", "большой топор"});
        GameCharacter three = new GameCharacter(120, "Маг", new String[]{"заклинания", "невидимость"});

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/GameCharacter/Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        one = null;
        two = null;
        three = null;

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("src/GameCharacter/Game.ser"));
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();

            System.out.println(oneRestore.getType());
            System.out.println(twoRestore.getType());
            System.out.println(threeRestore.getType());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
