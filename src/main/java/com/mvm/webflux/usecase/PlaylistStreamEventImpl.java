package com.mvm.webflux.usecase;

import com.mvm.webflux.domain.Playlist;
import com.mvm.webflux.infra.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class PlaylistStreamEventImpl implements PlaylistStreamEvent{

    @Autowired
    PlaylistService playlistService;

    @Override
    public Flux<Tuple2<Long, Playlist>> streamEvents() {
        System.out.println("---Start get Playlists by WEBFLUX--- " + LocalDateTime.now());
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(5));
        Flux<Playlist> playlistFlux = playlistService.findAll();
        return Flux.zip(interval, playlistFlux);
    }
}
