package com.freedom.mybatisplus.domain;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author ：wujie
 * @date ：Created in 2020/6/11 10:46
 * @description：
 * @version:
 */
public class Sun implements Serializable {

    @NotBlank(message = "name不能为空")
    private String name;
}
