package util;

import java.util.logging.Logger;
import java.util.function.Function;

import spark.Route;

public class Command {
	private final static Logger LOGGER = Logger.getLogger(Command.class.getName());
	
	public static Function<String, Route> pause() {
		return Command.getCommand(new String[] {"xdotool", "key", "space"});
	}
	
	public static Function<String, Route> forward() {
		return Command.getCommand(new String[] {"xdotool", "key", "Right"});
	}
	
	public static Function<String, Route> rewind() {
		return Command.getCommand(new String[] {"xdotool", "key", "Left"});
	}
	
	public static Function<String, Route> volume_up() {
		return Command.getCommand(new String[] {"xdotool", "key", "XF86AudioRaiseVolume"});
	}
	
	public static Function<String, Route> volume_down() {
		return Command.getCommand(new String[] {"xdotool", "key", "XF86AudioLowerVolume"});
	}
	
	public static Function<String, Route> shutDown() {
		return Command.getCommand(new String[] {"shutdown"});
	}
	
	private static Function<String, Route> getCommand(String[] commandArgs) {
		return (String message) -> {
			return (request, response) -> {
				LOGGER.info(message);
				
				Process process = Runtime.getRuntime().exec(commandArgs);
				
				process.waitFor();
				
				return process.exitValue() == 0 ? "Successful" : "Failed";
			};
		};
	}
}
