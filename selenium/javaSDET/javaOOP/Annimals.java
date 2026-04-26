package javaSDET.javaOOP;

public class Annimals {
    private String  annimalsName;
    protected int animalAge = 5;

    protected String getAnnimalsName(){ // Getter
        return annimalsName;
    }

    protected void setAnnimalsName(String annimalsName){ // Setter
        this.annimalsName = annimalsName;
    }
}
