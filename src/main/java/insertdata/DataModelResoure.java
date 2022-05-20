package insertdata;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DataModelResoure {
	public static void WriteLine(String[] strings) {
		String path = "src//main//java//resources//data2.csv";
		try {
			PrintWriter prin = new PrintWriter(path);
			StringBuilder sb = new StringBuilder();
			sb.append(strings[0]);//user
			sb.append(",");
			sb.append(strings[1]); //item (video)
			sb.append(",");
			sb.append(strings[2]); // rate (like: 0 = dislike ; 1 = view; 2 = like;
			sb.append("\n");
			prin.write(sb.toString());
			System.out.println("done");
			prin.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("loi");
		}
	}

	public static void AppendLine(String[] strings) {
		try {
			File file = new File("E:\\ki5\\sof304\\pd04166.asm\\src\\main\\webapp\\resources\\data2.csv");
			FileWriter pw = new FileWriter(file,true);
			StringBuilder sb = new StringBuilder();
			sb.append("\n");
			sb.append(strings[0]);
			sb.append(",");
			sb.append(strings[1]);
			sb.append(",");
			sb.append(strings[2]);
			pw.write(sb.toString());
			System.out.println("doneee");
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("loi append");
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
//		String [] str = {"foo","baz","bar"};
//		WriteLine(str);
	
	}
}
