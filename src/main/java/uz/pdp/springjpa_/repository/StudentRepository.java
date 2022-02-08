package uz.pdp.springjpa_.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.springjpa_.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
