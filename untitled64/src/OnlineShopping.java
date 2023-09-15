import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class OnlineShopping {

    public class WebUser {
        private String login_id;
        private String password;
        private ShoppingCart pastShoppingCart;
        private UserState state;

        enum UserState {
            New, Active, Blocked, Banned;
        }

        public WebUser(String login_id, String password, ShoppingCart pastShoppingCart, UserState state) {
            this.login_id = login_id;
            this.password = password;
            this.pastShoppingCart = pastShoppingCart;
            this.state = state;
        }

        public String getLogin_id() {
            return login_id;
        }

        public void setLogin_id(String login_id) {
            this.login_id = login_id;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public ShoppingCart getPastShoppingCart() {
            return pastShoppingCart;
        }

        public void setPastShoppingCart(ShoppingCart pastShoppingCart) {
            this.pastShoppingCart = pastShoppingCart;
        }
    }


    public class ShoppingCart {
        private String create;
        private String pastCustomer;
        private Set pastLineItem = new HashSet<>();

        public ShoppingCart(String create, String pastCustomer) {
            this.create = create;
            this.pastCustomer = pastCustomer;
        }


        public String getCreate() {
            return create;
        }

        public void setCreate(String create) {
            this.create = create;
        }

        public String getPastCustomer() {
            return pastCustomer;
        }

        public void setPastCustomer(String pastCustomer) {
            this.pastCustomer = pastCustomer;
        }

        public Set getLineItem() {
            return pastLineItem;
        }

        public void setLineItem(LineItem lineItem) {
            pastLineItem.add(lineItem);
        }

        public void deleteLimeItem(LineItem lineItem) {
            pastLineItem.remove(lineItem);
        }
    }


    public class Customer {
        private String id;
        private String address;
        private String phone;
        private String email;
        private Account pastAccount;

        public Customer(String id, String address, String phone, String email, Account account) {
            this.id = id;
            this.address = address;
            this.phone = phone;
            this.email = email;
            this.pastAccount = pastAccount;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Account getPastAccount() {
            return pastAccount;
        }

        public void setPastAccount(Account pastAccount) {
            this.pastAccount = pastAccount;
        }
    }

    public class Account {
        private String id;
        private Boolean is_closed;
        private String open;
        private String close;
        private Order pastOrder;
        private Set pastPayment = new HashSet();

        public Account(String id, String open, String close, Set pastPayment) {
            this.id = id;
            this.open = open;
            this.close = close;
            this.pastPayment = pastPayment;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Boolean getIs_closed() {
            return is_closed;
        }

        public void setIs_closed(Boolean is_closed) {
            this.is_closed = is_closed;
        }

        public String getOpen() {
            return open;
        }

        public void setOpen(String open) {
            this.open = open;
        }

        public String getClose() {
            return close;
        }

        public void setClose(String close) {
            this.close = close;
        }

        public Order getPastOrder() {
            return pastOrder;
        }

        public void setPastOrder(Order pastOrder) {
            this.pastOrder = pastOrder;
        }

        public Set getPayment() {
            return pastPayment;
        }

        public void setPayment(Payment payment) {
            pastPayment.add(payment);
        }

        public void delete(Payment payment) {
            pastPayment.remove(payment);
        }
    }

    public class Order {
        private String numder;
        private Date ordered;
        private Date shipped;
        private OrderStatus status;


        private Set pastLineItem = new HashSet<>();

        enum OrderStatus {
            New, Hold, Shipped, Delivered, Closed;
        }

        public Order(String numder, OrderStatus status, Set pastLineItem) {
            this.numder = numder;
            this.status = status;
            this.pastLineItem = pastLineItem;
        }

        public OrderStatus getStatus() {
            return status;
        }

        public void setStatus(OrderStatus status) {
            this.status = status;
        }

        public String getNumder() {
            return numder;
        }

        public void setNumder(String numder) {
            this.numder = numder;
        }

        public Date getOrdered() {
            return ordered;
        }

        public void setOrdered(Date ordered) {
            this.ordered = ordered;
        }

        public Date getShipped() {
            return shipped;
        }

        public void setShipped(Date shipped) {
            this.shipped = shipped;
        }

        public Set getLineItem() {
            return pastLineItem;
        }

        public void setLineItem(LineItem a) {
            pastLineItem.add(a);
        }

        public void deleteLineItem(LineItem a) {
            pastLineItem.remove(a);
        }
    }

    public static class LineItem {
        private Integer quantity;
        private Integer price;
        private Set pastProduct = new HashSet<>();

        public LineItem(Integer quantity, Integer price, Set product) {
            this.quantity = quantity;
            this.price = price;
            this.pastProduct = product;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Set getProduct() {
            return pastProduct;
        }

        public void setProduct(Product product) {
            pastProduct.add(product);
        }

        public void deleteProduct(Product product) {
            pastProduct.remove(product);
        }
    }

    public static class Product {
        private String id;
        private String name;
        private Supplier supplier;

        public Product(String id, String name, Supplier supplier) {
            this.id = id;
            this.name = name;
            this.supplier = supplier;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Supplier getSupplier() {
            return supplier;
        }

        public void setSupplier(Supplier supplier) {
            this.supplier = supplier;
        }
    }

    public class Payment {
        private String id;
        private String paid;
        private String details;

        public Payment(String id, String paid, String details) {
            this.id = id;
            this.paid = paid;
            this.details = details;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPaid() {
            return paid;
        }

        public void setPaid(String paid) {
            this.paid = paid;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }


}

