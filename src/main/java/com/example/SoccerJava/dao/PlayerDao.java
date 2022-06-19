package com.example.SoccerJava.dao;

import com.example.SoccerJava.domain.PlayerList;

public interface PlayerDao {
    PlayerList find(String playerName);
}
