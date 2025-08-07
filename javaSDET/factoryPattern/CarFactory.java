package factoryPattern;

public abstract class CarFactory {
    // Ham abstract (co ten ham/ chua co phan than)
    // Nhung class ma ke thua no se can implement lai
    // Khung de cho ca class khac follow theo dung structure/ bussiness
    public abstract  void viewCar();

    public abstract  void bookCar();

    public abstract  void driveCar();

}
