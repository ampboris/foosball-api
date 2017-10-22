package com.wpc.foosball.foosball.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wpc.foosball.foosball.document.FoosballResult;

public interface FoosbalResultRepository extends MongoRepository<FoosballResult, String> {

}
