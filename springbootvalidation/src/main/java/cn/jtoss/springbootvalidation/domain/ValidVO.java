package cn.jtoss.springbootvalidation.domain;

import cn.jtoss.springbootvalidation.annotation.EnumString;
import cn.jtoss.springbootvalidation.validator.ValidGroup;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * @author jason
 */
@Data
public class ValidVO {
    @Null(groups = ValidGroup.Crud.Create.class)
    @NotNull(groups = ValidGroup.Crud.Update.class, message = "ID不能为空")
    private String id;

    @Null(groups = ValidGroup.Crud.Create.class)
    @NotNull(groups = ValidGroup.Crud.Update.class, message = "应用ID不能为空")
    @Length(groups = ValidGroup.Crud.Update.class, min = 6, max = 12, message = "appId长度必须位于6到12之间")
    private String appId;

    @NotBlank(groups = ValidGroup.Crud.Create.class, message = "名字为必填项")
    private String name;

    @Email(message = "请填写正确的邮箱地址")
    private String email;

    @EnumString(value = {"F", "M"}, message = "性别只允许为F或M")
    private String sex;

    @NotEmpty(message = "级别不能为空")
    private String level;
}
