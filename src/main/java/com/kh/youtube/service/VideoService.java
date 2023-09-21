package com.kh.youtube.service;

import com.kh.youtube.domain.Video;
import com.kh.youtube.repo.VideoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoDAO dao;

    public Page<Video> showAll(Pageable pageable) {
        // dao.findAll() -> List<Video>
        // dao.findAll(pageable) -> Page<Video>
        return dao.findAll(pageable);
    }

    public Video show(int videoCode) {
        return dao.findById(videoCode).orElse(null);
    }

    public Video create(Video video) {
        return dao.save(video);
    }

    public Video updtae(Video video) {
        Video target = dao.findById(video.getVideoCode()).orElse(null);
        if(target != null) {
            return dao.save(video);
        }
        return null;
    }

    public Video delete(int videoCode) {
        Video video = dao.findById(videoCode).orElse(null);
        dao.delete(video);
        return video;
    }

    public List<Video> findByChannelCode(int channelCode) {
        return dao.findByChannelCode(channelCode);
    }
}
