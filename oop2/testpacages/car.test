package carrental system;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void testRentAndReturn() {
        Car car = new Car("CAR111", "Toyota", "Corolla", 2022, 50.0);
        assertTrue(car.isAvailable());
        
        car.rent();
        assertFalse(car.isAvailable());
        
        car.returnCar();
        assertTrue(car.isAvailable());
    }

    @Test
    void testRentAlreadyRentedCarThrowsException() {
        Car car = new Car("CAR222", "Honda", "Civic", 2021, 60.0);
        car.rent();
        
        Exception ex = assertThrows(IllegalStateException.class, car::rent);
        assertTrue(ex.getMessage().contains("already rented"));
    }
}