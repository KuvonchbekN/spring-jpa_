package uz.pdp.springjpa_.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springjpa_.model.Laptop;
import uz.pdp.springjpa_.model.Phone;
import uz.pdp.springjpa_.model.Student;
import uz.pdp.springjpa_.repository.LaptopRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    @Autowired
    LaptopRepository laptopRepository;

    @RequestMapping(value = "/laptop", method = RequestMethod.GET)
    public List<Laptop> getLaptopList(){
        return laptopRepository.findAll();
    }


    //adding a new student to the database
    @RequestMapping(value = "/laptop", method = RequestMethod.POST)
    public String addLaptop(@RequestBody Laptop laptop){
        laptopRepository.save(laptop);
        return "Laptop has been added!";
    }

    //get by id
    @RequestMapping(value = "/laptop/{id}", method = RequestMethod.GET)
    public Laptop getLaptopById(@PathVariable Integer id){
        Optional<Laptop> byId = laptopRepository.findById(id);
        return byId.orElseGet(Laptop::new);
    }


    //delete the phone from database
    @RequestMapping(value = "/laptop/{id}", method = RequestMethod.DELETE)
    public String deleteLaptopById(@PathVariable Integer id){
        laptopRepository.deleteById(id);
        return "Laptop has been deleted from the system";
    }

    //update the phone database
    @RequestMapping(value = "/laptop/{id}", method = RequestMethod.PUT)
    public String editPhoneById(@PathVariable Integer id, @RequestBody Laptop laptop){
        Optional<Laptop> byId = laptopRepository.findById(id);
        if (byId.isPresent()){
            Laptop laptopTobeChanged = byId.get();
            laptopTobeChanged.setBrandName(laptop.getBrandName());
            laptopTobeChanged.setMacAddress(laptop.getMacAddress());
            laptopTobeChanged.setModel(laptop.getModel());
            laptopTobeChanged.setName(laptop.getName());
            laptopTobeChanged.setRam(laptop.getRam());
            laptopTobeChanged.setStorage(laptop.getStorage());
            laptopRepository.save(laptopTobeChanged);
            return "ozgartirildi";
        }

        return "bunaqa idlik phone topilmadi";
    }






}
