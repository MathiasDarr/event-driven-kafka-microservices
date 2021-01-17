package org.mddarr.reactivecassandrawebsockets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SynchronousSink;

import java.time.Duration;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;


@SpringBootApplication
public class ReactiveCassandraWebsocketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveCassandraWebsocketsApplication.class, args);
	}

	@Bean
	public HandlerMapping handlerMapping(){
		return new SimpleUrlHandlerMapping(Map.of("/websocket", new CoordinatesWebSocketHandler()), -1 );
	}

	@Bean
	public WebSocketHandlerAdapter handlerAdapter(){
		return new WebSocketHandlerAdapter();
	}
}

class CoordinatesWebSocketHandler implements WebSocketHandler{

	@Override
	public Mono<Void> handle(WebSocketSession session){
		final Flux<String> flux = Flux.generate(synchronousSink -> {
			final String s = UUID.randomUUID().toString();
			synchronousSink.next(s);
		});

		final Flux<String> zip = Flux.interval(Duration.ofMillis(10000L)).zipWith(flux,(time,uuid)->uuid);

		return session
				.send(zip.map(session::textMessage))
				.and(session.receive()
						.map(WebSocketMessage::getPayloadAsText))
				.log();
	}

}

