package com.todoproject.ilyas.todolist.controller;

import com.todoproject.ilyas.todolist.entity.Stat;
import com.todoproject.ilyas.todolist.service.StatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;






@RestController
public class StatController {

    private final StatService statService;


    public StatController(StatService statService) {
        this.statService = statService;
    }



    @PostMapping("/stat")
    public ResponseEntity<Stat> findByEmail(@RequestBody String email) {

        return ResponseEntity.ok(statService.findStat(email));
    }


}
