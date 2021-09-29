package mtcss_Server;

import java.io.*;
import java.net.*;
import java.util.*;

public class MTCSS_ServerThreads extends Thread {
    private Socket socket = null;

    public MTCSS_ServerThreads(Socket socket) {
	super("MTCSS_ServerThreads");
	this.socket = socket;
    }

    public void run() {

	try {
		
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	    BufferedReader in = new BufferedReader(
				    new InputStreamReader(
				    socket.getInputStream()));

	    String inputLine, outputLine;
	    KnockKnockProtocol kkp = new KnockKnockProtocol();
	    outputLine = kkp.processInput(null);
	    out.println(outputLine);

	    while ((inputLine = in.readLine()) != null) {
		outputLine = kkp.processInput(inputLine);
		out.println(outputLine);
		if (outputLine.equals("Bye"))
		    break;
	    }
	    out.close();
	    in.close();
	    socket.close();

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}

