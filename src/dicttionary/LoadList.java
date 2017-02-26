package dicttionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class LoadList
{
	ArrayList<Separator> items = new ArrayList<>(); //  //array list of words form Seperator class	
	Scanner inUsers;

	public ArrayList<Separator> addTerms() throws FileNotFoundException//Exception // // Method of split of data in string and string
	{
		File usersFile = new File("data.txt");	//it is adding  file with list of data

		inUsers = new Scanner(usersFile);

		String delims = "\t	";//each field in the file is separated(delimited) by a space.
		while (inUsers.hasNextLine()) 
		{
			// get user and rating from data source
			String userDetails = inUsers.nextLine();
			// parse user details string
			userDetails = userDetails.trim();
			String[] userTokens = userDetails.split(delims);

			// output user data to console.

			Separator word = new Separator();
			word.spanish = (userTokens[0]);   
			word.english = (userTokens[1]);			
			insert(word);
			//System.out.println(word.spanish);
		}


		inUsers.close();
		return items;
	}

	public void insert(Separator word) 
	{
		items.add(word);
		siftUp();
	}
	private void siftUp() 
	{
		int k = items.size() -1;
		while (k > 0 ) {
			int p = (k-1) /2;
			Separator item = items.get(k);
			Separator parent = items.get(p);
			if (item.compareTo(parent)> 0) 
			{
				items.set(k, parent);
				items.set(p, item);
				k = p;
			}
			else 
			{
				break;
			}
			System.out.println(item);
		}
	}



}
