package com.mvm.webflux.api;

import com.mvm.webflux.api.viewModel.PlaylistEventStream;
import com.mvm.webflux.domain.Playlist;
import com.mvm.webflux.usecase.PlaylistCreate;
import com.mvm.webflux.usecase.PlaylistSeachById;
import com.mvm.webflux.usecase.PlaylistSearchAll;
import com.mvm.webflux.usecase.PlaylistStreamEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.Duration;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.created;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class PlaylistHandler {

    @Autowired
    PlaylistSearchAll playlistSearchAll;

    @Autowired
    PlaylistSeachById playlistSeachById;

    @Autowired
    PlaylistCreate playlistCreate;

    @Autowired
    PlaylistStreamEvent playlistStreamEvent;

    public Mono<ServerResponse> findAll(ServerRequest request){
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(playlistSearchAll.searchAll(), Playlist.class)
                .cache(Duration.ofSeconds(1000))
                .log("Passou aqui no GET findAll");
    }

    public Mono<ServerResponse> findById(ServerRequest request){
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(playlistSeachById.searchById(id),Playlist.class)
                .cache(Duration.ofSeconds(1000))
                .log("Passou aqui no GET findByID");
    }

    public  Mono<ServerResponse> save(ServerRequest request){
        final Mono<Playlist> playlist = request.bodyToMono(Playlist.class);
        return created(URI.create("/playlist"))
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(playlist.flatMap(playlistCreate::create), Playlist.class));
    }

    public Mono<ServerResponse> streamEvents(ServerRequest request){
        return ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(playlistStreamEvent.streamEvents(), PlaylistEventStream.class)
                .log("Stream de eventos");
    }
}
