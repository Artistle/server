package server;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import server.config.WebConfig;

import javax.servlet.*;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ApplicationInitializer implements WebApplicationInitializer {

    private final String DISPATCHER = "dispatcher";

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebConfig.class);

        servletContext.addListener(new ContextLoaderListener(ctx));

        ServletRegistration.Dynamic servler = servletContext.addServlet(DISPATCHER, new DispatcherServlet(ctx));
        servler.addMapping("/");
        servler.setLoadOnStartup(1);
    }
}
