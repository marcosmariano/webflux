package com.mvm.webflux.infra.repository;

import com.mvm.webflux.domain.Playlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {
}
