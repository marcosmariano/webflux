package com.mvm.webflux.api;

import com.mvm.webflux.domain.Playlist;
import com.mvm.webflux.infra.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@CrossOrigin(origins = "*")
@RestController
public class PlaylistController {

    @GetMapping(value="/v1/playlist/events")
    public List<String> getPlaylistByMvc() throws InterruptedException {

        System.out.println("---Start get Playlists by MVC--- " + LocalDateTime.now());

        List<String> playlistList = new ArrayList<>();
        playlistList.add("Java 8");
        playlistList.add("Spring Security");
        playlistList.add("Github");
        playlistList.add("Deploy de uma aplicação java no IBM Cloud");
        playlistList.add("Bean no Spring Framework");
        TimeUnit.SECONDS.sleep(20);

        return playlistList;
    }
}
