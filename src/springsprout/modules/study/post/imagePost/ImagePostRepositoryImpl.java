package springsprout.modules.study.post.imagePost;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import springsprout.common.dao.HibernateGenericDao;
import springsprout.domain.study.board.ImagePost;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: whiteship
 * Date: 2010. 10. 14
 * Time: 오후 2:50:05
 */
@Repository
public class ImagePostRepositoryImpl extends HibernateGenericDao<ImagePost> implements ImagePostRepository {

	public List<ImagePost> getRootPostList( int start, int limit, int studyId) {
		return getCriteria().addOrder(Order.desc("createdAt"))
			.setFirstResult(start).setMaxResults(limit)
			.add(Restrictions.eq("rootStudy.id", studyId)).list();
	}
}
