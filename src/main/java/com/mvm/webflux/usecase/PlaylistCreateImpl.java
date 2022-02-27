package com.mvm.webflux.usecase;

import com.mvm.webflux.domain.Playlist;
import com.mvm.webflux.infra.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class PlaylistCreateImpl implements PlaylistCreate{
    @Autowired
    PlaylistService playlistService;

    @Override
    public Mono<Playlist> create(Playlist playlist) {
        return playlistService.save(playlist);
    }
}
