public class Treasure {
    private int value;
    private String description;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Treasure(int val, String desc){
        setDescription(desc);
        setValue(val);
    }
    public Treasure(){
        setDescription("gold");
        setValue(5);

    }
    public String GetConsole(){
        return (ConsoleColors.YELLOW + description.charAt(0)+ConsoleColors.RESET);

    }
}
