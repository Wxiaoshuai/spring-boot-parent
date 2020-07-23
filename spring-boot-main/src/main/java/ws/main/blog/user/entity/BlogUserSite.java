package ws.main.blog.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: 我的博客用户展示的相关信息，表 blog_user_site
 * @author: ws
 * @create: 2020-07-20 19:41
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogUserSite implements Serializable {

    private Integer id;

    // 头像链接
    private String avatar;

    // 格言
    private String slogan;

    // 姓名
    private String name;

    // 网址
    private String domain;

    // 提示
    private String notice;

    // 描述
    private String desc;

}
