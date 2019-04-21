package util;

import java.util.function.Function;

import spark.Route;

public class ShellExecuter {
	public static Route run(Function<String, Route> command, String message) {
		return command.apply(message);
	}
}
