package pl.khayn.dev.mybatis.api;

import org.springframework.web.bind.annotation.*;
import pl.khayn.dev.mybatis.mapper.CityMapper;
import pl.khayn.dev.mybatis.model.City;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityApi {

    private final CityMapper cityMapper;

    public CityApi(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    @GetMapping
    public List<City> get(){
        return cityMapper.findAll();
    }

    @GetMapping("/id/{id}")
    public City getOne(@PathVariable Long id){
        return cityMapper.findById(id);
    }

    @PostMapping
    public void addCity(@RequestBody City city){
        cityMapper.insert(city);
    }
}
