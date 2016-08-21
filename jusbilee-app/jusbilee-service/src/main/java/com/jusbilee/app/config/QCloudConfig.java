package com.jusbilee.app.config;

import com.rockit.qcloud.im.signature.TLSSignatureGenerator;
import com.rockit.qcloud.im.signature.TencentQcloudProperties;
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
    public TencentQcloudProperties tlsUserSignatureProperties() {
        return new TencentQcloudProperties();
    }

    @Bean
    public TLSSignatureGenerator signatureGenerator(TencentQcloudProperties userSignatureProperties) {
        return new TLSSignatureGenerator(userSignatureProperties);
    }
}
