package com.kodilla.testing.forum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ForumUser {

    private String name;
    private String realName;
    private List<ForumPost> posts = new ArrayList<>();
    private List<ForumComment> comments = new LinkedList<>();

    public ForumUser(String name, String realName) {
        this.name = name;
        this.realName = realName;
    }

    public void addPost(String author, String postBody) {
        ForumPost thePost = new ForumPost(postBody, author);
        posts.add(thePost);
    }
    public void addComment(ForumPost post, String author, String commentBody) {
        ForumComment theComment = new ForumComment(post, author, commentBody);
        comments.add(theComment);
    }

    public int getPostsQuantity() {
        return posts.size();
    }
    public int getCommentsQuantity() {
        return comments.size();
    }


    public List<ForumPost> getPosts(int postNumber) {
        return null;
    }
    public List<ForumComment> getComments(int commentNumber) {
        return null;
    }

    public ForumPost getPost(int postNumber) {
        if (postNumber >= 0 && postNumber < posts.size()) {
            return posts.get(postNumber);
        }
        return null;
    }

    public ForumComment getComment(int commentNumber) {
        ForumComment theComment = null;
        if (commentNumber >= 0 && commentNumber < comments.size()) {
            theComment = comments.get(commentNumber);
        }
        return theComment;
    }

    public boolean removePost(ForumPost post) {
        return true;
    }
    public boolean removeComment(ForumComment comment) {
        return true;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

}
