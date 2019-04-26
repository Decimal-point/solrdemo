package com.lin.solrdemo.service;

import com.lin.solrdemo.common.SolrCommon;
import com.lin.solrdemo.orm.LazadaListingMangerSolr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.PartialUpdate;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Repository
public class LazadaListingManageService implements SolrCommon<LazadaListingMangerSolr> {

    @Autowired
   private SolrTemplate solrTemplate;

    private final static String COLLECTION_NAME = "LazadaListingManage";

    @Override
    public List findByPage(HashMap query) {
        Query simpleQuery = new SimpleQuery("*:*");
        System.out.println(solrTemplate);
        ScoredPage<LazadaListingMangerSolr> listingMangerSolrs = solrTemplate.queryForPage(COLLECTION_NAME, simpleQuery, LazadaListingMangerSolr.class);
        List<LazadaListingMangerSolr> content = listingMangerSolrs.getContent();
        System.out.println("############################");
        System.out.println(content.size());
        System.out.println("############################");
        return null;
    }

    @Override
    public Boolean partUpdate(HashMap<String,Object> update) {
        Object uniqueId = update.get("uniqueId");

        if (null != uniqueId) {
            PartialUpdate uniqueId1 = new PartialUpdate("uniqueId", uniqueId);
            for (String key : update.keySet()) {
                if (!key.equals("uniqueId")) {
                    uniqueId1.add(key, update.get(key));
                }
            }
            solrTemplate.saveBean(COLLECTION_NAME, uniqueId1);
            commit();
        }
        return null;
    }

    @Override
    public List<LazadaListingMangerSolr> findSimpleList(HashMap<String, Object> query, List<String> fields) {
        SimpleQuery simpleQuery = new SimpleQuery("*:*");
        for (String field : fields) {
            simpleQuery.addProjectionOnFields(field);
        }
        ScoredPage<LazadaListingMangerSolr> lazadaListingMangerSolrs = solrTemplate.queryForPage(COLLECTION_NAME, simpleQuery, LazadaListingMangerSolr.class);
        List<LazadaListingMangerSolr> content = lazadaListingMangerSolrs.getContent();
        System.out.println("############################");
        System.out.println(content.size());
        System.out.println("############################");
        return null;
    }

    protected String say() {
        return "aa";
    }
    private void commit() {
        solrTemplate.commit(COLLECTION_NAME);
    }
}
