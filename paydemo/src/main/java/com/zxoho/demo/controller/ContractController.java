package com.zxoho.demo.controller;

import com.zxoho.demo.Util.CommonParam;
import com.zxoho.demo.Util.QpayConstants;
import com.zxoho.demo.Util.QpayUtil;
import com.zxoho.demo.formObject.AgreeApplyForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Project: paydemo
 * Created by admin on 2018/12/7 19:48
 * 签约
 */
@Controller
@RequestMapping("/contract")
public class ContractController {

    @PostMapping("/agreeapply")
    public ModelAndView agreeapply(@Valid AgreeApplyForm agreeApplyForm,
                                   Map<String, String> map) throws Exception{
        Map<String, String> params = CommonParam.buildCommonParamMap();
        params.put("meiuserid", agreeApplyForm.getMerUserId());
        params.put("accttype", agreeApplyForm.getAcctType());
        params.put("acctno", agreeApplyForm.getAcctno());
        params.put("idno", agreeApplyForm.getIdno());
        params.put("acctname", agreeApplyForm.getAcctName());
        params.put("mobile", agreeApplyForm.getMobile());
        params.put("cvv2", agreeApplyForm.getCvv2());
        params.put("vailiddate", agreeApplyForm.getVailidDate());
        Map<String, String> result = QpayUtil.dorequest(QpayConstants.SYB_APIURL_QPAY+"/agreeapply", params, QpayConstants.SYB_APPKEY);
        return null;
    }
}
