package pl.hubert.pizzaapplication.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hubert.pizzaapplication.data.entity.size.SizeEntity;

public interface SizeRepository extends JpaRepository<SizeEntity, Integer>{

}
