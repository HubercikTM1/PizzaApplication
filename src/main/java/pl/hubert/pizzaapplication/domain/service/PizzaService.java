package pl.hubert.pizzaapplication.domain.service;


import org.springframework.stereotype.Service;
import pl.hubert.pizzaapplication.data.entity.pizza.PizzaEntity;
import pl.hubert.pizzaapplication.data.entity.size.SizeEntity;
import pl.hubert.pizzaapplication.data.repository.PizzaRepository;
import pl.hubert.pizzaapplication.data.repository.SizeRepository;
import pl.hubert.pizzaapplication.domain.mapper.PizzaMapper;
import pl.hubert.pizzaapplication.domain.mapper.SizeMapper;
import pl.hubert.pizzaapplication.domain.model.SizeType;
import pl.hubert.pizzaapplication.remote.rest.dto.request.AddPizzaDto;
import pl.hubert.pizzaapplication.remote.rest.dto.request.AddSizeDto;
import pl.hubert.pizzaapplication.remote.rest.dto.response.PizzaDto;
import pl.hubert.pizzaapplication.remote.rest.dto.response.SizeDto;

import java.util.stream.Collectors;

import static pl.hubert.pizzaapplication.domain.service.AuthorizationService.checkToken;
import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;
    private final SizeRepository sizeRepository;
    private final PizzaMapper pizzaMapper;
    private final SizeMapper sizeMapper;


    public PizzaService(PizzaRepository pizzaRepository, SizeRepository sizeRepository,
                        PizzaMapper pizzaMapper, SizeMapper sizeMapper) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaMapper = pizzaMapper;
        this.sizeRepository = sizeRepository;
        this.sizeMapper = sizeMapper;
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


        //wpisujemy liste rozmiar+cena do bazy danych
        List<AddSizeDto> addSizeDtoList = addPizzaDto.getSizes();
        List<SizeEntity> sizeEntities = addSizeDtoList
                .stream()
                .map(addSizeDto -> sizeMapper.mapToSizeEntity(addSizeDto, pizzaEntity.getId()))
                .collect(Collectors.toList());
        sizeRepository.saveAll(sizeEntities);


        /*List<AddSizeDto> addSizeDtoList = addPizzaDto.getAddSizeDtoList();
        List<SizeEntity> sizeEntities = addSizeDtoList
                .stream()
                .map(addSizeDto -> {
                SizeEntity sizeEntity = new SizeEntity();
                sizeEntity.setSizeType(sizeDto.getSize().name());
                sizeEntity.setPriceBase(sizeDto.getPrice());
                sizeEntity.setId(sizeDto.getId());
                sizeEntity.setPizzaId(savedPizzaEntity.getId());
                return sizeEntity;
                }).collect(Collectors.toList());
            PizzaEntity savedSizeEntity = sizeRepository.saveAll(sizeEntity);*/



        //mapowanie z encji do PizzaDto, najpierw mapujemy liste rozmiarow+cena
        List<SizeDto> sizeDtoList = sizeEntities
                .stream()
                .map(sizeEntity -> sizeMapper.mapToSizeDto(sizeEntity))
                .collect(Collectors.toList());


        //to samo co wyżej
        /*List<SizeDto sizeDtoList = sizeEntities.stream()
                .map(sizeMapper::mapToSizeDto)
                .collect(Collectors.toList());*/



        /*List<SizeDto> sizeDtoList = savedSizeEntities
                .stream()
                .map(sizeEntity -> {
                    SizeDto sizeDto = new SizeDto();
                    SizeDto.setSize(SizeType.valueOf(sizeEntity.getSizeType()));
                    sizeDto.setPrice(sizeEntity.getPriceBase());
                    sizeDto.setId(sizeEntity.getId());
                    return sizeDto;
                }).collect(Collectors.toList());*/




        return pizzaMapper.mapToPizzaDto(pizzaEntity, sizeDtoList);

    }

}
