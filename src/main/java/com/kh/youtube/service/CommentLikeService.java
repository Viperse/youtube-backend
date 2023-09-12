package com.kh.youtube.service;

import com.kh.youtube.domain.CommentLike;
import com.kh.youtube.domain.Subscribe;
import com.kh.youtube.repo.CommentLikeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentLikeService {

    @Autowired
    private CommentLikeDAO dao;

    public List<CommentLike> showAll() {
        return dao.findAll();
    }

    public CommentLike show(int commentLikeCode) {
        return dao.findById(commentLikeCode).orElse(null);
    }

    public CommentLike create(CommentLike commentLike) {
        return dao.save(commentLike);
    }

    public CommentLike update(CommentLike commentLike) {
        CommentLike target =  dao.findById(commentLike.getCommLikeCode()).orElse(null);
        if(target != null) {
            return dao.save(commentLike);
        }
        return null;
    }

    public CommentLike delete(int commentLikeCode) {
        CommentLike commentLike = dao.findById(commentLikeCode).orElse(null);
        dao.delete(commentLike);
        return commentLike;
    }
}
