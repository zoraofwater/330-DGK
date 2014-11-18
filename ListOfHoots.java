import java.util.*;

public class ListOfHoots
{
	protected Stack<Hoot> HootStack;
	protected int StackSize;
	protected boolean HootStatus;
	protected String Username;
	public ListOfHoots(string uName){
		Username = uName;
		HootStack = new Stack();
	}

	public void insert(Hoot thing){
		HootStack.push(thing);
	}

	public Hoot takeTop(){
		return HootStackPop;
	}
	
}
