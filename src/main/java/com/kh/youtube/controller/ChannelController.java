package com.kh.youtube.controller;

import com.kh.youtube.domain.Channel;
import com.kh.youtube.domain.Subscribe;
import com.kh.youtube.domain.Video;
import com.kh.youtube.service.ChannelService;
import com.kh.youtube.service.SubscribeService;
import com.kh.youtube.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/*")
public class ChannelController {

    @Autowired
    public ChannelService channel;
    @Autowired
    public SubscribeService subscribe;
    @Autowired
    public VideoService video;

    // 채널 조회 : GET http://localhost:8080/api/channel/1
    @GetMapping("/channel/{id}")
    public ResponseEntity<Channel> showChannel(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(channel.show(id));
    }
    // 채널에 있는 영상 조회 : GET http://localhost:8080/api/channel/1/video
    @GetMapping("/channel/{id}/video")
    public ResponseEntity<List<Video>> channelVideoList(@PathVariable int id) {
        // SELECT * FROM video WHERE channel_code = ?
        return ResponseEntity.status(HttpStatus.OK).body(video.findByChannelCode(id));
    }

    // 채널 추가 : POST http://localhost:8080/api/channel
    @PostMapping("/channel")
    public ResponseEntity<Channel> createChannel(@RequestBody Channel vo) {
        return ResponseEntity.status(HttpStatus.OK).body(channel.create(vo));
    }
    // 채널 삭제 : DELETE //localhost:8080/api/channel/1
    @DeleteMapping("/channel/{id}")
    public ResponseEntity<Channel> deleteChannel(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(channel.delete(id));
    }
    // 채널 수정 : PUT http://localhost:8080/api/channel
    @PutMapping("/channel")
    public ResponseEntity<Channel> updateChannel(@RequestBody Channel vo) {
        return ResponseEntity.status(HttpStatus.OK).body(channel.update(vo));
    }
    // 내가 구독한 채널 조회 GET http://localhost:8080/api/subscribe/user1
    @GetMapping("/subscribe/{user}")
    public ResponseEntity<List<Subscribe>> showSubscribeChannel(@PathVariable String user) {
        // SELECT * FROM subscribe WHERE id = ?
        return ResponseEntity.status(HttpStatus.OK).body(subscribe.findByMemberId(user));
    }
    // 채널 구독 : POST http://localhost:8080/api/subscribe
    @PostMapping("/subscribe")
    public ResponseEntity<Subscribe> subscribeChannel(@RequestBody Subscribe vo) {
        return ResponseEntity.status(HttpStatus.OK).body(subscribe.create(vo));
    }
    // 채널 구독 취소 : DELETE http://localhost:8080/api/subscribe/1
    @DeleteMapping("/subscribe/{id}")
    public ResponseEntity<Subscribe> deleteSubscribe(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(subscribe.delete(id));
    }
}
