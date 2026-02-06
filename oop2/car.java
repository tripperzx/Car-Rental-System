public class Car {
    private String id;          // e.g., "CAR001"
    private String make;
    private String model;
    private int year;
    private double dailyRentalRate;
    private boolean available;

    public Car(String id, String make, String model, int year, double dailyRentalRate) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.dailyRentalRate = dailyRentalRate;
        this.available = true;
    }

    // Getters (encapsulation)
    public String getId() { return id; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getDailyRentalRate() { return dailyRentalRate; }
    public boolean isAvailable() { return available; }

    // Business methods
    public void rent() {
        if (!available) {
            throw new IllegalStateException("Car is already rented: " + id);
        }
        available = false;
    }

    public void returnCar() {
        if (available) {
            throw new IllegalStateException("Car is not rented: " + id);
        }
        available = true;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d) - $%.2f/day [%s]  ID:%s",
                make, model, year, dailyRentalRate, available ? "Available" : "Rented", id);
    }
}