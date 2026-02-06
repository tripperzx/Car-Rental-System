import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Rental {
    private String rentalId;
    private Car car;
    private Customer customer;
    private LocalDate rentalDate;
    private LocalDate returnDate;   // null if not returned
    private double totalCost;

    public Rental(String rentalId, Car car, Customer customer, LocalDate rentalDate, int days) {
        this.rentalId = rentalId;
        this.car = car;
        this.customer = customer;
        this.rentalDate = rentalDate;
        this.returnDate = null;
        this.totalCost = car.getDailyRentalRate() * days;
        car.rent();
    }

    public void completeRental(LocalDate actualReturnDate) {
        if (returnDate != null) {
            throw new IllegalStateException("Rental already completed");
        }
        this.returnDate = actualReturnDate;
        car.returnCar();
    }

    public double getTotalCost() {
        return totalCost;
    }

    public boolean isActive() {
        return returnDate == null;
    }

    public String getRentalId() { return rentalId; }
    public Car getCar() { return car; }
    public Customer getCustomer() { return customer; }

    @Override
    public String toString() {
        String status = isActive() ? "Active" : "Completed on " + returnDate;
        return String.format("Rental %s | %s → %s | Cost: $%.2f | %s",
                rentalId, customer.getName(), car.toString(), totalCost, status);
    }
}