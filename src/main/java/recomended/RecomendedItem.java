package recomended;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import dao.SubUserDAO;
import dao.SubVideoDAO;
import model.User;
import model.Video;
import sub.model.SubUser;
import sub.model.SubVideo;

public class RecomendedItem {
	public static List<Video> getRecomendVideo(User u) {
		try {
			DataModel model = new FileDataModel(
					new File("E:\\ki5\\sof304\\pd04166.asm\\src\\main\\webapp\\resources\\data2.csv"));
			RecommenderBuilder recommenderBuilder = new RecommenderBuilder() {
				public Recommender buildRecommender(DataModel model) throws TasteException {

					UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
					// SpearmanCorrelationSimilarity similarity = new
					// SpearmanCorrelationSimilarity(model);

					// neighborhood size = 100
					UserNeighborhood neighborhood = new NearestNUserNeighborhood(100, similarity, model);
					return new GenericUserBasedRecommender(model, neighborhood, similarity);
				}
			};
			SubUser sub = new SubUserDAO().findByUser(u.getUsername());
			Recommender recommender = recommenderBuilder.buildRecommender(model);
			List<RecommendedItem> recomendations = recommender.recommend(sub.getId(), 8);
			System.out.println(recomendations.size());
			System.out.println(sub.getId());
			//System.out.println(recommendations.size());
			List<Video> lstVideo = new ArrayList<>();
			SubVideoDAO sdao = new SubVideoDAO();
			for (RecommendedItem item : recomendations) {
				SubVideo subv = sdao.find((int) item.getItemID());
				if(subv.getVideoId().getActive()) {
					lstVideo.add(subv.getVideoId());
				}
				
			}
			return lstVideo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String args[]) throws TasteException, IOException {
		DataModel model = new FileDataModel(
				new File("E:\\ki5\\sof304\\pd04166.asm\\src\\main\\java\\resources\\data2.csv"));
		RecommenderBuilder recommenderBuilder = new RecommenderBuilder() {
			public Recommender buildRecommender(DataModel model) throws TasteException {

				UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
				// SpearmanCorrelationSimilarity similarity = new
				// SpearmanCorrelationSimilarity(model);

				// neighborhood size = 100
				UserNeighborhood neighborhood = new NearestNUserNeighborhood(100, similarity, model);
				return new GenericUserBasedRecommender(model, neighborhood, similarity);
			}
		};
		Recommender recommender = recommenderBuilder.buildRecommender(model);
		List<RecommendedItem> recomendations = recommender.recommend(27, 8);
		System.out.println(recomendations.size());
		for (RecommendedItem recommendedItem : recomendations) {
			System.out.println(recommendedItem);
		}
	}
}
