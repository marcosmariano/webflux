package com.mvm.webflux.infra.data;

import com.mvm.webflux.domain.Playlist;
import com.mvm.webflux.infra.repository.PlaylistRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class DummyData implements CommandLineRunner {
    private final PlaylistRepository playlistRepository;

    DummyData(PlaylistRepository playlistRepository){
        this.playlistRepository = playlistRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.playlistRepository.deleteAll()
                .thenMany(
                        Flux.just("Bruno e Marrone - Por um minuto",
                                        "Cesar Menotti e Fabiano - Anjo",
                                        "Cleyton e Camargo - Na hora de amar",
                                        "Gusttavo Lima - Homem de Familia",
                                        "Jorge e Mathes - Ai ja era",
                                        "Jorge e Matheus - Nao para de chover",
                                        "Leonardo - Goiania",
                                        "Rionegro e Solimoes - Na sola da bota",
                                        "Wesley Safadao - Virote",
                                        "Zeze de Camargo e Luciano - A Lua")
                                .map(name -> new Playlist(UUID.randomUUID().toString(), name))
                                .flatMap(playlistRepository::save))
                .subscribe(System.out::println);
    }
}
