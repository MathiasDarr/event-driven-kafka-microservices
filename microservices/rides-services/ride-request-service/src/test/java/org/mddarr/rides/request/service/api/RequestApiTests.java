package org.mddarr.rides.request.service.api;


import org.junit.Test;

import org.mddarr.rides.request.service.UatAbstractTest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;
import java.time.ZonedDateTime;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import java.net.URI;
public class RequestApiTests extends UatAbstractTest {

    @Test
    public void should_send_driver_request() {
        WebClient client = WebClient
                .builder()
                .baseUrl("http://localhost:8080")
                .defaultCookie("cookieKey", "cookieValue")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8080"))
                .build();

        WebClient.UriSpec<WebClient.RequestBodySpec> request1 = client.method(HttpMethod.POST);

        WebClient.RequestHeadersSpec<?> requestSpec2 = WebClient
                .create("http://localhost:8080")
                .post()
                .uri(URI.create("/resource"))
                .body(BodyInserters.fromObject("data"));


    }


}