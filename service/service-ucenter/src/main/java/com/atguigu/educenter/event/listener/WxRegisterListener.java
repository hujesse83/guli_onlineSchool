package com.atguigu.educenter.event.listener;

import com.atguigu.educenter.entity.em.ReportActionType;
import com.atguigu.educenter.entity.po.UcenterMember;
import com.atguigu.educenter.event.UcenterActivity;
import com.atguigu.educenter.event.UcenterEvent;
import com.atguigu.educenter.service.UcenterMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author jesse.hu
 * @date 2022/1/17 10:19
 */
@Component
@Slf4j
public class WxRegisterListener  {

    @Autowired
    private UcenterMemberService ucenterMemberService;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT, fallbackExecution = true, condition = "#event.success")
    public void handleSaveUser(final UcenterEvent event){
        log.info("handle ucenter member starts with event={} what={}",event,event.getWhat());
        UcenterActivity activity = event.getWhat();
        if (ReportActionType.SAVE_USER.equals(activity.getType())){
           log.info("begin to save ucenter member");
           ucenterMemberService.saveWxUser(event.getWhat().getUcenterMember());
        }
    }
}
