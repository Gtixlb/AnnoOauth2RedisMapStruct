package com.macro.cloud.config;

import com.macro.cloud.service.impl.ClientDetailServiceImpl;
import com.macro.cloud.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * 认证服务器配置
 * Created by macro on 2019/9/30.
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 用户认证管理器
     */
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 用户服务
     */
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    @Qualifier("redisTokenStore")
    private RedisTokenStore tokenStore;

    /**
     * client凭证
     */
    @Autowired
    private ClientDetailServiceImpl clientDetailService;


    /**
     * 使用密码模式需要配置
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userService)
                .tokenStore(tokenStore);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailService);
//        clients.inMemory()
//                .withClient("client_id:123456")//配置client_id
//                .secret(passwordEncoder.encode("client_secret:abcdef"))//配置client-secret
//                .accessTokenValiditySeconds(3600)//配置访问token的有效期
//                .refreshTokenValiditySeconds(864000)//配置刷新token的有效期
//                .redirectUris("http://www.baidu.com")//配置redirect_uri，用于授权成功后跳转
//                .scopes("all")//配置申请的权限范围
//                .authorizedGrantTypes("authorization_code","password");//配置grant_type，表示授权类型
    }

    /**
     * @description: 授权服务安全配置，主要用于放行客户端访问授权服务接口
     * @author: chd
     * @param: [security]
     * @return: void
     * @throws:
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //允许客户端表单提交
        security.allowFormAuthenticationForClients()
                //客户端校验token访问许可
                .checkTokenAccess("permitAll()")
                //客户端token调用许可
                .tokenKeyAccess("permitAll()");
    }
}
