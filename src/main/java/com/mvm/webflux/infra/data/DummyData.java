package com.mvm.webflux.infra.data;

import com.mvm.webflux.domain.Playlist;
import com.mvm.webflux.infra.repository.PlaylistRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
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
                        Flux.just("Cleyton e Camargo - Na hora de amar",
                                "Zeze de Camargo e Luciano - A Lua",
                                "Bruno e Marrone - Por um minuto",
                                "Cesar Menotti e Fabiano - Anjo",
                                "Wesley Safadao - Virote",
                                "Rionegro e Solimoes - Na sola da bota",
                                "Gusttavo Lima - Homem de Familia",
                                "Leonardo - Goiania",
                                "Jorge e Matheus - Nao para de chover",
                                "Jorge e Mathes - Ai ja era")
                                .map(name -> new Playlist(UUID.randomUUID().toString(), name))
                                .flatMap(playlistRepository::save))
                                .subscribe(System.out::println);
    }
}
