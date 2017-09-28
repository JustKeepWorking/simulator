package com.nduyhai.simulator.repository;

import com.nduyhai.simulator.entity.ApiEntity;
import com.nduyhai.simulator.entity.ApiKey;
import org.springframework.data.repository.CrudRepository;

public interface ApiRepository extends CrudRepository<ApiEntity, ApiKey> {
}
