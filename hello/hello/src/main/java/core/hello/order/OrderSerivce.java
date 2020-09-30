package core.hello.order;

public interface OrderSerivce {

    Order creteOrder(Long MemberId, String itemName, int itemPrice);
}
