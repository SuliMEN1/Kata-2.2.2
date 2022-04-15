package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDaoServiceImplement implements CarDaoService{
    private List<Car> list;
    {
        list = new ArrayList<>();
        list.add(new Car("volga", 35 , 1980));
        list.add(new Car("oka", 5 , 1990));
        list.add(new Car("bmv", 3 , 2020));
        list.add(new Car("lada", 15 , 2000));
        list.add(new Car("reno", 30 , 2010));
    }

    @Override
    public List<Car> show(Integer count) {
        if (count == null) {
            return list;
        } else {
            return list.stream().limit(count).collect(Collectors.toList());
        }
    }
}
