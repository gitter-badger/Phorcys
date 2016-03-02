//TODO: 
	//Import things like JSON reader/writer[]
	//Make more sensible classes[]
	//Make sure all content is JSON (need JSON writer in visualised process)[]
	//Actually write docs []

public class API{
	static String URL = "http://localhost:5000/events";

	/**
	 * [send description]
	 * @param paneToSend [description]
	 */
	public static void send(PaneToSend paneToSend){
		// command = json.dumps(command)
		// print("Command" + str(command))
		// req = Request(URL, 'POST')
		// req.add_header('Content-Type', 'application/text')
		// req.data = command.encode('ascii')
		// try:
		//   resp = urlopen(req)
		//   return resp != None
		// except:
		//   raise
		//   return False
	}

	/**
	 * [A UID generator]
	 * @return [A UID]
	 */
	public static long uid(){
		//Use a UID generator
		return 0;
	}

	public static long pane(String paneType, long uid, String title, String content){
		if (uid != 0){
			uid = uid();
		}
		long uid_a = uid;

		send(new PaneToSend(paneType, uid_a, title, content));

		return uid_a;
	}
}

class PaneToSend{
	String paneType;
	long uid;
	String title;
	String content;


	PaneToSend(String paneType, long uid, String title, String content) {
		this.paneType = paneType;
		this.uid = uid;
		this.title = title;
		this.content = content;
	}
}