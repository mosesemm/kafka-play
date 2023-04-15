package za.co.mashandiro.controller;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import io.smallrye.mutiny.Multi;
import za.co.mashandiro.model.Qoute;


@ApplicationScoped
public class QuotesService {

    @Channel("quotes")
    Multi<Qoute> quotes;

    @Channel("quote-requests")
    Emitter<String> quoteRequestEmitter;

    public String createRequest() {
        UUID uuid = UUID.randomUUID();
        quoteRequestEmitter.send(uuid.toString());
        return uuid.toString();
    }

    public Multi<Qoute> stream() {
        return quotes;
    }


}