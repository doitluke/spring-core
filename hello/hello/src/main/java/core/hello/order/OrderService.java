package core.hello.order;

public interface OrderService {

    Order creteOrder(Long MemberId, String itemName, int itemPrice);
}
