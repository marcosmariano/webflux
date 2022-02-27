package com.mvm.webflux.usecase;

import com.mvm.webflux.domain.Playlist;
import com.mvm.webflux.infra.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class PlaylistSearchAllImpl implements PlaylistSearchAll{
    @Autowired
    PlaylistService playlistService;

    @Override
    public Flux<Playlist> searchAll() {
        return playlistService.findAll();
    }
}
