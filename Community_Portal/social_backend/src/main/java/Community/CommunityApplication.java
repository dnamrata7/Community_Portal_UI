package Community;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class CommunityApplication {
	@Value("${server.port}")
	private static String serverPort;

	public static void main(String[] args) {
		// SpringApplication.run(CommunityApplication.class, args);
		SpringApplication app = new SpringApplication(CommunityApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", serverPort));
		app.run(args);
	}
}
