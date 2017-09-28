package com.nduyhai.simulator.repository;

import com.nduyhai.simulator.entity.ApiEntity;
import com.nduyhai.simulator.entity.ApiKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ApiRepository extends CrudRepository<ApiEntity, ApiKey> {
}
