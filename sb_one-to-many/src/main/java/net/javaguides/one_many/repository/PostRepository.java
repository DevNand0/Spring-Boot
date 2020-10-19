package net.javaguides.one_many.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.one_many.entity.Post;

@Repository
public interface PostRepository extends JpaRepository <Post, Long>{

}
