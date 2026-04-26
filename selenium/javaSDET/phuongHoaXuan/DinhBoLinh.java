package javaSDET.phuongHoaXuan;

public class DinhBoLinh {
    // co access modifier la Private thi chi dc phep sd trong class chua no

    // variable/ property
    private String espresso;

    // Getter/ Setter
    public void setEspresso(String espresso){
        this.espresso = espresso;
    }

    //Method/ Function
    public String getEspresso(){
        return espresso;
    }
    // Default : chi cho phep cac class trong cung package truy cap dc
    String cappuchino;

    String getCappuchino(){
        return cappuchino;
    }

    // Protected: chi cho phep ke thua moi sd dc
    protected String cherry;

    protected String getCherry(){
        return cherry;
    }

    public String catimor;

    public String getCatimor(){
        return catimor;
    }

    public static void main(String[] args){
        // Ham static ko the goi truc tiep den 1 bien non-static khac
        DinhBoLinh dinhBoLinh = new DinhBoLinh();
        dinhBoLinh.espresso = "Expresso";
        System.out.println(dinhBoLinh.getEspresso());

        dinhBoLinh.cappuchino = "Cappuchino";
        System.out.println(dinhBoLinh.getCappuchino());

        dinhBoLinh.cherry = "Cherry";
        System.out.println(dinhBoLinh.getCherry());

        dinhBoLinh.catimor = "Catimor";
        System.out.println(dinhBoLinh.getCatimor());
    }
}




