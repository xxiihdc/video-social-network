package insertdata;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.IRStatistics;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.eval.RecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.GenericRecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.eval.RMSRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.SpearmanCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class TestData {
	public static void main(String[] args) throws IOException, TasteException {
		DataModel datamodel = new FileDataModel(
				new File("E:\\ki5\\java4\\PD04166-Asm\\src\\main\\java\\resources\\data2.csv"));
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
		Recommender recommender = recommenderBuilder.buildRecommender(datamodel);
		List<RecommendedItem> recomendations = recommender.recommend(6, 5);
		for (RecommendedItem recommendedItem : recomendations) {
			System.out.println(recommendedItem);
		}
	}
}
