package com.jusbilee.app.config;

import com.rockit.core.qcloud.im.common.QCloudProperties;
import com.rockit.core.qcloud.im.signature.TLSSignatureGenerator;
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
    public QCloudProperties qCloudProperties() {
        return new QCloudProperties();
    }

    @Bean
    public TLSSignatureGenerator signatureGenerator(QCloudProperties qCloudProperties) {
        return new TLSSignatureGenerator(qCloudProperties);
    }
}
