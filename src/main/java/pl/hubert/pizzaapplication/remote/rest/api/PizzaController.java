package pl.hubert.pizzaapplication.remote.rest.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.hubert.pizzaapplication.remote.rest.dto.request.AddOrderDto;
import pl.hubert.pizzaapplication.remote.rest.dto.request.AddPizzaDto;
import pl.hubert.pizzaapplication.remote.rest.dto.request.UpdateOrderDto;
import pl.hubert.pizzaapplication.remote.rest.dto.response.PizzaDto;
import pl.hubert.pizzaapplication.remote.rest.dto.response.TokenDto;

public class PizzaController {

    @PostMapping
    public ResponseEntity<PizzaDto> addPizza(@RequestBody AddPizzaDto addPizzaDto,
                                             @RequestHeader("Access-Token")String token){

        return ResponseEntity.ok(pizzaDto);

    }

    @PutMapping("/{id}")
    public ResponseEntity<PizzaDto> updatePizza(@RequestBody UpdatePizzaDto updatePizzaDto,
                                                @RequestHeader("Access-Token")String token,
                                                @PathVariable("id")Integer pizzaId{

        return ResponseEntity.ok(pizzaDto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable("id")Integer pizzaId,
                                            @RequestHeader("Access-Token")String token){
        return ResponseEntity.ok().build();
    }

}
