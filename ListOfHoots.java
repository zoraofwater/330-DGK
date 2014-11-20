import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class ListOfHoots
{
	protected int StackSize;
	protected boolean HootStatus;
	public ListOfHoots(){
		
	}
//Adds hoot to end of list and file
	public void insert(Hoot thing){
		FileWriter out = new FileWriter("hootFile.txt",true);
		try { 
			out.write("{ " + thing.getUsername() + " ");
			if(thing.getHootStatus() == true){
				out.write("1");
			}
			else {
				out.write("0");
			}
			out.write(" STARTTHEHOOT " + thing.hot + " ENDTHEHOOT ( ");
			int taggedUsersSize = thing.getListOfUsersTagged().size();
			for(int i = 0; i < taggedUsersSize; i++){
				out.write(thing.getListOfUsersTagged()[i] + " ");
			}
			out.write(" ) [ ");
			int hashTagsSize = thing.getListOfHashtags().size();
			for(int i = 0; i < hashTagsSize; i++){
				out.write(thing.getListOfHashtags()[i] + " ");
			}
			out.write(" ] }\n");
		}finally {
			if (out != null){
				out.close();
			}
		}
	}
	
	public Hoot takeTop(){
		
	}
	
}
