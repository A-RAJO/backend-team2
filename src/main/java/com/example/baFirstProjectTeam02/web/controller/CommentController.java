package com.example.baFirstProjectTeam02.web.controller;


import com.example.baFirstProjectTeam02.service.CommentService;
import com.example.baFirstProjectTeam02.web.dto.comment.CommentRequest;
import com.example.baFirstProjectTeam02.web.dto.comment.CommentResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/add")
    public CommentResult addComment(@RequestBody CommentRequest commentRequest){
        return commentService.addComment(commentRequest);
    }

    @PutMapping("/update/{commentNum}")
    public CommentResult updateComment(@PathVariable Integer commentNum, @RequestBody CommentRequest commentRequest){
        return commentService.updateComment(commentNum, commentRequest);
    }

    @DeleteMapping("/delete/{commentNum}")
    public String deleteComment(@PathVariable Integer commentNum){
        commentService.deleteComment(commentNum);
        return commentNum + "번 댓글이 삭제 되었습니다.";
    }
}
