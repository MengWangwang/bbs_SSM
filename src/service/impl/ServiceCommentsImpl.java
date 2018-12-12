package service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import dao.CommentsDao;
import model.Comments;
import service.ServiceComments;

@Service("ServiceComments")
public class ServiceCommentsImpl implements ServiceComments{
	@Resource(name="CommentsDao")
	private CommentsDao cd;

	public CommentsDao getCd() {
		return cd;
	}

	public void setCd(CommentsDao cd) {
		this.cd = cd;
	}

	@Override
	public int addComments(Comments c) {
		// TODO Auto-generated method stub
		
		return cd.addComments(c);
	}

	@Override
	public void deleteComments(int newsid) {
		// TODO Auto-generated method stub
		cd.deleteComments(newsid);
	}

	@Override
	public List<Comments> getCommentsByNewsid(int newsid) {
		// TODO Auto-generated method stub
		/*SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm");*/
		
		List<Comments> lst=cd.getCommentsByNewsid(newsid);
		return lst;
	}

}
