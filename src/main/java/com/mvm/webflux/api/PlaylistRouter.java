package com.mvm.webflux.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class PlaylistRouter {

    @Bean
    public RouterFunction<?> route(PlaylistHandler handler){
        return RouterFunctions
                .route(GET("/v2/playlist/eventsdelay").and(accept(MediaType.TEXT_EVENT_STREAM)),handler::streamEvents)
                .andRoute(GET("/v2/playlist/events").and(accept(MediaType.TEXT_EVENT_STREAM)),handler::streamEventsWithOutDelay)
                .andRoute(GET("/v2/playlist").and(accept(MediaType.APPLICATION_JSON)),handler::findAll)
                .andRoute(GET("/v2/playlist/{id}").and(accept(MediaType.APPLICATION_JSON)),handler::findById)
                .andRoute(POST("/v2/playlist").and(accept(MediaType.APPLICATION_JSON)),handler::save);
    }
}
