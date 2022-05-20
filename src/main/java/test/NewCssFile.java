package test;

import java.io.IOException;
import java.util.Date;

public class NewCssFile {
	public static void main(String[] args) throws IOException {
//		File inputFile = new File("E:\\ki5\\sof304\\pd04166.asm\\src\\main\\webapp\\dist\\css\\adminlte.min.jsp");
//		File tempFile = new File("E:\\ki5\\sof304\\pd04166.asm\\src\\main\\webapp\\dist\\css\\temp.txt");
//		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
//		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
//		String lineToRemove = ".dark-mode";		
//		String currentLine;
//		while((currentLine = reader.readLine()) != null) {
//		    if(currentLine.contains(lineToRemove)) break;
//		    writer.write(currentLine + System.getProperty("line.separator"));
//		}
//		writer.close(); 
//		reader.close(); 
		Date date = new Date();
		System.out.println(date.getTime());
	}
	
}
