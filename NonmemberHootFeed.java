import java.io.*;
import java.io.BufferedReader.*;

class NonmemberHootFeed {
	public LinkedList HootList;
	public NonmemberHootFeed(){
		BufferedReader reader = new BufferedReader(new FileReader("hootFile.txt"));
		
		
		boolean priOrPub;
		String uName;
		String[] tUsers = new String[10];
		String[] hTags = new String[10];
		
		ListOfHoots
		
		while (reader.nextLine() != null){
			String line = reader.readLine();
			String parts[] = reader.split(" ");
			
			String hootText = "";
			String uName = "";
			
			
			int i = 0;
			int startHoot = 3;
			int endHoot = 1000;
			int endtUsers = 1000;
			int endhTags = 1000;
			int tUserIterator = 0;
			int hTagIterator = 0;
// parts[0] will always be "{"
// parts[1] will always be the username
// parts[2] will always either be "0" which is public or "1" which is private
// parts[3] will always be an open quote
// parts[4] will always be the first word in the hoot
			uName = parts[1];
			if (parts[2].compareTo("0") == 0){
				priOrPub = 0;
			}
			else {
				priOrPub = 1;
			}
			
			for (string part : parts){
				if(i >= 0 && i <= 3){
					
				}
				else if(i >= 4 && i <= endOfHoot){
					if (parts[i].compareTo("\"") == 0){
						endOfHoot = i;
					}
					else {
						hootText = hootText + " " + parts[i];
					}
				}
				else if(i > endOfHoot+1 && i < endtUsers){
					if (parts[i].compareTo(")") == 0){
						endtUser = i;
					}
					else {
						int size = parts[i].length();
						tUser[tUserIterator] = parts[i].substring(1, size-1);
						tUserIterator++;
					}
				}
				else if (i > endtUser+1 && i < endhTags){
					if (parts[i].compareTo("]") == 0){
						endhTag = i;
					}
					else {
						int size = parts[i].length();
						hTag[hTagIterator] = parts[i].substring(1, size-1);
						hTagIterator++;
					}
				}
				i++;
			}
			
			if (priOrPub == 0){
				System.out.println(uName ":");
				System.out.println(hootText + "\n\n");
				
			}
		}
	}
}
