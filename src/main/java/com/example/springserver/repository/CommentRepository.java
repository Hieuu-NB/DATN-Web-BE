package com.example.springserver.repository;

import com.example.springserver.entity.truyen_onl.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long> {
//    List<Comments>
}
