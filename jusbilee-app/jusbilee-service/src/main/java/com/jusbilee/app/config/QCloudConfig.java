package com.jusbilee.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rockit.qcloud.im.common.QCloudProperties;
import com.rockit.qcloud.im.signature.TLSSignatureGenerator;

/**
 * Created by Allen on 2016/8/8.
 */
@Configuration
public class QCloudConfig {
    @Bean
    @ConfigurationProperties(prefix = "qcloud.im")
    public QCloudProperties tlsUserSignatureProperties() {
        return new QCloudProperties();
    }

    @Bean
    public TLSSignatureGenerator signatureGenerator(QCloudProperties userSignatureProperties) {
        return new TLSSignatureGenerator(userSignatureProperties);
    }
}
