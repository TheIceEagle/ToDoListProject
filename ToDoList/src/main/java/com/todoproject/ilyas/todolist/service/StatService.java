package com.todoproject.ilyas.todolist.service;

import com.todoproject.ilyas.todolist.entity.Stat;
import com.todoproject.ilyas.todolist.repo.StatRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;




@Service

@Transactional
public class StatService {

    private final StatRepository repository;

    public StatService(StatRepository repository) {
        this.repository = repository;
    }

    public Stat findStat(String email) {
        return repository.findByUserEmail(email);
    }

}
