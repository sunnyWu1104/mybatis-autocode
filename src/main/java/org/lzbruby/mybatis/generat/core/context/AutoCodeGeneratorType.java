package org.lzbruby.mybatis.generat.core.context;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * 功能描述：包名，目标文件夹，生成文件后缀，模板配置枚举类
 *
 * @author: Zhenbin.Li
 * email： lizhenbin08@sina.com
 * company：org.lzbruby
 * Date: 15/6/14 Time：08:31
 */
public enum AutoCodeGeneratorType {

    MAPPER("mapper",
            "/dao|/dao",
            "Mapper.xml|Mapper.java",
            "mapper.vm|dao.vm"),

    ORACLE_MAPPER("oracle_mapper",
            "/dao|/dao",
            "Mapper.xml|Mapper.java",
            "oracle_mapper.vm|dao.vm"),

    SERVICE("service",
            "/service|/service/impl|/service|/service/impl|/service/convert|/service/convert|/service/utils",
            "QueryService.java|QueryServiceImpl.java|OperateService.java|OperateServiceImpl.java|{domain}Convert.java|Convert.java|Util.java",
            "service_query.vm|service_query_impl.vm|service_operate.vm|service_operate_impl.vm|service_convert_domain.vm|service_convert.vm|service_utils.vm"),

    MANAGER("manage",
            "/manage|/manage/impl|/manage|/manage/impl",
            "QueryManager.java|QueryManagerImpl.java|OperateManager.java|OperateManagerImpl.java",
            "manager_query.vm|manager_query_impl.vm|manager_operate.vm|manager_operate_impl.vm"),

    CONTROLLER("controller",
            "/controller",
            "Controller.java",
            "controller.vm"),

    DOMAIN("domain",
            "/domain",
            "{domain}.java",
            "service_domain.vm"),

    VO("vo",
            "/vo",
            "VO.java",
            "query_vo.vm"),

    model("model",
            "/dao/model",
            ".java",
            "model.vm"),

    result("result",
            "/result|/result",
            "Result.java|Exception.java",
            "result.vm|exception.vm"),

    JSP("jsp",
            "/jsp|/jsp|/jsp",
            "List.jsp|List.js|Detail.jsp",
            "jsp_list.vm|js_list.vm|jsp_detail.vm"),
    ;

    /**
     * 生成文件类型
     */
    private String type;

    /**
     * 生成目标文件夹
     */
    private String targetDir;

    /**
     * 生成文件后缀
     */
    private String fileName;

    /**
     * 生成文件模板
     */
    private String template;

    AutoCodeGeneratorType(String type, String targetDir, String fileName, String template) {
        this.type = type;
        this.targetDir = targetDir;
        this.fileName = fileName;
        this.template = template;
    }

    public String getType() {
        return type;
    }

    public String getTargetDir() {
        return targetDir;
    }

    public String getFileName() {
        return fileName;
    }

    public String getTemplate() {
        return template;
    }

    /**
     * 通过类型获取对应的配置枚举
     *
     * @param type
     * @return
     */
    public static AutoCodeGeneratorType getByType(String type) {
        if (StringUtils.isBlank(type))
            return null;

        for (AutoCodeGeneratorType packageDirType : AutoCodeGeneratorType.values()) {
            if (StringUtils.equals(type, packageDirType.getType())) {
                return packageDirType;
            }
        }

        return null;
    }

    /**
     * 通过配置获取文件配置
     *
     * @return
     */
    public static String getDefaultConfigLayer() {
        List<String> configs = Lists.newArrayList();
        for (AutoCodeGeneratorType packageConfigDirType : AutoCodeGeneratorType.values()) {
            configs.add(packageConfigDirType.getType());
        }

        return Joiner.on(",").join(configs);
    }
}
