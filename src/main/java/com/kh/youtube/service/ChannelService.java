package com.kh.youtube.service;

import com.kh.youtube.domain.Channel;
import com.kh.youtube.domain.Member;
import com.kh.youtube.repo.ChannelDAO;
import com.kh.youtube.repo.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    @Autowired
    private ChannelDAO channelDao;

    @Autowired
    private MemberDAO memberDao;

    public List<Channel> showAll() {
        return channelDao.findAll();
    }

    public Channel show(int channelCode)  {
        Channel channel = channelDao.findById(channelCode).orElse(null);
        Member member = memberDao.findById(channel.getMember().getId()).orElse(null);
        channel.setMember(member);
        return channel;
    }

    public Channel create(Channel channel) {
        return channelDao.save(channel);
    }

    public Channel update(Channel channel) {
        Channel target = channelDao.findById(channel.getChannelCode()).orElse(null);
        if(target != null) {
            return channelDao.save(channel);
        }
        return null;
    }

    public Channel delete(int channelCode) {
        Channel target = channelDao.findById(channelCode).orElse(null);
        channelDao.delete(target);
        return target;
    }

    public List<Channel> showMember(String id) {
        return channelDao.findByMemberId(id);
    }

}
