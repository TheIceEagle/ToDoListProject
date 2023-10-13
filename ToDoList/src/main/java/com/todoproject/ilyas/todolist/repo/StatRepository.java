package com.todoproject.ilyas.todolist.repo;

import com.todoproject.ilyas.todolist.entity.Stat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface StatRepository extends CrudRepository<Stat, Long> {

    Stat findByUserEmail(String email);
}
