package net.javaguides.sb_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.sb_test.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
