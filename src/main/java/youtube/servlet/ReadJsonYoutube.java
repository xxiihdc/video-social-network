package youtube.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import javax.management.RuntimeErrorException;

import org.json.JSONObject;

import model.Video;

public class ReadJsonYoutube {
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	private static String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("UTF-8")));
			String jsonText = readAll(reader);
			return jsonText;
		} finally {
			if (reader != null)
				reader.close();
		}
	}

	public static Video getVideo(String url) {
		String id = getId(url);
		System.out.println(id);
		String api = "https://www.googleapis.com/youtube/v3/videos?part=snippet&id="+id+"&key=AIzaSyCtMAfiEhp5GabGWi--a8CIQj2803yoFjk";
		try {
			String data = ReadJsonYoutube.readUrl(api);
			JSONObject res = new JSONObject(data);
			String title = res.getJSONArray("items").getJSONObject(0).getJSONObject("snippet").getString("title");
			String img = res.getJSONArray("items").getJSONObject(0).getJSONObject("snippet").getJSONObject("thumbnails")
					.getJSONObject("high").getString("url");
			String des = res.getJSONArray("items").getJSONObject(0).getJSONObject("snippet").getString("description");
			
			System.out.println("hoài đức");
			//long totalResult = res.getJSONObject("pageInfo").getLong("totalResults");
			//System.out.println(totalResult);
			Video video = new Video();
			video.setActive(true);
			video.setDescription(des);
			video.setTitle(title);
			video.setViews(0);
			video.setPoster(img);
			video.setId(id);
			System.out.println(video.getTitle());
			return video;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeErrorException(null);
		}
	}
	private static String getId(String url) {
		try {
			int equal = url.indexOf("=");
			return url.substring(equal+1,equal+12);
		}catch(Exception e) {
			throw new RuntimeErrorException(null);
		}
		
	}

}
