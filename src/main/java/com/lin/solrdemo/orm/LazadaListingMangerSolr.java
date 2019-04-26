package com.lin.solrdemo.orm;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;

@SolrDocument(solrCoreName = "LazadaListingManage")
public class LazadaListingMangerSolr implements Serializable{

    @Field
    private String uniqueId;
    @Field
    private Long id;
    @Field
    private String sellerSku;
    @Field
    private String email;
    @Field
    private String siteCode;
    @Field
    private String symbol;
    @Field
    private Double quantity;
    @Field
    private Double price;
    @Field
    private String publishDate;

}
