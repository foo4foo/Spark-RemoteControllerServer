package RemoteController;

import org.slf4j.LoggerFactory;

import config.Router;
import spark.Spark;

import org.slf4j.Logger;

public class Application {
	private final static Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
    public static void main(String[] args) {
    	Router router = new Router(LOGGER);
    	
    	Spark.port(9000);
    	
        router.applyConfig();
    }
}
