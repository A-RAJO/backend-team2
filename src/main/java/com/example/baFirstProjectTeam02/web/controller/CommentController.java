/*package com.example.baFirstProjectTeam02.web.controller;


import com.example.baFirstProjectTeam02.service.CommentService;
import com.example.baFirstProjectTeam02.web.dto.comment.CommentDto;
import com.example.baFirstProjectTeam02.web.dto.comment.CommentRequest;
import com.example.baFirstProjectTeam02.web.dto.comment.CommentResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/comment")
public class CommentController {

    private final CommentService commentService;

//    @GetMapping("/get")
//    public List<CommentDto> getComments() {
//        return commentService.
//    }

    @PostMapping("/add")
    public CommentResult makeComment(@RequestBody CommentRequest commentRequest){
        return commentService.makeComment(commentRequest);
    }


}*/
