package ru.geekbrains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.entity.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Long>{

}
