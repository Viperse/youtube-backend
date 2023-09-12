package com.kh.youtube.service;

import com.kh.youtube.domain.CommentLike;
import com.kh.youtube.domain.VideoLike;
import com.kh.youtube.repo.VideoLikeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoLikeService {

    @Autowired
    private VideoLikeDAO dao;

    public List<VideoLike> showAll() {
        return dao.findAll();
    }

    public VideoLike show(int VLikeCode) {
        return dao.findById(VLikeCode).orElse(null);
    }

    public VideoLike create(VideoLike videoLike) {
        return dao.save(videoLike);
    }

    public VideoLike update(VideoLike videoLike) {
        VideoLike target =  dao.findById(videoLike.getVLikeCode()).orElse(null);
        if(target != null) {
            return dao.save(videoLike);
        }
        return null;
    }

    public VideoLike delete(int VLikeCode) {
        VideoLike videoLike = dao.findById(VLikeCode).orElse(null);
        dao.delete(videoLike);
        return videoLike;
    }


}
