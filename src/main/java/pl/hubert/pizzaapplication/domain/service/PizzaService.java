package pl.hubert.pizzaapplication.domain.service;


import org.springframework.stereotype.Service;
import pl.hubert.pizzaapplication.data.entity.pizza.PizzaEntity;
import pl.hubert.pizzaapplication.data.repository.PizzaRepository;
import pl.hubert.pizzaapplication.domain.mapper.PizzaMapper;
import pl.hubert.pizzaapplication.remote.rest.dto.request.AddPizzaDto;
import pl.hubert.pizzaapplication.remote.rest.dto.response.PizzaDto;

import static pl.hubert.pizzaapplication.domain.service.AuthorizationService.checkToken;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;
    private final PizzaMapper pizzaMapper;


    public PizzaService(PizzaRepository pizzaRepository, PizzaMapper pizzaMapper) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaMapper = pizzaMapper;
    }


    public PizzaDto addPizza(AddPizzaDto addPizzaDto, String token) {

        //AuthorizationService.checkToken(token);
        checkToken(token);
        //if(token == null || token.equals("xzv")) {
           // throw new UnauthorizedException("Błędny token");
       // }

        //PizzaEntity pizzaEntity = pizzaMapper.mapToPizzaEntity(addPizzaDto);
        pizzaRepository.save(pizzaMapper.mapToPizzaEntity(addPizzaDto));

        /* PizzaEntity pizzaEntity = new PizzaEntity();
        pizzaEntity.setName(addPizzaDto.getName());
        PizzaEntity savedPizzaEntity = pizzaRepository.save(pizzaEntity);
        */


    }

}
