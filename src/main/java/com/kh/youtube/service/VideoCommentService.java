package com.kh.youtube.service;

import com.kh.youtube.domain.VideoComment;
import com.kh.youtube.repo.VideoCommentDAO;
import com.kh.youtube.repo.VideoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoCommentService {

    @Autowired
    private VideoCommentDAO dao;
    @Autowired
    private VideoDAO videoDao;

    public List<VideoComment> showAll() {
        return dao.findAll();
    }

    public VideoComment show(int videoCommentCode) {
        return dao.findById(videoCommentCode).orElse(null);
    }

    public VideoComment create(VideoComment videoComment) {
        return dao.save(videoComment);
    }

    public VideoComment update(VideoComment videoComment) {
        VideoComment target = dao.findById(videoComment.getCommentCode()).orElse(null);
        if(target != null) {
            return dao.save(videoComment);
        }
        return null;
    }

    public VideoComment delete(int videoCommentCode) {
        VideoComment videoComment = dao.findById(videoCommentCode).orElse(null);
        dao.delete(videoComment);
        return videoComment;
    }

    public List<VideoComment> findByVideoCode(int videoCode) {
        return dao.findByVideoCode(videoCode);
    }
}
