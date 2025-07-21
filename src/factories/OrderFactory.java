package factories;
import java.util.List;
import models.*;
        import strategies.*;

public interface OrderFactory  {

    /**
     * Creates an order for a given user, restaurant, and cart details.
     *
     * @param user             The user placing the order.
     * @param cart             The user's cart.
     * @param restaurant       The restaurant fulfilling the order.
     * @param menuItems        The list of menu items in the order.
     * @param paymentStrategy  The payment strategy to be used.
     * @param totalCost        The total cost of the order.
     * @param orderType        The type of the order (e.g., "Delivery", "Pickup").
     * @return                 A fully constructed Order object.
     */
    Order createOrder(User user,
                      Cart cart,
                      Restaurant restaurant,
                      List<MenuItem> menuItems,
                      PaymentStrategy paymentStrategy,
                      double totalCost,
                      String orderType);
}

