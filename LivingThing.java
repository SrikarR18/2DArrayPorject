public class LivingThing {
    private String name;
    private int health;
    private String pieceColor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String TrimmedName = name.trim();
        if (TrimmedName.isEmpty()){
            this.name = "undefined";
        }else{
            this.name = name;
        }
    }

    public int getHealth() {
        return health;
    }
    public String getConsoleStr(){
        return(getPieceColor()+getName().charAt(0)+ConsoleColors.RESET);
    }


    public void setHealth(int health) {

          this.health = health;
        }


    public String getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(String pieceColor) {
        this.pieceColor = pieceColor;
    }
    public LivingThing(String Name, int Health){
        setName(Name);
        setHealth(Health);
        setPieceColor(ConsoleColors.YELLOW);
    }
    public LivingThing(String Name, int Health, String Colour){
        setName(Name);
        setHealth(Health);
        setPieceColor(Colour);
    }

}
