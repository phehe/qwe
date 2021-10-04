package hello.core2.order;

public interface OrderService {
    /**
     * @Author : ha
     * @ClassName : OrderService
     * @Date : 2021-10-04
     * @주문서비스 역할
    **/
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
