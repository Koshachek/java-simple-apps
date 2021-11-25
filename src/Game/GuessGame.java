package Game;

public class GuessGame {
    Player p1;
    Player p2;
    Player p3;

    public void startGame(){
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        int guessp1 = 0;
        int guessp2 = 0;
        int guessp3 = 0;

        boolean p1isRight = false;
        boolean p2isRight = false;
        boolean p3isRight = false;

        int targetNubmer = (int)(Math.random() * 10);
        System.out.println("Ya zagadal chislo ot 0 do 9...");

        while(true){
            System.out.println("Chislo kotoroe nujno ugadat " + targetNubmer);

            p1.guess();
            p2.guess();
            p3.guess();

            guessp1 = p1.number;
            System.out.println("PERVIY dumaet chto eto chislo - " + guessp1);

            guessp2 = p2.number;
            System.out.println("VTOROY dumaet chto eto chislo - " + guessp2);

            guessp3 = p3.number;
            System.out.println("TRETIY dumaet chto eto chislo - " + guessp3);

            if(guessp1 == targetNubmer){
                p1isRight = true;
            }

            if(guessp2 == targetNubmer){
                p2isRight = true;
            }

            if(guessp3 == targetNubmer){
                p3isRight = true;
            }

            if(p1isRight || p2isRight || p3isRight){
                System.out.println("U nas est pobeditel!!!");
                System.out.println("PERVIY igrok ugadal? - " + p1isRight);
                System.out.println("VTOROY igrok ugadal? - " + p2isRight);
                System.out.println("TRETIY igrok ugadal? - " + p3isRight);
                System.out.println("GAME OVER");
                break;
            }
            else{
                System.out.println("Igrokam stoit poprobovat escho raz...");
            }
        }
    }
}
