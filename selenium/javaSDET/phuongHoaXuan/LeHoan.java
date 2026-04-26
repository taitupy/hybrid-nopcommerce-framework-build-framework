package javaSDET.phuongHoaXuan;

public class LeHoan {
    public static void main(String[] args){
        DinhBoLinh dinhBoLinh = new DinhBoLinh();
//        dinhBoLinh.espresso;
        dinhBoLinh.setEspresso("Cfe");
        System.out.println(dinhBoLinh.getEspresso());

        dinhBoLinh.cherry = "Cherry";
        System.out.println(dinhBoLinh.getCherry());

        dinhBoLinh.catimor = "Catimor";
        System.out.println(dinhBoLinh.getCatimor());
    }
}
