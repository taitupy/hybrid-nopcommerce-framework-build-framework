package javaSDET.javaOOP;

public class Dog extends Annimals{
    public static void main(String[] args){
        Dog dog = new Dog();

        System.out.println(dog.animalAge);

        dog.setAnnimalsName("Huskey");
        System.out.println(dog.getAnnimalsName());
    }
}
