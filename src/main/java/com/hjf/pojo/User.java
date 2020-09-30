package com.hjf.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jiang锋时刻
 * @create 2020-09-30 16:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户实体类")  // 给类加注释
public class User {
    @ApiModelProperty("用户名")    // 给属性加注释
    public String username;
    @ApiModelProperty("密码")
    public String password;
}
