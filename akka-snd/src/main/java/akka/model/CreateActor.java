package akka.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import akka.actor.UntypedActor;

public class CreateActor extends UntypedActor {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateActor.class);

    @Override
    public void onReceive(Object message) throws Throwable {
        LOGGER.info("CreateActor started.");
    }
}
