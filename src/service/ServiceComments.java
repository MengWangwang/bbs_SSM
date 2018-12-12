package service;

import java.util.List;

import model.Comments;

public interface ServiceComments {
	public int addComments(Comments c);
	public void deleteComments(int newsid);
	public List<Comments> getCommentsByNewsid(int newsid);
}
