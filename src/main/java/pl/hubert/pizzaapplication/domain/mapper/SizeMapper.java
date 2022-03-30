package pl.hubert.pizzaapplication.domain.mapper;

import org.springframework.stereotype.Component;
import pl.hubert.pizzaapplication.data.entity.size.SizeEntity;
import pl.hubert.pizzaapplication.domain.model.SizeType;
import pl.hubert.pizzaapplication.remote.rest.dto.request.AddSizeDto;
import pl.hubert.pizzaapplication.remote.rest.dto.response.SizeDto;

@Component
public class SizeMapper {

    public SizeEntity mapToSizeEntity(AddSizeDto addSizeDto, Integer pizzaId) {
        SizeEntity sizeEntity = new SizeEntity();
        sizeEntity.setSizeType(addSizeDto.getSize().name());
        sizeEntity.setPriceBase(addSizeDto.getPrice());
        sizeEntity.setPizzaId(pizzaId);
        return sizeEntity;

    }


    public SizeDto mapToSizeDto(SizeEntity sizeEntity) {
        SizeDto sizeDto = new SizeDto();
        SizeDto.setSize(SizeType.valueOf(sizeEntity.getSizeType()));
        sizeDto.setPrice(sizeEntity.getPriceBase());
        sizeDto.setId(sizeEntity.getId());
        return sizeDto;
    }

}
