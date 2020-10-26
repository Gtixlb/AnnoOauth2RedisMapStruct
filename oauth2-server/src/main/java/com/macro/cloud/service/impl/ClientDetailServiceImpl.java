package com.macro.cloud.service.impl;

import com.macro.cloud.domain.ClientDetail;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @version: 1.00.00
 * @description: Client信息
 * @copyright: Copyright (c) 2018 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chd
 * @date: 2020-09-29 11:01
 */
@Service
public class ClientDetailServiceImpl implements ClientDetailsService {

    private List<ClientDetail> clientDetails;

    /**
     * 初始化凭证信息
     */
    @PostConstruct
    public void initData() {
        clientDetails = new ArrayList<>();
        clientDetails.add(new ClientDetail("client_id_123456", "client_secret_abcdef", "www.baidu.com", "all"));
        clientDetails.add(new ClientDetail("client_id_666666", "client_secret_ffffff", "www.hao123.com", "all"));
        clientDetails.add(new ClientDetail("client_id_111111", "client_secret_aaaaaa", "www.taobao.com", "all"));
    }

    /**
     * 根据clientId查找凭证信息
     * @param clientId
     * @return
     * @throws ClientRegistrationException
     */
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        if (StringUtils.isNotEmpty(clientId)){
            ClientDetail clientDetail = clientDetails.stream().filter(client -> clientId.equals(client.getClientId())).findFirst().get();
            if (null != clientDetail){
                BaseClientDetails client = new BaseClientDetails();
                client.setClientId(clientId);
                client.setClientSecret(clientDetail.getClientSecret());
                // 14天
                client.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(1095));
                // 30天
                client.setRefreshTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(1096));
                client.setRegisteredRedirectUri(new HashSet<String>(){{
                    add(clientDetail.getRedirectUrl());
                }});
                client.setScope(new HashSet<String>(){{
                    add(clientDetail.getScope());
                }});

                //支持四种授权模式（授权码模式、密码模式、简化模式、隐藏式模式）
                client.setAuthorizedGrantTypes(new HashSet<String>() {{
                    add("authorization_code");
                    add("refresh_token");
                    add("client_credentials");
                    add("password");
                    add("implicit");

                }});
                return client;
            }
            throw new NoSuchClientException("No client with requested id: " + clientId);
        }
        throw new NoSuchClientException("No client with requested id: " + clientId);
    }
}
