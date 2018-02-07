package com.stylefeng.guns.rest.modular.adverse.controller;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Constraint(validatedBy = {OptionValidatorClass.class})
public @interface OptionValidator {

	/**
	 * 下拉框select的name,即父节点字典名称
	 *
	 * @return
	 */
	String parentName() default "";
    /**
     * 提示内容
     *
     * @return
     */
    String message() default "选项取值错误";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default { };
}
