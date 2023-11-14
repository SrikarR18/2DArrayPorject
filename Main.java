import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BoardClass b1 = new BoardClass(10,10);
        String userIn ;
        boolean reveal = false;
        do{
            b1.PrintBoard(reveal);
            System.out.println("Use W,A,S,D to move. Use R to reveal board. Use I to see number of treasures collected");
            Scanner s = new Scanner(System.in);
             userIn = s.nextLine().toLowerCase().trim();
             if (!b1.move(userIn)){
                 if (userIn.equals("r")){
                     reveal = !reveal;
                 }else if(userIn.equals("i")){
                     System.out.println("Gazoo has found "+b1.Gazoo.getTreasureList().size()+" treasures for a value of "+b1.Gazoo.getTreasureValue());
                 }else {
                     System.out.println("Invalid Input");
                 }
             };
    }while ((!b1.GameOver()));

    }
}
