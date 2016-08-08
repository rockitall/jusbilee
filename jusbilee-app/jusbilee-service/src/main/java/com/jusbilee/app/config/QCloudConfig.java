package com.jusbilee.app.config;

import com.rockit.signature.TLSSignatureGenerator;
import com.rockit.signature.UserSignatureProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Allen on 2016/8/8.
 */
@Configuration
public class QCloudConfig {
    @Bean
    @ConfigurationProperties(prefix = "qcloud.im")
    public UserSignatureProperties userSignatureProperties() {
        return new UserSignatureProperties();
    }

    @Bean
    public TLSSignatureGenerator signatureGenerator(UserSignatureProperties userSignatureProperties) {
        return new TLSSignatureGenerator(userSignatureProperties);
    }
}
