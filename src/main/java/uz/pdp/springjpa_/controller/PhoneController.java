package uz.pdp.springjpa_.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springjpa_.model.Phone;
import uz.pdp.springjpa_.repository.PhoneRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class PhoneController {

    //this is called "dependency injection"
    @Autowired
    PhoneRepository phoneRepository;


    //get the phone list
    @RequestMapping(value = "/phone", method = RequestMethod.GET)
    public List<Phone> getPhoneList(){
        List<Phone> all = phoneRepository.findAll();
        return all;
    }

    //get the phone by id
    @RequestMapping(value = "/phone/{id}", method = RequestMethod.GET)
    public Phone getPhoneById(@PathVariable Integer id){
        Optional<Phone> byId = phoneRepository.findById(id);
        return byId.orElseGet(Phone::new);
    }


    //add the phone to the database
    @RequestMapping(value = "/phone", method = RequestMethod.POST)
    public String addPhone(@RequestBody Phone phone){
        phoneRepository.save(phone);
        return "Phone has been added to the system!";
    }

    //delete the phone from database by its id
    @RequestMapping(value = "/phone/{id}", method = RequestMethod.DELETE)
    public String deletePhone(@PathVariable Integer id){
        Optional<Phone> byId = phoneRepository.findById(id);
        if (byId.isPresent()){
            phoneRepository.deleteById(id);
            return "ocirildi";
        }else {
            return "bu id lik phone mavjud emas";
        }
    }

    //update the phone database
    @RequestMapping(value = "/phone/{id}", method = RequestMethod.PUT)
    public String editPhoneById(@PathVariable Integer id, @RequestBody Phone phone){
        Optional<Phone> byId = phoneRepository.findById(id);
        if (byId.isPresent()){
            Phone phoneToBeChanged = byId.get();
            phoneToBeChanged.setInfo(phone.getInfo());
            phoneToBeChanged.setMacAddress(phone.getMacAddress());
            phoneToBeChanged.setModel(phone.getModel());
            phoneToBeChanged.setName(phone.getName());
            phoneRepository.save(phoneToBeChanged);
            return "ozgartirildi";
        }

        return "bunaqa idlik phone topilmadi";
    }


}
