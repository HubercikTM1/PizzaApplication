package pl.hubert.pizzaapplication.remote.rest.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.hubert.pizzaapplication.domain.service.PizzaService;
import pl.hubert.pizzaapplication.remote.rest.dto.request.AddOrderDto;
import pl.hubert.pizzaapplication.remote.rest.dto.request.AddPizzaDto;
import pl.hubert.pizzaapplication.remote.rest.dto.request.UpdateOrderDto;
import pl.hubert.pizzaapplication.remote.rest.dto.request.UpdatePizzaDto;
import pl.hubert.pizzaapplication.remote.rest.dto.response.PizzaDto;
import pl.hubert.pizzaapplication.remote.rest.dto.response.TokenDto;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = "/api/v1/pizzas", produces = APPLICATION_JSON_VALUE)
@RestController

public class PizzaController {

    private final PizzaService pizzaService;


    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }


    @PostMapping
    public ResponseEntity<PizzaDto> addPizza(@RequestBody AddPizzaDto addPizzaDto,
                                             @RequestHeader("Access-Token")String token){

        PizzaDto pizzaDto = pizzaService.addPizza(addPizzaDto, token);
        return ResponseEntity.ok(pizzaDto);

    }

    @PutMapping("/{id}")
    public ResponseEntity<PizzaDto> updatePizza(@RequestBody UpdatePizzaDto updatePizzaDto,
                                                @RequestHeader("Access-Token")String token,
                                                @PathVariable("id")Integer pizzaId){

        return ResponseEntity.ok(null);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable("id")Integer pizzaId,
                                            @RequestHeader("Access-Token")String token){
        return ResponseEntity.ok().build();
    }

}
