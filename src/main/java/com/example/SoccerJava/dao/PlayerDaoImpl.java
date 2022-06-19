package com.example.SoccerJava.dao;

import com.example.SoccerJava.configuration.ApiCallConfigurationProperties;
import com.example.SoccerJava.domain.PlayerList;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class PlayerDaoImpl implements PlayerDao, InitializingBean {

    private final ApiCallConfigurationProperties properties;


    private final RestOperations restOperations;
    private String playerApiUrlPrefix;

    @Autowired
    public PlayerDaoImpl (ApiCallConfigurationProperties properties, RestOperations restOperations){
        this.properties=properties;
        this.restOperations=restOperations;
    }

    @Override
    public PlayerList find(String playerName) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.playerApiUrlPrefix);
        if (playerName != null){
            builder.queryParam("playerName", playerName);
        }
        return this.restOperations.getForObject(builder.build().toUriString(),PlayerList.class);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.playerApiUrlPrefix = "http://" + this.properties.getHost() + ":" + this.properties.getPort() + "/services/v1/players";
    }
}
