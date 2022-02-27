package com.mvm.webflux.api.viewModel;

import com.mvm.webflux.domain.Playlist;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.util.function.Tuple2;

@Document
public class PlaylistEventStream {
    private Tuple2<Long, Playlist> event;

    public Tuple2<Long, Playlist> getEvent() {
        return event;
    }

    public void setEvent(Tuple2<Long, Playlist> event) {
        this.event = event;
    }
}
