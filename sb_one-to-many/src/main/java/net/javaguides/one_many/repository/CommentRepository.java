package net.javaguides.one_many.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.one_many.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

}
