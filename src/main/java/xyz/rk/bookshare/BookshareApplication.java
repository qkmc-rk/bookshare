package xyz.rk.bookshare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("xyz.rk.bookshare.dao")
public class BookshareApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookshareApplication.class, args);
	}

}
