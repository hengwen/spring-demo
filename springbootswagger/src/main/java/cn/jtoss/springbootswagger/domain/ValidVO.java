package cn.jtoss.springbootswagger.domain;

import cn.jtoss.springbootswagger.annotation.EnumString;
import cn.jtoss.springbootswagger.validator.ValidGroup;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * @author jason
 */
@Data
public class ValidVO {
    @ApiModelProperty("ID")
    @Null(groups = ValidGroup.Crud.Create.class)
    @NotNull(groups = ValidGroup.Crud.Update.class, message = "ID不能为空")
    private String id;

    @ApiModelProperty(value = "应用ID",example = "cloud")
    @Null(groups = ValidGroup.Crud.Create.class)
    @NotNull(groups = ValidGroup.Crud.Update.class, message = "应用ID不能为空")
    @Length(groups = ValidGroup.Crud.Update.class, min = 6, max = 12, message = "appId长度必须位于6到12之间")
    private String appId;

    @ApiModelProperty(value = "名字")
    @NotBlank(groups = ValidGroup.Crud.Create.class, message = "名字为必填项")
    private String name;

    @ApiModelProperty(value = "邮箱")
    @Email(message = "请填写正确的邮箱地址")
    private String email;

    @ApiModelProperty(value = "性别")
    @EnumString(value = {"F", "M"}, message = "性别只允许为F或M")
    private String sex;

    @ApiModelProperty(value = "级别")
    @NotEmpty(message = "级别不能为空")
    private String level;
}
