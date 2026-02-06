import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<Car> cars = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Rental> rentals = new ArrayList<>();
    private int rentalCounter = 1;
    private int customerCounter = 1;

    // Car management
    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getAvailableCars() {
        List<Car> available = new ArrayList<>();
        for (Car c : cars) {
            if (c.isAvailable()) available.add(c);
        }
        return available;
    }

    // Customer management
    public Customer registerCustomer(String name, String phone, String email) {
        String id = String.format("CUST%03d", customerCounter++);
        Customer cust = new Customer(id, name, phone, email);
        customers.add(cust);
        return cust;
    }

    public Customer findCustomer(String id) {
        for (Customer c : customers) {
            if (c.getId().equals(id)) return c;
        }
        return null;
    }

    // Rental operations
    public Rental rentCar(Car car, Customer customer, int days) {
        if (!car.isAvailable()) {
            throw new IllegalArgumentException("Car not available");
        }
        String rentalId = String.format("RENT%03d", rentalCounter++);
        Rental rental = new Rental(rentalId, car, customer, LocalDate.now(), days);
        rentals.add(rental);
        return rental;
    }

    public void returnCar(String rentalId) {
        for (Rental r : rentals) {
            if (r.getRentalId().equals(rentalId) && r.isActive()) {
                r.completeRental(LocalDate.now());
                return;
            }
        }
        throw new IllegalArgumentException("Rental not found or already completed: " + rentalId);
    }

    public List<Rental> getActiveRentals() {
        List<Rental> active = new ArrayList<>();
        for (Rental r : rentals) {
            if (r.isActive()) active.add(r);
        }
        return active;
    }

    // For reporting / display
    public void printAvailableCars() {
        System.out.println("\nAvailable Cars:");
        for (Car c : getAvailableCars()) {
            System.out.println("  " + c);
        }
    }

    public void printActiveRentals() {
        System.out.println("\nActive Rentals:");
        for (Rental r : getActiveRentals()) {
            System.out.println("  " + r);
        }
    }
}