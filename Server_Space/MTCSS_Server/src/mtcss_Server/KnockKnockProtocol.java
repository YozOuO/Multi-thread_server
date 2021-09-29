package mtcss_Server;

public class KnockKnockProtocol {
    private static final int WAITING = 0;
    private static final int SENTKNOCKKNOCK = 1;
    private static final int SENTCLUE = 2;
    private static final int ANOTHER = 3;

    private static final int NUMJOKES = 5;

    private int state = WAITING;
    private int currentJoke = 0;

    private String[] clues = { "Turnip", "Little Old Lady", "Atch", "Who",
"Who" };
    private String[] answers = { "Turnip the heat, it's cold in here!",
                                 "I didn't know you could yodel!",
                                 "Bless you!",
                                 "Is there an owl in here?",
                                 "Is there an echo in here?" };

    public String processInput(String theInput) {
    	
        String theOutput = null;
        theOutput = conversion(theInput);
        return theOutput;
    }
    private static String conversion(String message)
	{
		int ascii = 0;
		char tChar;
		String newMessage = "";
		if(message!=null)
		{
			for(int i=0;i<message.length();i++)
			{
				tChar = message.charAt(i);
				ascii = (int)tChar;
				if(ascii>=97&&ascii<=122)
				{
					ascii = ascii-32;
					tChar = (char)ascii;
				}
				else if(ascii>=65&&ascii<=90)
				{
					ascii = ascii+32;
					tChar = (char)ascii;
				}
				//tArray[i]=tChar;
				newMessage = newMessage + (""+tChar);
			}
		}
		else
		{
			newMessage = "Server is already.";
		}
		
		
		
		System.out.println("Input: "+message);
		System.out.println("Output: "+newMessage);
		
		return newMessage;
	}
}


