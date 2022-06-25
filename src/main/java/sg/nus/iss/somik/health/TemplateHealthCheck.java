package sg.nus.iss.somik.health;

import com.codahale.metrics.health.HealthCheck;

public class TemplateHealthCheck extends HealthCheck {
	private final String template;
	
	public TemplateHealthCheck() {
        this.template = "Hello, %s!";
    }
	
	@Override
	protected Result check() throws Exception {
		// TODO Auto-generated method stub
		final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
	}

}
