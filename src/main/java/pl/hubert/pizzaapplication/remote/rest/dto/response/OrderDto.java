package pl.hubert.pizzaapplication.remote.rest.dto.response;

import pl.hubert.pizzaapplication.domain.model.OrderStatusType;
import pl.hubert.pizzaapplication.remote.rest.dto.request.PersonOrderDto;
import pl.hubert.pizzaapplication.remote.rest.dto.request.PizzaOrderDto;

public class OrderDto {

    private Integer id;
    private OrderStatusType status;
    private List<PizzaOrderDto> pizzas;
    private PersonOrderDto person;

    public OrderDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderStatusType getStatus() {
        return status;
    }

    public void setStatus(OrderStatusType status) {
        this.status = status;
    }

    public List<PizzaOrderDto> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<PizzaOrderDto> pizzas) {
        this.pizzas = pizzas;
    }

    public PersonOrderDto getPerson() {
        return person;
    }

    public void setPerson(PersonOrderDto person) {
        this.person = person;
    }
}
