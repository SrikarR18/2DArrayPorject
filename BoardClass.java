import java.util.ArrayList;
import java.util.Random;

public class BoardClass {
    ArrayList<ArrayList<Space>> TwoDArr = new ArrayList<ArrayList<Space>>();
    ArrayList<Treasure> RemainingTreasures;



    ArrayList<Monster> MonstersList;

    public int Yposition= 0;
    public int Xposition= 0;
    public Explorer Gazoo = new Explorer("Gazoo",20,ConsoleColors.GREEN);

    private int r = 0;

    private int c = 0;
    public Random rand  = new Random();
    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
    public BoardClass(){
       this(10,10);
    }
    public BoardClass(int rows, int columns){
        RemainingTreasures = new ArrayList<Treasure>();
        TwoDArr = new ArrayList<>();
        this.setC(columns);
        this.setR(rows);
        for(int i = 0; i < rows; i++){
            ArrayList<Space> row = new ArrayList<>();
            for(int n = 0; n < columns; n++){
                    Space s = new Space();
                    row.add(s);
            }
            TwoDArr.add(row);
        }

        TwoDArr.get(Yposition).get(Xposition).setOccupant(new Space(Gazoo).getOccupant());
        AddTreasures(rows,columns);
        AddMonsters(rows,columns);
        AddHealer(rows, columns);


    }

    public void PrintBoard(boolean ShowContents) {

            for (int i = 0; i < TwoDArr.size(); i++)
            {

                for (int j = 0; j < TwoDArr.get(i).size(); j++)
                {
                    if(ShowContents) {
                        System.out.print((TwoDArr.get(i).get(j)).GetConsoleStr(true));
                    }else{
                        System.out.print((TwoDArr.get(i).get(j)).GetConsoleStr(false));
                    }
                }
                System.out.println();
            }


    }
    public boolean move(String m){


        m.trim().toLowerCase();
        if(m.equals("w")){

            if (Yposition==0){
                return false;
            }else{
                TwoDArr.get(Yposition).get(Xposition).setOccupant(null);
                checkForStuff(Yposition-1,Xposition);
                TwoDArr.get((Yposition-1)).get(Xposition).setOccupant((Gazoo));
                Yposition-=1;
                return true;
            }
        }else if(m.equals("a")){

            if (Xposition==0){
                System.out.println("Invalid Move");
                return false;

            }else{
                TwoDArr.get(Yposition).get(Xposition).setOccupant(null);
                checkForStuff(Yposition,Xposition-1);
                TwoDArr.get((Yposition)).get(Xposition-1).setOccupant((Gazoo));
                Xposition-=1;
                return true;
            }

        }else if(m.equals("s")){

            if (Yposition==(r-1)){
                System.out.println("Invalid Move");
                return false;

            }else{
                TwoDArr.get(Yposition).get(Xposition).setOccupant(null);
                checkForStuff(Yposition+1,Xposition);
                TwoDArr.get((Yposition+1)).get(Xposition).setOccupant((Gazoo));
                Yposition+=1;
                return true;
            }
        }else if(m.equals("d")){
            if (Yposition==(c-1)){
                System.out.println("Invalid Move");
                return false;
            }else{
                TwoDArr.get(Yposition).get(Xposition).setOccupant(null);
                checkForStuff(Yposition,Xposition+1);
                TwoDArr.get((Yposition)).get(Xposition+1).setOccupant((Gazoo));
                Xposition+=1;
                return true;
            }
        }else{
            return false;

        }
    }
    public void AddTreasures(int rows, int columns){
        // create 5 treasures and add them to list
        Treasure t0 = new Treasure();
        Treasure t1 = new Treasure();
        Treasure t2 = new Treasure();
        Treasure t3 = new Treasure();
        Treasure t4 = new Treasure();
        RemainingTreasures.add(t0);
        RemainingTreasures.add(t1);
        RemainingTreasures.add(t2);
        RemainingTreasures.add(t3);
        RemainingTreasures.add(t4);
        int RandRow;
        int RandCol;
        for (Treasure t: RemainingTreasures) {
            do{

                RandRow = rand.nextInt(0,rows-1);
                RandCol = rand.nextInt(0,columns-1);

            }while(TwoDArr.get(RandRow).get(RandCol).getOccupant() != null);

            TwoDArr.get(RandRow).get(RandCol).setCache(t);

        }
    }

    public void AddMonsters(int rows, int columns){
        MonstersList = new ArrayList<Monster>();

        Monster RazorClaw = new Monster("RazorClaw",3,ConsoleColors.RED,9);
        MonstersList.add(RazorClaw);

        Monster Gloomfury = new Monster("Gloomfury",3,ConsoleColors.RED,8);
        MonstersList.add(Gloomfury);

        Monster Fangsnarl = new Monster("Fangsnarl",3,ConsoleColors.RED,7);
        MonstersList.add(Fangsnarl);

        Monster Vilespike = new Monster("Vilespikw",3,ConsoleColors.RED,6);
        MonstersList.add(Vilespike);

        Monster Grimscowl = new Monster("Grimscowl",3,ConsoleColors.RED,5);
        MonstersList.add(Grimscowl);

        int RandRow;
        int RandCol;

        for (Monster m: MonstersList ) {
            do{

                RandRow = rand.nextInt(0,rows);
                RandCol = rand.nextInt(0,columns);

            }while(TwoDArr.get(RandRow).get(RandCol).getOccupant() != null);

            TwoDArr.get(RandRow).get(RandCol).setOccupant(m);

        }
    }
    public boolean GameOver(){
        if (Gazoo.getHealth()<0){
            System.out.println("Gazoo died");
            return true;
        }else if(RemainingTreasures.size()==0){
            System.out.println("Gazoo has collected all the treasure!!!");
            System.out.println("Gazoo wins!!");
            return true;
        }else{
            return false;
        }
    }
    public void AddHealer(int rows, int columns){
        int RandRow;
        int RandCol;
        Healer h = new Healer("healer",1,ConsoleColors.BLUE,5);
            do{

                RandRow = rand.nextInt(0,rows);
                RandCol = rand.nextInt(0,columns);

            }while((TwoDArr.get(RandRow).get(RandCol)).getOccupant() != null);

            TwoDArr.get(RandRow).get(RandCol).setOccupant(h);
        }
        
        public void checkForStuff(int YP, int XP){
            Treasure cache = TwoDArr.get(YP).get(XP).getCache();
            LivingThing occ = TwoDArr.get(YP).get(XP).getOccupant();
                    if(cache !=null) {
                        RemainingTreasures.remove(cache);
                        TwoDArr.get(YP).get(XP).setCache(null);


                        Gazoo.AddTreasure(cache);

                        System.out.println("TREASURE!!!");
                        System.out.println("Gazoo has a total treasure of "+Gazoo.getTreasureValue());


                    }else if(occ !=null) {
                        TwoDArr.get(YP).get(XP).setOccupant(null);
                        if (occ instanceof Monster){
                            Monster m = (Monster) occ;
                            m.Hurt(Gazoo);
                            System.out.println(Gazoo.getName()+" was attacked by "+ m.getName()+ " for "+m.getDamage()+ " damage!");
                            System.out.println("Gazoo has "+ Gazoo.getHealth()+ " Health Remaining");
                        }else if(occ instanceof Healer){
                            Healer h = (Healer) occ;
                            h.Healing(Gazoo);
                            System.out.println(Gazoo.getName()+" was healed by "+ h.getName()+ " for "+h.getHealValue()+ " health!");
                            System.out.println("Gazoo has "+ Gazoo.getHealth()+ " Health Remaining");
                        }
            }
        }
    }

