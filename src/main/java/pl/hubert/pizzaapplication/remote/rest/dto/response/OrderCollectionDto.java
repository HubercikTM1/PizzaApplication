package pl.hubert.pizzaapplication.remote.rest.dto.response;

public class OrderCollectionDto {

    private List<OrderDto> orders;

    public OrderCollectionDto() {
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDto> orders) {
        this.orders = orders;
    }
}
