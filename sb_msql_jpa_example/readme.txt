Aplicacion de Spring Boot que manjea dependencias de JPA, Hibernate(validadores)
Manejado en la propia metodologia stardar de JAVA (Entity, Repository, Controller)
con los respectivos enlaces con la tabla de la base de datos,

La configuracion del conector con la base se llama "application.properties"

Utiliza una clase personalizada para detectar excepciones

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
		
<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-validator -->
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>6.1.6.Final</version>
</dependency>
				
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<scope>runtime</scope>
</dependency>

