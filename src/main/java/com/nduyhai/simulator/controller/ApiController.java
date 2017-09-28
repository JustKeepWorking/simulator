package com.nduyhai.simulator.controller;

import com.nduyhai.simulator.entity.ApiEntity;
import com.nduyhai.simulator.entity.ApiKey;
import com.nduyhai.simulator.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class ApiController {
    public static final String API_ROOT = "/api";

    @Autowired
    private ApiRepository apiRepository;

    @RequestMapping(value = API_ROOT + "/*", method  = {GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE})
    public ResponseEntity<String> getApi(HttpServletRequest request) {
        final String requestURL = request.getRequestURL().toString();
        final String url = requestURL.substring(requestURL.lastIndexOf(API_ROOT) + API_ROOT.length());
        final String method = request.getMethod();

        final ApiKey apiKey = new ApiKey(RequestMethod.valueOf(method), url );

        return this.cache(apiKey);
    }

    @Cacheable(cacheNames = "apiCache")
    public ResponseEntity<String> cache(final ApiKey apiKey) {
        final ApiEntity api = this.apiRepository.findOne(apiKey);

        if (api == null) {
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return  new ResponseEntity<>(api.getContent(), HttpStatus.OK);
        }
    }
}
