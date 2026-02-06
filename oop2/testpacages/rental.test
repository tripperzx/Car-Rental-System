package carrental system;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

class RentalTest {

    @Test
    void testRentalCostCalculation() {
        Car car = new Car("CAR333", "BMW", "X5", 2020, 150.0);
        Customer cust = new Customer("CUST999", "Test", "0711", "test@mail.com");
        
        Rental rental = new Rental("RENT001", car, cust, LocalDate.now(), 7);
        assertEquals(1050.0, rental.getTotalCost(), 0.001);
    }
}