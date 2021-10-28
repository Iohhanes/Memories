package project.memories.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import project.memories.aop.logging.LoggingAspect;

@Configuration
@EnableAspectJAutoProxy
public class LoggingAspectConfiguration {

    @Bean
    @ConditionalOnProperty(name = "memories.logging.tracing-aspect-enabled", havingValue = "true")
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }
}
