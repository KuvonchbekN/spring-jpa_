package uz.pdp.springjpa_.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.springjpa_.model.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {

}
