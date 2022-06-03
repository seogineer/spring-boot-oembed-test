package com.seogineer.springbootoembedtest.controller;

import com.seogineer.springbootoembedtest.service.OembedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OembedRestController {
    private final OembedService oembedService;

    @GetMapping("/oembed")
    public ResponseEntity<?> requestOembed(@RequestParam("url") String url) {
        return ResponseEntity.ok(oembedService.requestOembed(url));
    }
}