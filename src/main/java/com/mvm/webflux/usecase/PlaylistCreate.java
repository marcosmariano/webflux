package com.mvm.webflux.usecase;

import com.mvm.webflux.domain.Playlist;
import reactor.core.publisher.Mono;

public interface PlaylistCreate {
    Mono<Playlist> create (Playlist playlist);
}
