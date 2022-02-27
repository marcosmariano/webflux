package com.mvm.webflux.usecase;

import com.mvm.webflux.domain.Playlist;
import reactor.core.publisher.Flux;

public interface PlaylistSearchAll {
    Flux<Playlist> searchAll();
}
