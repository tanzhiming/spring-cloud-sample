package com.tzm.springcloud.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;


@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(this.authenticationManager)
                .tokenStore(tokenStore());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("ui1")
                .secret("ui1-secret")
                .authorities("ROLE_TRUSTED_CLIENT")
                .authorizedGrantTypes("authorization_code", "refresh_token")
                .scopes("ui1.read")
                .redirectUris("http://localhost:3000/login")
                .autoApprove(true)
                .and()
                .withClient("ui2")
                .secret("ui2-secret")
                .authorities("ROLE_TRUSTED_CLIENT")
                .authorizedGrantTypes("authorization_code", "refresh_token")
                .scopes("ui2.read", "ui2.write")
                .autoApprove(true)
                .and()
                .withClient("mobile-app")
                .authorities("ROLE_CLIENT")
                .authorizedGrantTypes("implicit", "refresh_token")
                .scopes("read")
                .autoApprove(true)
                .and()
                .withClient("customer-integration-system")
                .secret("1234567890")
                .authorities("ROLE_CLIENT")
                .authorizedGrantTypes("client_credentials")
                .scopes("read")
                .autoApprove(true);
    }

    @Bean
    public RedisTokenStore tokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

}
