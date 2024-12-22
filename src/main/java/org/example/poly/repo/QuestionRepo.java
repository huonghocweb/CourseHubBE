package org.example.poly.repo;

import org.example.poly.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends  JpaRepository<Question,  Integer>{
    
}
