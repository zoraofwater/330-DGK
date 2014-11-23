import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class ListOfHoots
{
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
			//Make an array of strings from the hoot of individual words in hoot
			String parts[] = thing.split(" ");
			int partsSize = parts.size();
			//find all tagged users
			for(int i = 0; i < partsSize; i++){
				char[] word = parts[i].toCharArray)();
				if(word[0] == '@'){
					out.write(parts[i].substring(1) + " ");	
				}
				
			}
			out.write(" ) [ ");
			//find all tagged users
			for(int i = 0; i < hashTagsSize; i++){
				char[] word = parts[i].toCharArray)();
				if(word[0] == '#'){
					out.write(parts[i].substring(1) + " ");	
				}
			}
			out.write(" ] }\n");
		}finally {
			if (out != null){
				out.close();
			}
		}
	}
	
	
	
}
