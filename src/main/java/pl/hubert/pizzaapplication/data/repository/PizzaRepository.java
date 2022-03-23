package pl.hubert.pizzaapplication.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hubert.pizzaapplication.data.entity.pizza.PizzaEntity;

public interface PizzaRepository extends JpaRepository<PizzaEntity, Integer> {

}
