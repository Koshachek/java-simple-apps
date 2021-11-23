package Serializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class DungeonTest {
    public static void main(String[] args) {
        DungeonGame dungeonGame = new DungeonGame();
        System.out.println(dungeonGame.getX() + dungeonGame.getY() + dungeonGame.getZ());
        try {
            FileOutputStream fos = new FileOutputStream("src\\Serializable\\dg.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dungeonGame);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
