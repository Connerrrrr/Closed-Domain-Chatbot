package com.cscc01.chatbot.backend.querysystem;

import com.cscc01.chatbot.backend.indexer.LuceneFieldConstants;
import com.cscc01.chatbot.backend.model.QueryResult;
import com.ibm.watson.discovery.v1.model.QueryResponse;
import org.apache.lucene.document.Document;

public class QueryResultMapper {

    public static QueryResult fromIndexerResult(Document document) {
        return new QueryResult.Builder()
                .content(document.get(LuceneFieldConstants.CONTENT.getText()))
                .filename(document.get(LuceneFieldConstants.FILE_NAME.getText()))
                .build();

    }

    public static QueryResult fromDiscoveryResult(QueryResponse response) {
        return new QueryResult.Builder()
                .content(response.getResults().get(0).get("text").toString())
                .filename(LuceneFieldConstants.FILE_NAME.getText())
                .build();
    }
}