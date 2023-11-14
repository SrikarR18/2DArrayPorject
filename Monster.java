public class Monster extends LivingThing{
    private int Damage =0;

    public Monster(String Name, int Health, String Colour, int dmg) {
        super(Name, Health, Colour);
        Damage = dmg;

    }
    public void Hurt(LivingThing l){
        l.setHealth(l.getHealth()-Damage);
    }

    public int getDamage() {
        return Damage;
    }



}
