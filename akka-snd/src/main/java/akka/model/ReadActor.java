package akka.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import akka.actor.UntypedActor;

public class ReadActor extends UntypedActor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadActor.class);

    @Override
    public void onReceive(Object message) throws Throwable {
        LOGGER.info("ReadActor started.");
    }
}
