package com.bkash.ddb.dts.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
@EnableDynamoDBRepositories
        (basePackages = "com.bkash.ddb.dts.repository")
public class DynamoDbConfig {

    @Value("${amazon.dynamodb.endpoint:{null}}")
    private String amazonDynamoDBEndpoint;

    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDB amazonDynamoDB
                = new AmazonDynamoDBClient(amazonAWSCredentials());

//        if (!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
//            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
//        }

        return amazonDynamoDB;
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {

//        InstanceProfileCredentialsProvider credentials =
//                InstanceProfileCredentialsProvider.createAsyncRefreshingProvider(true);
//        return credentials;
        return new BasicAWSCredentials(
                amazonAWSAccessKey, amazonAWSSecretKey);
    }
}