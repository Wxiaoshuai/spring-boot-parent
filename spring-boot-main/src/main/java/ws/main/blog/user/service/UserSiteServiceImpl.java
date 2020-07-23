package ws.main.blog.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.main.blog.user.entity.BlogUserSite;
import ws.main.blog.user.mapper.UserSiteMapper;

/**
 * @description: 博客用户信息
 * @author: ws
 * @create: 2020-07-21 08:55
 **/
@Service
public class UserSiteServiceImpl implements UserSiteService{

    @Autowired
    private UserSiteMapper userSiteMapper;

    public BlogUserSite queryUserSite() {
        return userSiteMapper.query();
    }

    public void editUserSite() {
        userSiteMapper.edit();
    }
}
