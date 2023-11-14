public class Space {
    private Treasure cache;

    private LivingThing Occupant;
    public Space(){
        setOccupant(null);
    }
    public Space(LivingThing l){
        setOccupant(l);
    }
    public Space(Treasure t){
        setCache(t);
    }

    public LivingThing getOccupant() {
        return Occupant;
    }

    public void setOccupant(LivingThing occupant) {
        Occupant = occupant;
    }
    public String GetConsoleStr(){
        if(getOccupant()==null){
            return " - ";
        }else{
            return getOccupant().getConsoleStr();
        }
    }

    public String GetConsoleStr(boolean reveal){
        if (reveal){
            if (getOccupant() != null){
                return getOccupant().getConsoleStr();

            } else if (getCache()!=null) {
                return getCache().GetConsole();
            }
        }else{
            if (getOccupant() != null && getOccupant() instanceof Explorer) {
                return getOccupant().getConsoleStr();
            }

        }
        return "-";
    }



    public Treasure getCache() {
        return cache;
    }

    public void setCache(Treasure cache) {
        this.cache = cache;
    }

}
