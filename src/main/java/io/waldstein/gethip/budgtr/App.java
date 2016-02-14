package io.waldstein.gethip.budgtr;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.TxRunnable;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ext.ContextResolver;

public class App {
	// Base URI the Grizzly HTTP server will listen on
	public static final URI BASE_URI = URI.create("http://localhost:8080/rest/");
	private static Logger logger = LoggerFactory.getLogger(App.class);

	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		try {
			testDatabaseConnection();
			
			final HttpServer server = startServer();

			logger.info("Jersey app started with WADL available at " + BASE_URI.toString() + "application.wadl");
			System.out.println(String.format(
					"Jersey app started with WADL available at %sapplication.wadl\nStop the application by hitting enter",
					BASE_URI));

			// TODO: replace with Thread.currentThread().join(); and close application with CTRL-C
			System.in.read();
			server.shutdownNow();

		} catch (IOException ex) {
			System.out.print("There was an exception in the main method.");
		}
	}

	private static void testDatabaseConnection() throws IOException {
		EbeanServer defaultDb = Ebean.getDefaultServer();
		if (defaultDb.getAutoTune() == null){
			logger.error("Cannot reach default database.");
			throw new IOException("Cannot reach default database.");
		}
	}

	/**
	 * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
	 * application.
	 * 
	 * @return Grizzly HTTP server.
	 * @throws IOException
	 */
	public static HttpServer startServer() throws IOException {
		// create a resource config that scans for JAX-RS resources and
		// providers
		// in io.waldstein.gethip.budgtr package
		final ResourceConfig rc = new ResourceConfig().packages("io.waldstein.gethip.budgtr")
				.register(createMoxyJsonResolver());

		// create and start a new instance of grizzly http server
		// exposing the Jersey application at BASE_URI
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);

		// add shutdown hook
		createShutdownHook(server);

		server.start();

		return server;
	}

	/**
	 * Creates a Moxy JSON state resolver
	 * 
	 * @return Moxy state context resolver
	 */
	public static ContextResolver<MoxyJsonConfig> createMoxyJsonResolver() {
		// create Moxy JSON config
		final MoxyJsonConfig moxyJsonConfig = new MoxyJsonConfig();
		Map<String, String> namespacePrefixMapper = new HashMap<String, String>(1);

		// set namespace
		namespacePrefixMapper.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
		moxyJsonConfig.setNamespacePrefixMapper(namespacePrefixMapper).setNamespaceSeparator(':');

		//
		return moxyJsonConfig.resolver();
	}

	/*
	 * Adds shutdown hook to JVM that closes server when the JVM closes
	 */
	private static void createShutdownHook(final HttpServer server) {
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				server.shutdownNow();
			}
		}));
	}
}
