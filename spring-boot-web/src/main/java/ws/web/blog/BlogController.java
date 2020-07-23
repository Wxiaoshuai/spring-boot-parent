package ws.web.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ws.main.blog.user.entity.BlogUserSite;
import ws.main.blog.user.service.UserSiteService;
import ws.web.util.CodeEnum;
import ws.web.util.ResponseData;


@RestController
@RequestMapping("blog")
public class BlogController {
    @Autowired
    private UserSiteService userSiteService;

    @GetMapping(value = "/queryUserSite")
    public ResponseData queryUserSite() {
        BlogUserSite blogUserSite = userSiteService.queryUserSite();
        ResponseData responseData = new ResponseData(CodeEnum.SUCCESS);
        responseData.setData(blogUserSite);
        return responseData;
    }

    @PostMapping(value = "/editUserSite", produces = "application/json;charset=UTF-8")
    public ResponseData editUserSite(@RequestBody BlogUserSite blogUserSite) {
        userSiteService.editUserSite();
        return new ResponseData(CodeEnum.SUCCESS);
    }

}
