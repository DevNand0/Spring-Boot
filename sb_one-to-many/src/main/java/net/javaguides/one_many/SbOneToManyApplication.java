package net.javaguides.one_many;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.one_many.entity.Comment;
import net.javaguides.one_many.entity.Post;
import net.javaguides.one_many.repository.PostRepository;

@SpringBootApplication
public class SbOneToManyApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SbOneToManyApplication.class, args);
	}
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) {
		Post post = new Post("one to many con mapeo","coleccion de datos usando JPA e Hibernate");
		Comment c1 = new Comment("informativo");
		Comment c2 = new Comment("muy facil");
		Comment c3 = new Comment("buen post");
		
		post.getComments().add(c1);
		post.getComments().add(c2);
		post.getComments().add(c3);
		
		this.postRepository.save(post);
	}
	

}
