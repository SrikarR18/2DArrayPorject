import java.util.ArrayList;

public class Explorer extends LivingThing{
    private ArrayList<Treasure> TreasureList;

    public Explorer(String Name, int Health, String Colour) {
       super(Name,Health,Colour);
       TreasureList = new ArrayList<Treasure>();

    }

    public ArrayList<Treasure> getTreasureList() {
        return TreasureList;
    }
    public void AddTreasure(Treasure t){
        TreasureList.add(t);

    }
    public int getTreasureValue(){
        int NumOfTreasure = 0;
        for (Treasure t : TreasureList) {
            NumOfTreasure +=t.getValue();
        }
        return NumOfTreasure;
    }

}
