package javaSDET.dynamicLocator;

public class StringFormat {
    public  static void main(String[] args){
        String DELETE_ICON_BY_FEMALE = "//td[@class='abc' and text()='%s']";
        String DELETE_ICON_BY_FEMALE_COUNTRY = "//td[@class='abc' and text()='%s' and country='%s' and male='%s']";

        clickToDeleteIcon(DELETE_ICON_BY_FEMALE_COUNTRY, "VIETNAM", "12345", "male");
    }

//    public static void clickToDeleteIcon(String locator, String female){
//        System.out.println("Delete to icon :" + String.format(locator, female));
//    }
//
//    public static void clickToDeleteIcon(String locator, String country, String female){
//        System.out.println("Delete to icon :" + String.format(locator, country, female));
//    }

    public static void clickToDeleteIcon(String locator, String... restParameter){
        System.out.println("Delete to icon :" + String.format(locator, (Object[]) restParameter));
    }
}
