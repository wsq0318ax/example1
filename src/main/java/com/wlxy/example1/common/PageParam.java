package com.wlxy.example1.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.Model;
import lombok.Data;



@ApiModel(value = "PageParam",description = "分页条件参数")  //swagger注解 给该类做注释
@Data
public class PageParam<Model> {

    //@ApiModelProperty 对类里面的属性做解释
    @ApiModelProperty(value = "条件参数",name = "model")
    private Model model;

    @ApiModelProperty(value = "排序参数",name = "orderParams")
    private String[] orderParams;

    @ApiModelProperty(value = "页码",name = "pageNum")
    private int pageNum;

    @ApiModelProperty(value = "每条记录条数",name = "pageSize")
    private int pageSize;
}
