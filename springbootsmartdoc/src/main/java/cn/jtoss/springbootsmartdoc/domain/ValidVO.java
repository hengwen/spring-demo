package cn.jtoss.springbootsmartdoc.domain;

import cn.jtoss.springbootsmartdoc.annotation.EnumString;
import cn.jtoss.springbootsmartdoc.validator.ValidGroup;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * @author jason
 */
@Data
public class ValidVO {
    /**
     * id
     */
    @Null(groups = ValidGroup.Crud.Create.class)
    @NotNull(groups = ValidGroup.Crud.Update.class, message = "ID不能为空")
    private String id;

    /**
     * 应用程序id，长度必须位于6到12之间
     */
    @Null(groups = ValidGroup.Crud.Create.class)
    @NotNull(groups = ValidGroup.Crud.Update.class, message = "应用ID不能为空")
    @Length(groups = ValidGroup.Crud.Update.class, min = 6, max = 12, message = "appId长度必须位于6到12之间")
    private String appId;

    /**
     * 名字
     */
    @NotBlank(groups = ValidGroup.Crud.Create.class, message = "名字为必填项")
    private String name;

    /**
     * 邮件
     */
    @Email(message = "请填写正确的邮箱地址")
    private String email;

    /**
     * 性
     */
    @EnumString(value = {"F", "M"}, message = "性别只允许为F或M")
    private String sex;

    /**
     * 级别
     */
    @NotEmpty(message = "级别不能为空")
    private String level;
}
