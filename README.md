# solrdemo
solr 实现CURD
在进行junit测试的时候会存在报错（applicationContext.xml） 或者注入失败
  原因是 RunWith(springRunner.class)容器与springboot-parent版本不匹配导致，只需要降低springboot-parent版本即可
