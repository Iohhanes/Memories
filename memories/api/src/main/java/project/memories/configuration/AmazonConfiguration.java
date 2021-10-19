package project.memories.configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.memories.properties.CloudProperties;

@Configuration
public class AmazonConfiguration {

    @Autowired
    private CloudProperties cloudProperties;

    @Bean
    public AmazonS3 s3() {
        CloudProperties.AwsCredentialsProperties awsCredentialsProperties = cloudProperties.getAws().getCredentials();
        AWSCredentials credentials = new BasicAWSCredentials(awsCredentialsProperties.getAccessKey(),
                awsCredentialsProperties.getSecretKey());
        return AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(cloudProperties.getAws().getRegion())
                .build();
    }
}
