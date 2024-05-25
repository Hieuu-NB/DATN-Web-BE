package com.example.springserver.service.comment;

import com.example.springserver.dto.response.CmtTruyen;
import com.example.springserver.dto.response.ResultDto;
import com.example.springserver.entity.truyen_onl.Comments;
import com.example.springserver.entity.truyen_onl.TrangTruyenOnl;
import com.example.springserver.entity.truyen_onl.TruyenOnl;
import com.example.springserver.repository.CommentRepository;
import com.example.springserver.repository.TruyenOnlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final CommentRepository commentRepository;
    private final TruyenOnlRepository truyenOnlRepository;
    @Override
    public ResultDto comment(CmtTruyen cmt) {
        try {
            TruyenOnl truyenOnl = new TruyenOnl();
            Comments comments = new Comments();
            comments.setNoi_dung(cmt.getCmt()); // lưu cmt của dto vào obj
            List l = new ArrayList<Comments>();
            List x = new ArrayList<Comments>();
            l.add(comments);
            truyenOnl.setId(cmt.getId_truyen());
            truyenOnl.setListTruyen(x);
            truyenOnlRepository.save(truyenOnl);
//            commentRepotruyenOnl = {TruyenOnl@12224} "TruyenOnl(id=1, tenTruyen=null, tenChap=null, linkAnh=null, content=null, listTruyen=null, cmt=[Comments(id=null, noi_dung=hay qqua, luotThich=null, thoi_gian_cmt=null, truyenOnl=null)])"sitory.save(c);
        }catch (Exception e){
            return ResultDto.builder().code(400).message(e.getMessage()).build();
        }
        return ResultDto.builder().code(200).message("comment thanh cong").build();
    }

    @Override
    public ResultDto comment1(CmtTruyen cmt) {
        try {
           Comments comments = new Comments();
//            TrangTruyenOnl trangTruyenOnl = new TrangTruyenOnl();
            TruyenOnl x = new TruyenOnl();
            x.setId(cmt.getId_truyen());
           comments.setNoi_dung(cmt.getCmt());
           comments.setTruyenOnl(x);
           commentRepository.save(comments);
        }catch (Exception e){
            return ResultDto.builder().code(400).message(e.getMessage()).build();
        }
        return ResultDto.builder().code(200).message("comment thanh cong").build();
    }

    @Override
    public List<String> listCmt() {
        List<Comments> list = commentRepository.findAll();
        List<String> lsCmt = new ArrayList<>();
        for (int i = 0 ; i< list.size() ; i++){
            lsCmt.add(list.get(i).getNoi_dung());
        }
        return lsCmt;
    }
}
