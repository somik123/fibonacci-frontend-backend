package sg.nus.iss.somik;

import java.util.EnumSet;

import org.eclipse.jetty.servlets.CrossOriginFilter;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.FilterRegistration;
import sg.nus.iss.somik.health.TemplateHealthCheck;
import sg.nus.iss.somik.resources.HelloWorldResource;

public class sa54somikApplication extends Application<sa54somikConfiguration> {

	public static void main(final String[] args) throws Exception {
		new sa54somikApplication().run(args);
	}

	@Override
	public String getName() {
		return "sa54somik";
	}

	@Override
	public void initialize(final Bootstrap<sa54somikConfiguration> bootstrap) {
		// TODO: application initialization
	}

	@Override
	public void run(final sa54somikConfiguration configuration, final Environment environment) {
		// TODO: implement application
		// Enable CORS headers
		final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);

		// Configure CORS parameters
		cors.setInitParameter("allowedOrigins", "*");
		cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
		cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

		// Add URL mapping
		cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

		final HelloWorldResource resource = new HelloWorldResource();
		final TemplateHealthCheck healthCheck = new TemplateHealthCheck();
		environment.healthChecks().register("template", healthCheck);
		environment.jersey().register(resource);
	}

}
