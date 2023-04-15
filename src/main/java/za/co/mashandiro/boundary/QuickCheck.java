package za.co.mashandiro.boundary;

import io.smallrye.common.annotation.Blocking;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuickCheck {


    @Incoming("testing-stuff")
    @Outgoing("test-stuff-results")
    @Blocking
    public String process(String something) throws InterruptedException {
        Thread.sleep(200);
        return something+" (processed) ";
    }
}
