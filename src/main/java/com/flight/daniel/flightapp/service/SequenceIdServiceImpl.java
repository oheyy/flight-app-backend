package com.flight.daniel.flightapp.service;

import com.flight.daniel.flightapp.model.SequenceId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class SequenceIdServiceImpl implements SequenceIdService {

    @Autowired
    private MongoOperations mongoOperations;
    @Override
    public int getNextSequenceId(String key) throws Exception {
//        Get Sequence Id
        Query query = new Query(Criteria.where("_id").is(key));

        Update update = new Update();
        update.inc("seq", 1);

        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);

        SequenceId sequenceId = mongoOperations.findAndModify(query, update, SequenceId.class);

        if(sequenceId == null){
            throw new Exception("Unable to get sequence id for key");
        }
        return sequenceId.getSeq();
    }
}
