package br.caed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.blockhound.BlockHound;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.BaseStream;

@SpringBootApplication
public class CaedApplication {

    static {
        BlockHound.install(
            builder -> builder.allowBlockingCallsInside("java.util.UUID", "randomUUID")
                .allowBlockingCallsInside("java.io.FilterInputStream", "read")
                .allowBlockingCallsInside("java.io.InputStream", "readNBytes")
        );
    }

    public static void main(String[] args) {
        SpringApplication.run(CaedApplication.class, args);
    }

}
