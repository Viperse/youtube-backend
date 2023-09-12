package com.kh.youtube.service;

import com.kh.youtube.domain.Subscribe;
import com.kh.youtube.repo.SubscribeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscribeService {

    @Autowired
    private SubscribeDAO dao;

    public List<Subscribe> showAll() {
        return dao.findAll();
    }

    public Subscribe show(int subscribeCode) {
        return dao.findById(subscribeCode).orElse(null);
    }

    public Subscribe create(Subscribe subscribe) {
        return dao.save(subscribe);
    }

    public Subscribe update(Subscribe subscribe) {
        Subscribe target =  dao.findById(subscribe.getSubsCode()).orElse(null);
        if(target != null) {
            return dao.save(subscribe);
        }
        return null;
    }

    public Subscribe delete(int subscribeCode) {
        Subscribe subscribe = dao.findById(subscribeCode).orElse(null);
        dao.delete(subscribe);
        return subscribe;
    }

    public List<Subscribe> findByMemberId(String id) {
        return dao.findByMemberId(id);
    }
}
