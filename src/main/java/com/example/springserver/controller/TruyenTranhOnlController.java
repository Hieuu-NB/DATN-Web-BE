package com.example.springserver.controller;

import com.example.springserver.dto.response.CmtTruyen;
import com.example.springserver.dto.response.ResultDto;
import com.example.springserver.entity.dto.KeySearch;
import com.example.springserver.entity.truyen_onl.TrangTruyenOnl;
import com.example.springserver.entity.truyen_onl.TruyenOnl;
import com.example.springserver.service.comment.CommentService;
import com.example.springserver.service.truyen_onl.TruyenOnlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/truyen-tranh-onl")
public class TruyenTranhOnlController {
    private final TruyenOnlService truyenService;
    private final CommentService commentService;
    @PostMapping("/save")
    public ResultDto save(@RequestBody TruyenOnl truyenOnl) {
        return truyenService.saveTruyen(truyenOnl);
    }
    @GetMapping("/get-all")
    public List<TruyenOnl> getAllEmployees() {
        return truyenService.showAll();
    }
    @GetMapping("/get-by-id")
    public List<TrangTruyenOnl> getTrangTruyenById(@RequestParam Long tapTruyen) {
        return truyenService.listTrangTruyenOnl(tapTruyen);
    }
//    @GetMapping("/get-by-id")
//    public ResultDto checkUser(@RequestParam Long tapTruyen) {
//        return truyenService.listTrangTruyenOnl(tapTruyen);
//        return null;
//    }
    @PostMapping("/search")
    public List<TruyenOnl> search(@RequestBody KeySearch key) {
        return truyenService.searchTruyen(key);
    }

//     comment
    @PostMapping("/comment")
    public ResultDto addComment(@RequestBody CmtTruyen cmt) {
        return commentService.comment(cmt);
    }

    @PostMapping("/comment-by-truyen")
    public ResultDto addComment1(@RequestBody CmtTruyen cmt) {
        return commentService.comment1(cmt);
    }

    @PostMapping("/show-comment-by-truyen")
    public List<String> showComment(@RequestBody String key) {
        return commentService.listCmt();
    }
}
