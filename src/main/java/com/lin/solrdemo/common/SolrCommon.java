package com.lin.solrdemo.common;

import java.util.HashMap;
import java.util.List;

/**
 * solr CURD common interface
 */
public interface SolrCommon<T> {

    /**
     *  solr query list
     */
    public List<T> findSimpleList(HashMap<String,Object> query,List<String> fields);

    /**
     *  solr find page
     */
    public List<T> findByPage(HashMap<String,Object> query);

    /**
     * solr update
     */
    public Boolean partUpdate(HashMap<String,Object> update);
}
