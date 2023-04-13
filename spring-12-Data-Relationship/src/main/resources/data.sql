spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=0000

spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

#spring.sql.init.mode=always
spring.jpa.hibernate.ddl-auto=create

#says to inteliJ to run @Entity first and after that add oblects to the table
spring.jpa.defer-datasource-initialization=true