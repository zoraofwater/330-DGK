import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class ListOfHoots
{
	protected LinkedList<Hoot> HootList;
	protected int StackSize;
	protected boolean HootStatus;
	public ListOfHoots(){
		HootList = new Stack();
	}
//Adds hoot to end of list and file
	public void insert(Hoot thing){
		FileWriter fileWritter = new FileWriter("hootFile.txt",true);
		BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
		bufferWritter.write("{ " + thing.getUsername() + " ");
		if(thing.getHootStatus() == true){
			bufferWritter.write("1");
		}
		else{
			bufferWritter.write("0");
		}
		bufferWritter.write(" STARTTHEHOOT " + hootText + " ENDTHEHOOT ( ");
		//enter list of tagged users
		int taggedUsersSize = thing.getListOfUsersTagged().size();
		for(int i = 0; i < taggedUsersSize; i++){
			bufferWritter.write(thing.getListOfUsersTagged()[i] + " ");
		}
		bufferWritter.write(" ) [ ");
		
		int hashTagsSize = thing.getListOfHashtags().size();
		//enter list of hashtags
		for(int i = 0; i < hashTagsSize; i++){
			bufferWritter.write(thing.getListOfHashtags()[i] + " ");
		}
		bufferWritter.write(" ] }\n");
		HootList.push(thing);
	}

	public Hoot takeTop(){
		return HootList.pop();
	}
	
}
