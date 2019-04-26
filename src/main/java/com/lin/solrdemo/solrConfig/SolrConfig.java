package com.lin.solrdemo.solrConfig;

import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages = {"com.lin"})
public class SolrConfig {

    @Value("${spring.data.solr.host}")
    private String solrHost;
    @Autowired
    private SolrClient solrClient;
    @Bean
    public SolrTemplate solrTemplate() {
        System.out.println("-------------------------");
        System.out.println(solrClient);
        return new SolrTemplate(solrClient);
    }
}
