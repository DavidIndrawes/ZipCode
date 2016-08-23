package utils;

public class StartState implements State {
	
	private static State me = new StartState();
	
	private StartState(){
		
	}
	@Override
	public String handle(String pCode) {
		// first check the number of digits
		if (pCode.isEmpty()) return "Junk";
		else if (!pCode.contains(" ")) return "Space is missing the post code should contain two parts separated by space";
		else if (pCode.length()==6) return A9State.getInctance().handle(pCode);
		else if (pCode.length()==7) return AA9orA9AorA99State.getInctance().handle(pCode);
		else if (pCode.length()==8) return AA9AorAA99State.getInctance().handle(pCode);
		else return "wrong code length";
	}

	public static State getInctance() {
		return me;
	}

}
