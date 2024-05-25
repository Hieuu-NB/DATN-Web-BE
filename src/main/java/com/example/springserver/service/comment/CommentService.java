package com.example.springserver.service.comment;

import com.example.springserver.dto.response.CmtTruyen;
import com.example.springserver.dto.response.ResultDto;
import com.example.springserver.entity.truyen_onl.Comments;

import java.util.List;

public interface CommentService {
    ResultDto comment(CmtTruyen cmt);
    ResultDto comment1(CmtTruyen cmt);
    List<String> listCmt();
}
