package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDaoService;


@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarDaoService carDaoService;

    @Autowired
    public CarController(CarDaoService carDaoService) {
        this.carDaoService = carDaoService;
    }

    @GetMapping()
    public String index(@RequestParam(value = "count", required = false) Integer count, Model model) {
        model.addAttribute("car",carDaoService.show(count));
        return "cars/index";
    }
}
