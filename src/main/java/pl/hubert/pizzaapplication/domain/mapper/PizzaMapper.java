package pl.hubert.pizzaapplication.domain.mapper;

import org.springframework.stereotype.Component;
import pl.hubert.pizzaapplication.data.entity.pizza.PizzaEntity;
import pl.hubert.pizzaapplication.remote.rest.dto.request.AddPizzaDto;

@Component
public class PizzaMapper {

    public PizzaEntity mapToPizzaEntity(AddPizzaDto addPizzaDto) {
        PizzaEntity pizzaEntity = new PizzaEntity();
        pizzaEntity.setName(addPizzaDto.getName());
        return pizzaEntity;
    }

}
