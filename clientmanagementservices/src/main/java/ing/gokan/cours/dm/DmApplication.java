package ing.gokan.cours.dm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Launcher class of Application
 *
 * @author BOURGEOIS Thibault
 * Date     16/10/2017
 * Time     22:13
 */
@SpringBootApplication
public class DmApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DmApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DmApplication.class, args);
    }
}
