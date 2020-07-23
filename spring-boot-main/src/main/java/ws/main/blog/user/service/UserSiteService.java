package ws.main.blog.user.service;

import ws.main.blog.user.entity.*;

/**
 * @description: 我的博客用户信息相关
 * @author: ws
 * @create: 2020-07-20 19:39
 **/
public interface UserSiteService {
    /**
     * 查询博客的个人信息
     * @return
     */
    BlogUserSite queryUserSite();

    /**
     * 编辑博客的个人信息
     * @return
     */
    void editUserSite();
}
