import java.util.ArrayList;

public class Healer extends LivingThing{

    private int healValue=0;
    private ArrayList<Treasure> TreasureList;
    public Healer(String Name, int Health, String Colour, int heal) {
        super(Name, Health, Colour);
        healValue = heal;

    }

    public int getHealValue() {
        return healValue;
    }

    public void Healing(LivingThing l){
        l.setHealth(l.getHealth()+healValue);
    }
}
