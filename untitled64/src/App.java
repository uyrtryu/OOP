import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class App {
    public static void main(String[] args) {
       OnlineShopping onlineShopping = new OnlineShopping();
       OnlineShopping.ShoppingCart shoppingCart = onlineShopping.new ShoppingCart("12.12.3","12231" );
       OnlineShopping.WebUser webUser = onlineShopping.new WebUser("12", "12", shoppingCart, OnlineShopping.WebUser.UserState.New);
        System.out.println("Id WebUser: " + webUser.getLogin_id());
        Set set = new HashSet<>();
        OnlineShopping.Payment payment = onlineShopping.new Payment("132", "afasd","12");
        OnlineShopping.Account account = onlineShopping.new Account("14",  "8.00", "16.00", set);
        account.getPayment();
        OnlineShopping.Customer customer = onlineShopping.new Customer("13","org", "0987654321", "@com", account);

        Set shoping = new HashSet<>();
//        OnlineShopping.LineItem lineItem = new OnlineShopping.LineItem();
        OnlineShopping.Order order = onlineShopping.new Order("1232", OnlineShopping.Order.OrderStatus.New, shoping);

    }
}
