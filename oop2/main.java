public class Main {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();

        // Sample data
        agency.addCar(new Car("CAR001", "Toyota", "Corolla", 2022, 45.0));
        agency.addCar(new Car("CAR002", "Honda", "Civic", 2021, 50.0));
        agency.addCar(new Car("CAR003", "Ford", "Mustang", 2020, 120.0));

        Customer c1 = agency.registerCustomer("Juliet", "+254712345678", "juliet@example.com");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Car Rental System ===");
            System.out.println("1. View available cars");
            System.out.println("2. Rent a car");
            System.out.println("3. Return a car");
            System.out.println("4. View active rentals");
            System.out.println("5. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    agency.printAvailableCars();
                    break;
                case 2:
                    agency.printAvailableCars();
                    System.out.print("Enter car ID: ");
                    String carId = scanner.nextLine();
                    Car selected = null;
                    for (Car c : agency.getAvailableCars()) {
                        if (c.getId().equalsIgnoreCase(carId)) {
                            selected = c;
                            break;
                        }
                    }
                    if (selected == null) {
                        System.out.println("Invalid or unavailable car.");
                        break;
                    }
                    System.out.print("Enter number of days: ");
                    int days = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        Rental rental = agency.rentCar(selected, c1, days);
                        System.out.println("Rental successful! " + rental);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    agency.printActiveRentals();
                    System.out.print("Enter rental ID to return: ");
                    String rentalId = scanner.nextLine();
                    try {
                        agency.returnCar(rentalId);
                        System.out.println("Car returned successfully.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    agency.printActiveRentals();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
        System.out.println("Thank you for using the Car Rental System!");
    }
}