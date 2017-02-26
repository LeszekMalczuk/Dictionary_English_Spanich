package dicttionary;

//ref. for buffer and writer data into the list -- http://stackoverflow.com/questions/9961292/write-to-text-file-without-overwriting-in-java

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class HeapApp {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) throws Exception {

		Heap hp = new Heap();
		Scanner sc = new Scanner(System.in);
		LoadList loadList = new LoadList();
		Separator separator = new Separator();
		String line = null;


		do {


			System.out.println("Enter Spanish word or leter to check that your word is exist in dictionary: ");
			String input = sc.nextLine();	
			System.out.println("The best match of " +"\""+ input +"\""+" is " +"\""+ hp.bestMatch(input)+"\""+ "\n");

			System.out.println("Write the Spanish word");
			String input1 = sc.nextLine();
			System.out.println("Spanish word " + "\""+ input1 +"\""+"  in "
					+ "   English is " + "\" "+ hp.wordToWord(input1)+"\" ");



			System.out.println("Add spanish word into the list");
			String input2 = sc.nextLine();
			System.out.println("Add English word into the list");
			String input3 = sc.nextLine();
			Separator word = new Separator();
			word.spanish = (input2);   
			word.english = (input3);
			hp.addWord(word);
			
			String Data = input2 + "\t	" + input3;		//writer data into data list form scanner
			File file = new File("data.txt");
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(Data);
			bw.newLine();
			bw.close();
			
			System.out.println(hp.size());
			//		System.out.println("insert spanish word for delete");
			//		String input4 = sc.nextLine();
			//		hp.delete(word);
			//		System.out.println(hp.size());
			System.out.print("Eneter " + "\"" +"exit" + "\" "+" word to stop"
					+ " or press " + "\"" +"enter" + "\"" +" to go foword"+ "\n");
			line = sc.nextLine();
			//sc.close();
			//System.exit(0);

			//}
		} while (!line.equals("exit"));


	}}




