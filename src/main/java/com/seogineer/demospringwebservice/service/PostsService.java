package com.seogineer.demospringwebservice.service;

import com.seogineer.demospringwebservice.domain.posts.PostsRepository;
import com.seogineer.demospringwebservice.dto.posts.PostsMainResponseDto;
import com.seogineer.demospringwebservice.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public Page<PostsMainResponseDto> findAll(Pageable pageable) {
        int page = pageable.getPageNumber() == 0 ? 0 : pageable.getPageNumber() - 1;
        pageable = PageRequest.of(page, 10);
        return postsRepository.findAll(pageable)
                .map(PostsMainResponseDto::new);
    }
}

