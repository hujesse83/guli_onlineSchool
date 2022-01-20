package com.atguigu.eduservice.controller.front;

import com.atguigu.commonutils.JwtUtils;
import com.atguigu.commonutils.R;
import com.atguigu.commonutils.ResultCode;
import com.atguigu.eduservice.cilent.OrderClient;
import com.atguigu.eduservice.entity.ChapterVoTree;
import com.atguigu.eduservice.entity.po.EduCourse;
import com.atguigu.eduservice.entity.vo.front.CourseFrontVo;
import com.atguigu.eduservice.entity.vo.front.CourseWebVo;
import com.atguigu.eduservice.mapStruct.FrontCourseConverter;
import com.atguigu.eduservice.service.EduChapterService;
import com.atguigu.eduservice.service.EduCourseService;
import com.atguigu.servicebase.entity.CourseOrder;
import com.atguigu.servicebase.exceptionHandler.GuliException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Result;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author jesse.hu
 * @date 2022/1/17 17:07
 */

@RestController
@RequestMapping("/eduservice/coursefront")
@CrossOrigin
public class CourseController {

    @Autowired
    private EduCourseService courseService;

    @Autowired
    private EduChapterService chapterService;

    @Autowired
    private OrderClient orderClient;

    //1 条件查询带分页查询课程
    @PostMapping("getFrontCourseList/{page}/{limit}")
    public R getFrontCourseList(@PathVariable long page, @PathVariable long limit,
                                @RequestBody(required = false) CourseFrontVo courseFrontVo) {
        Page<EduCourse> pageCourse = new Page<>(page,limit);
        Map<String,Object> map = courseService.getCourseFrontList(pageCourse,courseFrontVo);
        //返回分页所有数据
        return R.ok().data(map);
    }

    @GetMapping("/getFrontCourseInfo/{courseId}")
    public R getFrontCourseInfo(@PathVariable String courseId, HttpServletRequest httpServletRequest){
        if (Objects.equals(httpServletRequest.getHeader("token"), "")){
            throw  new GuliException(ResultCode.UN_LOGIN,"用户未登录");
        }
        // 根据课程id，编写sql语句查询课程信息
        CourseWebVo courseWebVo = courseService.getBaseCourseInfo(courseId);
        // 根据课程id查询章节和小节
        List<ChapterVoTree> chapterVideoList = chapterService.getChapterVideoByCourseId(courseId);
        // 查询是否购买
        Boolean isBuy = true;
        if (courseWebVo.getPrice().doubleValue()>0){
            String memberId = JwtUtils.getMemberIdByJwtToken(httpServletRequest);
            isBuy = orderClient.isBought(courseId, memberId);
        }
        return R.ok().data("courseWebVo",courseWebVo).data("chapterVideoList",chapterVideoList).data("isBuy",isBuy);
    }


    @GetMapping("/getCourseInfo/{id}")
    public CourseOrder getCourseInfo(@PathVariable("id") String id){
        CourseWebVo baseCourseInfo = courseService.getBaseCourseInfo(id);
        return FrontCourseConverter.INSTANCE.map(baseCourseInfo);
    }

}
