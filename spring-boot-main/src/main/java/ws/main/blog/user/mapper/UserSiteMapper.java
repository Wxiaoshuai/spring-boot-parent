package ws.main.blog.user.mapper;

import ws.main.blog.user.entity.BlogUserSite;

/**
 * @description: 博客用户信息mapper
 * @author: ws
 * @create: 2020-07-21 09:04
 **/
public interface UserSiteMapper {
    /**
     * 查询博客的个人信息
     * @return
     */
    BlogUserSite query();
    /**
     * 编辑博客的个人信息
     * @return
     */
    void edit();

}
