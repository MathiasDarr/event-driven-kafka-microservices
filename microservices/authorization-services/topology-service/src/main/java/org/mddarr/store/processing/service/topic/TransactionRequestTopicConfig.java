package org.mddarr.store.processing.service.topic;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("topics.transaction-request")
public class TransactionRequestTopicConfig extends TopicConfig {

}
