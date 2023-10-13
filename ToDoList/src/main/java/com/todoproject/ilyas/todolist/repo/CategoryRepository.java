package com.todoproject.ilyas.todolist.repo;

import com.todoproject.ilyas.todolist.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;



@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


    List<Category> findByUserEmailOrderByTitleAsc(String email);

    // поиск значений по названию для конкретного пользователя
    @Query("SELECT c FROM Category c where " +
            "(:title is null or :title='' " +
            " or lower(c.title) like lower(concat('%', :title,'%'))) " +
            " and c.user.email=:email  " +
            " order by c.title asc")
    List<Category> findByTitle(@Param("title") String title, @Param("email") String email);
}
