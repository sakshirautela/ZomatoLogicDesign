import models.*;
import strategies.*;

public class Main {
    public static void main(String[] args) {
        // Create TomatoApp instance
        ZomatoApp tomatoApp = new ZomatoApp();

        // Simulate a user session (Happy Flow)
        User currentUser = new User(101, "Sakshi", "Noida");
        System.out.println("User: " + currentUser.getName() + " is active.");

        // User searches for restaurants by location
        java.util.List<Restaurant> availableRestaurants = tomatoApp.searchRestaurants("Delhi");

        if (availableRestaurants.isEmpty()) {
            System.out.println("No restaurants found!");
            return;
        }

        System.out.println("Found Restaurants:");
        for (Restaurant restaurant : availableRestaurants) {
            System.out.println(" - " + restaurant.getName());
        }

        // User selects the first restaurant
        Restaurant selectedRestaurant = availableRestaurants.get(0);
        tomatoApp.selectRestaurant(currentUser, selectedRestaurant);
        System.out.println("Selected restaurant: " + selectedRestaurant.getName());

        // User adds items to the cart
        tomatoApp.addToCart(currentUser, "P1");
        tomatoApp.addToCart(currentUser, "P2");

        // Print the current cart
        tomatoApp.printUserCart(currentUser);

        // User checks out the cart
        Order currentOrder = tomatoApp.checkoutNow(currentUser, "Delivery", new UpiPaymentStrategy("1234567890"));

        // User pays for the order
        tomatoApp.payForOrder(currentUser, currentOrder);
    }
}
