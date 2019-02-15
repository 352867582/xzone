package com.xzone.admin.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.*;

public class CodeGenerator {

    /**
     * 作者名称
     */
    private static final String AUTHOR = "author";

    /**
     * mysql连接地址
     */
    private static final String URL = "jdbc:mysql://localhost:23306/zhixuehui?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";

    /**
     * 驱动名称
     */
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    /**
     * 连接数据库的用户名
     */
    private static final String USER_NAME = "zhixuehui";

    /**
     * 连接数据库的密码
     */
    private static final String PASSWORD = "zhiXuehui_1234";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
//        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        gc.setBaseResultMap(true);
        gc.setActiveRecord(true);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setBaseColumnList(true);
        mpg.setGlobalConfig(gc);
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(URL);
        dsc.setDriverName(DRIVER_NAME);
        dsc.setUsername(USER_NAME);
        dsc.setPassword(PASSWORD);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setEntity("model").setMapper("dao");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
                Map<String, Object> map = new HashMap<>();
                map.put("packageController", "com.xzone.admin." + pc.getModuleName() + ".controller");
                map.put("packageEntity", "com.xzone.xinterface." + pc.getModuleName() + ".model");
                map.put("packageService", "com.xzone.xinterface." + pc.getModuleName() + ".service");
                map.put("packageMapper", "com.xzone.xservice." + pc.getModuleName() + ".dao");
                map.put("packageServiceImpl", "com.xzone.xservice." + pc.getModuleName() + ".service.impl");
                this.setMap(map);
            }
        };

        // 如果模板引擎是 freemarker
        String mapperXmlTemplatePath = "/templates/generator/mapper.xml.ftl";
        String controllerTemplatePath = "/templates/generator/controller.java.ftl";
        String modelTemplatePath = "/templates/generator/entity.java.ftl";
        String serviceTemplatePath = "/templates/generator/service.java.ftl";
        String serviceImplTemplatePath = "/templates/generator/serviceImpl.java.ftl";
        String mapperJavaTemplatePath = "/templates/generator/mapper.java.ftl";

        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(mapperXmlTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/xService/src/main/java/com/xzone/xservice/" + pc.getModuleName()
                        + "/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        focList.add(new FileOutConfig(controllerTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/admin/src/main/java/com/xzone/admin/" + pc.getModuleName() + "/controller/" + tableInfo.getEntityName() + "Controller.java";
            }
        });

        focList.add(new FileOutConfig(modelTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/xInterface/src/main/java/com/xzone/xinterface/" + pc.getModuleName() + "/model/" + tableInfo.getEntityName() + ".java";
            }
        });

        focList.add(new FileOutConfig(serviceTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/xInterface/src/main/java/com/xzone/xinterface/" + pc.getModuleName() + "/service/" + tableInfo.getEntityName() + "Service.java";
            }
        });

        focList.add(new FileOutConfig(serviceImplTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/xService/src/main/java/com/xzone/xservice/" + pc.getModuleName()
                        + "/service/impl/" + tableInfo.getEntityName() + "ServiceImpl.java";
            }
        });

        focList.add(new FileOutConfig(mapperJavaTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/xService/src/main/java/com/xzone/xservice/" + pc.getModuleName()
                        + "/dao/" + tableInfo.getEntityName() + "Mapper.java";
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml("/templates/generator/mapper.xml");
        templateConfig.setController("/templates/generator/controller.java");
        templateConfig.setEntity("/templates/generator/entity.java");
        templateConfig.setService("/templates/generator/service.java");
        templateConfig.setServiceImpl("/templates/generator/serviceImpl.java");
        templateConfig.setMapper("/templates/generator/mapper.java");
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.xzone.xinterface.base.BaseModel");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(false);
        strategy.setSuperControllerClass("com.xzone.admin.base.BaseController");
        strategy.setInclude(scanner("表名"));
        strategy.setEntityBuilderModel(true);
//        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(false);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
