package config;

import static spark.Spark.before;
import static spark.Spark.path;
import static spark.Spark.post;

import org.slf4j.Logger;

import util.Command;
import util.ShellExecuter;

public class Router {
	private final Logger LOGGER;
	
	public Router(Logger logger) {
		this.LOGGER = logger;
	}
	
	public void applyConfig() {
		path("/", () -> {
            before("*", (q, a) -> LOGGER.info("Received API call"));
            post("pause",       ShellExecuter.run(Command.pause(), "Paused"));
            post("volume_up",   ShellExecuter.run(Command.volume_up(), "Volume raised"));
            post("volume_down", ShellExecuter.run(Command.volume_down(), "Volume decreased"));
            post("rewind",      ShellExecuter.run(Command.rewind(), "Rewinded"));
            post("forward", 	ShellExecuter.run(Command.forward(), "Forwarded"));
            post("shut_down",   ShellExecuter.run(Command.shutDown(), "System halted"));
        });
	}
}
