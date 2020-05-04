package com.webfluxpoc.callerservice;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.Connection;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class CallerserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CallerserviceApplication.class, args);
    }

}


@Repository
class ReservationRepository{
    private final ConnectionFactory connectionFactory;

    ReservationRepository(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    Mono<Void> deleteById(Integer id){
        return this.connection()
                .flatMapMany(c->c.createStatement("delete from reservation where id = $1")
                .bind("$1",id)
                .execute()).then();
    }

    Flux<Reservation> findAll(){
       return this.connection()
                .flatMapMany(connection ->
                Flux.from(connection.createStatement("select * from reservation").execute())
        .flatMap((Result r)-> r.map((row,rowMetadata)-> new Reservation(
                row.get("id",Integer.class),
                row.get("name",String.class)))));
    }
    Flux<Reservation> save(Reservation r){
        Flux<? extends Result> flatMapMany = this.connection()
                .flatMapMany(connection -> connection.createStatement("insert into reservation(name) values ($1)")
                .bind("$1",r.getName())
                .add()
                .execute());
        return flatMapMany.switchMap(x->Flux.just(new Reservation(r.getId(),r.getName())));
    }

    private Mono<Connection> connection(){
        return Mono.from(this.connectionFactory.create());
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Reservation{
    @Id
    private Integer id;
    private String name;
}

@Configuration
class ConnectionFactoryConfiguration {
    @Bean
    ConnectionFactory connectionFactory() {
        PostgresqlConnectionConfiguration config =
                PostgresqlConnectionConfiguration.builder()
                        .database("mydatabase")
                        .password("mydbcon")
                        .username("postgres")
                        .host("localhost")
                        .build();
        return new PostgresqlConnectionFactory(config);
    }
}
