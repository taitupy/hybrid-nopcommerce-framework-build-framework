package factoryPattern;

import commons.CarList;

public class EndUser {
    public static CarFactory carFactory;

    public static void main(String[] args){
        // End user muon xem va lai xe Honda
        carFactory = getCar("Ford");
        carFactory.viewCar();
        carFactory.bookCar();
        carFactory.driveCar();
    }

    public static CarFactory getCar(String carName){
        CarFactory carFactory = null;
        CarList carList = CarList.valueOf(carName.toUpperCase());
        switch (carList){
            case HONDA:
                carFactory = new HondaHead();
                break;
            case FORD:
                carFactory = new FordHead();
                break;
            case HUYNDAI:
                carFactory = new HuyndaiHead();
                break;
            default:
                new RuntimeException("Car name is not valid.");
        }
        System.out.println(carFactory.toString());
        return carFactory;
    }
}
