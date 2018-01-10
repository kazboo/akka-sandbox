package akka.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import akka.actor.UntypedActor;

public class DeleteActor extends UntypedActor {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteActor.class);

    @Override
    public void onReceive(Object message) throws Throwable {
        LOGGER.info("DeleteActor started.");
    }
}
