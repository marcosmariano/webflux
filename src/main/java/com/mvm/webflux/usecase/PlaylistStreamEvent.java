package com.mvm.webflux.usecase;

import com.mvm.webflux.domain.Playlist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

public interface PlaylistStreamEvent {
    Flux<Tuple2<Long, Playlist>> streamEvents();
}
