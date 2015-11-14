package postbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.subethamail.smtp.MessageHandlerFactory;
import org.subethamail.smtp.helper.SimpleMessageListener;
import org.subethamail.smtp.helper.SimpleMessageListenerAdapter;
import org.subethamail.smtp.server.SMTPServer;

import postbox.interfaces.IListener;

public class PostBox {

	public static void run(int port, IListener[] listeners) {
		log("begin");
		List<SimpleMessageListener> listenerlist = new ArrayList<SimpleMessageListener>(Arrays.asList(listeners));
		MessageHandlerFactory listenerAdapter = new SimpleMessageListenerAdapter(listenerlist); 
		SMTPServer server = new SMTPServer(listenerAdapter);
		server.setPort(port);
		log("start port:" + port);
		server.start();
		log("running port:" + port);
	}

	private static void log(String msg) {
		System.out.println(LOGPREFIX + msg);
	}
	private static final String LOGPREFIX = "[PostBox] - ";

}
