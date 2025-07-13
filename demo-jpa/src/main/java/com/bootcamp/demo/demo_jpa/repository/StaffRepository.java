package com.bootcamp.demo.demo_jpa.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_jpa.entity.StaffEntity;

// ! Select Update Insert Delete (CRUD)
@Repository // Bean
public interface StaffRepository extends JpaRepository<StaffEntity, Long> {
  // ! Hibernate (Framework)
  
  // select * from staffs;
  // insert into staffs, values (xxx, xxx...);
  // similar to update, delete

  // ! 1. JPA methods - pre-defined method structure -> SQL
  // ! FindByXXX -> Optional or List
  // select * from staffs where name = ?
  Optional<StaffEntity> findByName(String name); // findByXXX ("XXX" followed by column "name")

  // Jpa supports and or
  // select * from staffs where name = ? and email = ?
  List<StaffEntity> findByNameAndEmail(String name, String email); // findBy----(followed by column "name")

  // return List

  // ! 2. JPQL (Java Persistance Query Language)
  
  // ! 3. Native Query (Normal SQL). Not a good idea for simple SQL. SQL is Product specific. (Once change database, all codes have to be rewrited.List<StaffEntity> findById(Long id);

}
