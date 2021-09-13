package com.seogineer.demospringwebservice.controller;

import com.seogineer.demospringwebservice.dto.posts.PostsMainResponseDto;
import com.seogineer.demospringwebservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {
    private PostsService postsService;

    @GetMapping("/posts")
    public String main(Model model, @PageableDefault(size = 10, sort = "createdDate") Pageable pageable) {
        Page<PostsMainResponseDto> postsPage = postsService.findAll(pageable);
        model.addAttribute("posts", postsPage);
        return "main";
    }
}
