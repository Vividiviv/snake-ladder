package com.lld.games.snakeladdergame.models;

import lombok.Getter;

@Getter
public abstract class SpecialEntity {
    int startPos;
    int endPos;
    int id;

    public abstract String getId();
}
