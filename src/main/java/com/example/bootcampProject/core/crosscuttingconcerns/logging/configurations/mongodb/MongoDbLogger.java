package com.example.bootcampProject.core.crosscuttingconcerns.logging.configurations.mongodb;
import java.util.List;

import com.example.bootcampProject.core.crosscuttingconcerns.logging.LogDetail;
import com.example.bootcampProject.core.crosscuttingconcerns.logging.LogParameter;
import com.example.bootcampProject.core.crosscuttingconcerns.logging.LoggerServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;


@Service
public class MongoDbLogger extends LoggerServiceBase {

    private MongoTemplate mongoTemplate;

    @Autowired
    public MongoDbLogger(MongoTemplate mongoTemplate) {
        super(MongoDbLogger.class);
        this.mongoTemplate=mongoTemplate;
    }

    @Override
    public void log(String methodName, List<LogParameter> logParameters, String userName) {
        LogDetail detail = new LogDetail();
        detail.setMethodName(methodName);
        detail.setParameters(logParameters);
        detail.setUser(userName);
        info(detail.toString());
        mongoTemplate.save(detail);

    }

}