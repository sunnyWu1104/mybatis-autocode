package com.oneplus.mybatis.generat.generator.impl;

import com.oneplus.mybatis.generat.generator.context.GeneratorContext;
import com.oneplus.mybatis.generat.generator.context.PackageConfigType;
import com.oneplus.mybatis.generat.utils.ConstantsType;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.VelocityContext;

/**
 * 功能描述：Controller生成器
 *
 * @author: Zhenbin.Li
 * email： lizhenbin@oneplus.cn
 * company：一加科技
 * Date: 15/6/13 Time：00:51
 */
public class ControllerGenerator extends AbstractGeneratorImpl {

    @Override
    public void initVelocityContext(VelocityContext velocityContext, GeneratorContext cxt) {
        super.initVelocityContext(velocityContext, cxt);
        String description = (String) velocityContext.get("classTitle");
        String replace = StringUtils.replace(description, "{classDescription}",
                velocityContext.get(ConstantsType.UP_CLASS_NAME.getDesc()) + "控制器");
        velocityContext.put(ConstantsType.CLASS_TITLE.getDesc(), replace);
    }

    @Override
    protected PackageConfigType getPackageConfigType() {
        return PackageConfigType.CONTROLLER;
    }

    @Override
    protected String getDescription() {
        return "控制器";
    }

}
