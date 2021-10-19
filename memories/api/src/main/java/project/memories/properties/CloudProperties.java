package project.memories.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("cloud")
public class CloudProperties {
    private AwsProperties aws;

    @Data
    public static class AwsProperties {
        private AwsCredentialsProperties credentials;
        private String region;
        private AwsStackProperties stack;
    }

    @Data
    public static class AwsCredentialsProperties {
        private String accessKey;
        private String secretKey;
    }

    @Data
    public static class AwsStackProperties {
        private boolean auto;
    }
}
