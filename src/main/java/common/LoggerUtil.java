package common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoggerUtil {
	private static final String LOCATION = "E:\\ki5\\sof304\\pd04166.asm\\src\\main\\webapp\\resources\\visit\\temp-data.txt";

	public static List<String> read() {
		try {
			FileReader fr;
			fr = new FileReader(new File(LOCATION));
			BufferedReader br = new BufferedReader(fr);
			List<String> lst = new ArrayList();
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				lst.add(line);
			}
			br.close();
			fr.close();
			return lst;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void write(String[] strs) {
		StringBuilder sb = new StringBuilder();
		sb.append(strs[0]);
		sb.append("\n");
		sb.append(strs[1]);
		try {
			writeFile(sb.toString());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	private  static void writeFile(String str) throws IOException {
		FileWriter fw = new FileWriter(new File(LOCATION));
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(str);
		bw.close();
		fw.close();
	}

}
