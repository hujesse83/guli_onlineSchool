package com.atguigu.educms.controller;


import com.atguigu.commonutils.R;
import com.atguigu.educms.entity.CrmBanner;
import com.atguigu.educms.service.impl.CrmBannerServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-13
 */
@RestController
@RequestMapping("/educms/banneradmin")
@CrossOrigin
public class BannerAdminController {

    @Autowired
    private CrmBannerServiceImpl crmBannerService;


    @GetMapping("pageBanner/{current}/{limit}")
    public R pageListBanner(@PathVariable long current,
                             @PathVariable long limit) {
        Page<CrmBanner> eduTeacherPage = new Page<>(current, limit);
        Page<CrmBanner> page = crmBannerService.page(eduTeacherPage, null);
        List<CrmBanner> records = page.getRecords();
        long total = page.getTotal();
        return R.ok().data("items", records).data("total", total);
    }

    //2 添加banner
    @PostMapping("addBanner")
    @CacheEvict(value = "banner",allEntries = true)
    public R addBanner(@RequestBody CrmBanner crmBanner) {
        crmBannerService.save(crmBanner);
        return R.ok();
    }

    @GetMapping("get/{id}")
    public R get(@PathVariable String id) {
        CrmBanner banner = crmBannerService.getById(id);
        return R.ok().data("item", banner);
    }

    @PutMapping("/update")
    @CacheEvict(value = "banner",allEntries = true)
    public R updateById(@RequestBody CrmBanner banner) {
        crmBannerService.updateById(banner);
        return R.ok();
    }

    @ApiOperation(value = "删除Banner")
    @DeleteMapping("/remove/{id}")
    @CacheEvict(value = "banner",allEntries = true)
    public R remove(@PathVariable String id) {
        crmBannerService.removeById(id);
        return R.ok();
    }

}

