package com.lin.solrdemo.action;

import com.lin.solrdemo.SolrdemoApplication;
import com.lin.solrdemo.service.LazadaListingManageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SolrdemoApplication.class)
@WebAppConfiguration
public class SolrTest {
    @Autowired
    private LazadaListingManageService service;
    @Test
    public void testFindPage(){
        service.findByPage(new HashMap<>());
    }
    @Test
    public void testUpdate () {
        HashMap<String, Object> update = new HashMap<>();
        update.put("uniqueId", "TOTMOP-DD|DV7897125");
        update.put("id", 123456);
        update.put("email", "update 007 @QQ.com");
        service.partUpdate(update);
    }
    @Test
    public void testFindSimpleList() {
        HashMap<String, Object> query = new HashMap<>();
        List<String> strings = Arrays.asList("sellerSku", "siteCode");
        service.findSimpleList(query,strings);
    }
}
