package uz.pdp.springjpa_.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springjpa_.model.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {
}
