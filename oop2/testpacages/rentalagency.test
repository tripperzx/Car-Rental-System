package carrental system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

class RentalAgencyTest {

    private RentalAgency agency;
    private Car car1;
    private Customer customer1;

    @BeforeEach
    void setUp() {
        agency = new RentalAgency();
        
        car1 = new Car("CAR999", "TestMake", "TestModel", 2023, 80.0);
        agency.addCar(car1);
        
        customer1 = agency.registerCustomer("Test User", "0712345678", "test@example.com");
    }

    @Test
    void testAddCarAndGetAvailableCars() {
        assertEquals(1, agency.getAvailableCars().size());
        assertTrue(agency.getAvailableCars().contains(car1));
    }

    @Test
    void testRegisterCustomer() {
        Customer c2 = agency.registerCustomer("Jane Doe", "0723456789", "jane@example.com");
        assertNotNull(c2);
        assertEquals("CUST002", c2.getId());   // assuming counter starts at 1
        assertEquals(2, agency.findCustomer("CUST002") != null ? 1 : 0);
    }

    @Test
    void testRentCarSuccess() {
        Rental rental = agency.rentCar(car1, customer1, 5);
        
        assertNotNull(rental);
        assertFalse(car1.isAvailable());
        assertEquals(400.0, rental.getTotalCost(), 0.001);  // 80 * 5
        assertTrue(rental.isActive());
        assertEquals(1, agency.getActiveRentals().size());
    }

    @Test
    void testRentUnavailableCarThrowsException() {
        agency.rentCar(car1, customer1, 3);  // rent first
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            agency.rentCar(car1, customer1, 2);
        });
        assertEquals("Car not available", exception.getMessage());
    }

    @Test
    void testReturnCarSuccess() {
        Rental rental = agency.rentCar(car1, customer1, 4);
        assertFalse(car1.isAvailable());
        
        agency.returnCar(rental.getRentalId());
        assertTrue(car1.isAvailable());
        assertFalse(rental.isActive());
    }

    @Test
    void testReturnNonExistentRentalThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            agency.returnCar("RENT999");
        });
        assertTrue(exception.getMessage().contains("not found"));
    }
}