package com.woong.tacocloud.domain.repository;

import com.woong.tacocloud.domain.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long>
{
//    Taco save(Taco design);
}
