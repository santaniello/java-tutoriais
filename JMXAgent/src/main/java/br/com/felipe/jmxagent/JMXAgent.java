package br.com.felipe.jmxagent;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.util.Map;

import javax.management.MBeanServer;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

public class JMXAgent {
	
	public static final String RMI_REGISTRY_PORT = "org.goktay.rmiregistry.port";
	public static final String RMI_SERVER_CONNECTION_PORT = "org.goktay.rmiserver.port";

	private JMXAgent(){}

	/**
	 *
	 * @param agentArgs
	 */
	public static void premain(String agentArgs) throws Throwable {
		final int rmiRegistryPort = Integer.parseInt(System.getProperty(RMI_REGISTRY_PORT, "44444"));
		final int rmiServerPort = Integer
				.parseInt(System.getProperty(RMI_SERVER_CONNECTION_PORT, (rmiRegistryPort + 1) + ""));
		final String hostname = InetAddress.getLocalHost().getHostName();
		final String publicHostName = System.getProperty("java.rmi.server.hostname", hostname);

		LocateRegistry.createRegistry(rmiRegistryPort);

		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

		Map env = null;

		// Provide the password file used by the connector server to
		// perform user authentication. The password file is a properties
		// based text file specifying username/password pairs.
		JMXServiceURL url = new JMXServiceURL("service:jmx:rmi://" + hostname + ":" + rmiServerPort + "/jndi/rmi://"
				+ hostname + ":" + rmiRegistryPort + "/jmxrmi");
		// Used only to dosplay what the public address should be
		JMXServiceURL publicUrl = new JMXServiceURL("service:jmx:rmi://" + publicHostName + ":" + rmiServerPort
				+ "/jndi/rmi://" + publicHostName + ":" + rmiRegistryPort + "/jmxrmi");

		System.out.println("Local Connection URL: " + url);
		System.out.println("Public Connection URL: " + publicUrl);
		System.out.println("Creating RMI connector server");
		JMXConnectorServer cs = JMXConnectorServerFactory.newJMXConnectorServer(url, env, mbs);
		cs.start();
	}
}