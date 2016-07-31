package com.rockit.core.http;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


/**
 * Created by Allen on 2016/7/31.
 */
public class HttpClientManager {
    private PoolingHttpClientConnectionManager manager;
    private HttpClientConfig httpClientConfig;
    private CloseableHttpClient httpClient;

    public HttpClientManager(HttpClientConfig httpClientConfig) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        Registry<ConnectionSocketFactory> registry = this.createRegistry();
        manager = new PoolingHttpClientConnectionManager(registry);
        manager.setDefaultMaxPerRoute(httpClientConfig.getDefaultMaxPerRoute());
        SocketConfig config = SocketConfig.custom().setSoTimeout(httpClientConfig.getSoTimeoutInMillis()).build();
        manager.setDefaultSocketConfig(config);

        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(httpClientConfig.getConnectionTimeoutInMillis()).setSocketTimeout(httpClientConfig.getSocketTimeoutInMillis()).build();
        this.httpClient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).setConnectionManager(manager).build();
        this.httpClientConfig = httpClientConfig;
    }

    public CloseableHttpClient getHttpClient() {
        return httpClient;
    }

    private Registry<ConnectionSocketFactory> createRegistry() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                return true;
            }
        }).build();

        HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.getDefaultHostnameVerifier();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, hostnameVerifier);
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", sslsf).build();
        return socketFactoryRegistry;
    }

    public PoolingHttpClientConnectionManager getManager() {
        return manager;
    }

    public HttpClientConfig getHttpClientConfig() {
        return httpClientConfig;
    }
}
