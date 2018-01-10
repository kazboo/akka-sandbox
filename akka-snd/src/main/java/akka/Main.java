package akka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.typesafe.akka.extension.quartz.QuartzSchedulerExtension;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.model.CreateActor;
import akka.model.DeleteActor;
import akka.model.ReadActor;
import akka.model.UpdateActor;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        invokeWith(() -> startUp());
    }

    public static void startUp() {
        LOGGER.info("setUp");

        ActorSystem system = ActorSystem.create("ActorSystem");
        QuartzSchedulerExtension cronScheduler = (QuartzSchedulerExtension) QuartzSchedulerExtension.get(system);

        ActorRef createActor = system.actorOf(Props.create(CreateActor.class), "CreateActor");
        ActorRef readActor = system.actorOf(Props.create(ReadActor.class), "ReadActor");
        ActorRef updateActor = system.actorOf(Props.create(UpdateActor.class), "UpdateActor");
        ActorRef deleteActor = system.actorOf(Props.create(DeleteActor.class), "DeleteActor");

        cronScheduler.schedule("CreateActor", createActor, "create");
        cronScheduler.schedule("ReadActor", readActor, "read");
        cronScheduler.schedule("UpdateActor", updateActor, "update");
        cronScheduler.schedule("DeleteActor", deleteActor, "delete");

        LOGGER.info("isStarted:{}, isInStandby:{}, size:{}",
                cronScheduler.isStarted(),
                cronScheduler.isInStandbyMode(),
                cronScheduler.runningJobs().size());
    }

    private static void invokeWith(Runnable runner) {
        try {
            runner.run();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
