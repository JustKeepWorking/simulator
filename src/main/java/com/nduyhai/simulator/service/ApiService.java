package com.nduyhai.simulator.service;

import com.nduyhai.simulator.entity.ApiEntity;
import com.nduyhai.simulator.entity.ApiKey;
import com.nduyhai.simulator.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ApiService {
    @Autowired
    private ApiRepository apiRepository;

    @Cacheable(value="apiCache")
    public ApiEntity findOne(final ApiKey apiKey) {
        return this.apiRepository.findOne(apiKey);
    }
}
