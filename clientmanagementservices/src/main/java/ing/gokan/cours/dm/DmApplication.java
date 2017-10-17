package ing.gokan.cours.dm;

import ing.gokan.cours.dm.controllers.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.logging.Logger;

/**
 * Launcher class of Application
 *
 * @author BOURGEOIS Thibault
 * Date     16/10/2017
 * Time     22:13
 */
@SpringBootApplication
public class DmApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(DmApplication.class, args);
    }
}
