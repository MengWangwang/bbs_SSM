package dao;

import java.util.List;

import org.springframework.stereotype.Component;

import model.Comments;
@Component("CommentsDao")
public interface CommentsDao {
	public int addComments(Comments c);
	public void deleteComments(int newsid);
	public List<Comments> getCommentsByNewsid(int newsid);
}
