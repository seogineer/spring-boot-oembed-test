package com.seogineer.springbootoembedtest.service;

import com.seogineer.springbootoembedtest.common.exception.BadUriException;
import com.seogineer.springbootoembedtest.common.exception.NotSupportedUriException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class OembedService {
    public String requestOembed(String url){
        String domain;
        try {
            domain = getDomain(url);
        } catch (URISyntaxException e) {
            throw new BadUriException();
        }

        if(domain.equals("youtube")){
            return getOembedFromYoutube(url);
        } else if(domain.equals("instagram")){
//            return getOembedFromInstagram(url);
        } else if(domain.equals("twitter")) {
            return getOembedFromTwitter(url);
        } else if((domain.equals("vimeo"))){
            return getOembedFromVimeo(url);
        }

        throw new NotSupportedUriException();
    }

    private String getOembedFromVimeo(String url){
        String requestUrl = "https://vimeo.com/api/oembed.json?url=" + url;
        RestTemplate rest = new RestTemplate();
        return rest.getForObject(requestUrl, String.class);
    }

    private String getOembedFromTwitter(String url){
        String requestUrl = "https://publish.twitter.com/oembed?url=" + url;
        RestTemplate rest = new RestTemplate();
        return rest.getForObject(requestUrl, String.class);
    }

    // 2020년 oembed 정책이 변경되어 Access Token 필요
    private String getOembedFromInstagram(String url){
        String requestUrl = "https://graph.facebook.com/v14.0/instagram_oembed?&access_token={access-token}" + url;
        RestTemplate rest = new RestTemplate();
        return rest.getForObject(requestUrl, String.class);
    }

    private String getOembedFromYoutube(String url){
        String requestUrl = "https://www.youtube.com/oembed?format=json&url=" + url;
        RestTemplate rest = new RestTemplate();
        return rest.getForObject(requestUrl, String.class);
    }

    private String getDomain(String fullUrl) throws URISyntaxException {
        URI uri = new URI(fullUrl);
        String domain = uri.getHost();
        if(domain == null){
            throw new BadUriException();
        }
        if(domain.startsWith("www.")){
            domain = domain.substring(4);
        }
        if(domain.endsWith(".com")){
            domain = domain.substring(0, domain.length()-4);
        }
        return domain;
    }
}

