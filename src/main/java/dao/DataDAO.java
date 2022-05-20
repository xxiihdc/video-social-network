package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import insertdata.DataModelResoure;
import sub.model.SubUser;
import sub.model.SubVideo;

public class DataDAO {
	public Object[] getList() {
		Session session = JpaUtils.getSession();
		String nativeQuery = "select top 1 SubUsers.id as 'users id', SubVideos.id as 'item', "
				+ "				History.likes as 'value',  History.id "
				+ "				 from History inner join Users on History.username = Users.username "
				+ "				 inner join Videos on Videos.id = History.videoId "
				+ "				 inner join SubUsers on SubUsers.username = Users.username "
				+ "				 inner join SubVideos on Videos.id = SubVideos.videoId order by History.id desc";
		NativeQuery query = session.createSQLQuery(nativeQuery);
		List<Object[]> lst = query.getResultList();
		session.close();
		return lst.get(0);
	}

	public void insertDataFile() {
		Object [] objs = this.getList();
		String strs [] = {"","",""};
		for(int i = 0; i < objs.length-1; i ++) {
			strs[i] = objs[i]+"";
		}
		DataModelResoure.AppendLine(strs);
	}

	public void updateFileData(String username, String videoId, int like) {
				SubUser user = new SubUserDAO().findByUser(username);
				SubVideo video = new SubVideoDAO().findByVideo(videoId);
				String [] strs = {user.getId()+"",video.getId()+"", like+""};
				DataModelResoure.AppendLine(strs);
	}
}
