package com.zxoho.demo.controller;

import com.zxoho.demo.Util.CommonParam;
import com.zxoho.demo.Util.QpayConstants;
import com.zxoho.demo.Util.QpayUtil;
import com.zxoho.demo.formObject.AgreeApplyForm;
import com.zxoho.demo.formObject.AgreeConfirmForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    /**
     * 申请签约
     *
     * @param agreeApplyForm
     * @param bindingResult
     * @return 申请确认页面
     * @throws Exception
     */
    @PostMapping("/agreeapply")
    public ModelAndView agreeapply(@Valid AgreeApplyForm agreeApplyForm,
                                   BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            Map<String, String> map = new HashMap<>();
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/common/contract");
            return new ModelAndView("/common/error", map);
        }
        Map<String, String> params = CommonParam.buildCommonParamMap();
        params.put("meruserid", agreeApplyForm.getMerUserId());
        params.put("accttype", agreeApplyForm.getAcctType());
        params.put("acctno", agreeApplyForm.getAcctno());
        params.put("idno", agreeApplyForm.getIdno());
        params.put("acctname", agreeApplyForm.getAcctName());
        params.put("mobile", agreeApplyForm.getMobile());
        if (agreeApplyForm.getCvv2().length() > 0)
            params.put("cvv2", agreeApplyForm.getCvv2());
        if (agreeApplyForm.getVailidDate() != null)
            params.put("vailiddate", agreeApplyForm.getVailidDate());

        try {
            QpayUtil.dorequest(QpayConstants.SYB_APIURL_QPAY + "/agreeapply", params, QpayConstants.SYB_APPKEY);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> result = null;
            result.put("url", "/contract/contract");
            result.put("msg", e.getMessage());
            return new ModelAndView("/common/error", result);
        }
        return new ModelAndView("/contract/agreeConfirm", params);
    }

    @PostMapping("/agreeConfirm")
    public ModelAndView agreeConfirm(@Valid AgreeConfirmForm agreeConfirmForm,
                                     BindingResult bindingResult,
                                     Map<String, String> result) {
        if (bindingResult.hasErrors()) {
            Map<String, String> map = new HashMap<>();
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/common/agreeConfirm");
            return new ModelAndView("/common/error", map);
        }
        Map<String, String> params = CommonParam.buildCommonParamMap();
        params.put("meruserid", agreeConfirmForm.getMerUserId());
        params.put("accttype", agreeConfirmForm.getAcctType());
        params.put("acctno", agreeConfirmForm.getAcctno());
        params.put("idno", agreeConfirmForm.getIdno());
        params.put("acctname", agreeConfirmForm.getAcctName());
        params.put("mobile", agreeConfirmForm.getMobile());
        if (agreeConfirmForm.getCvv2().length() > 0)
            params.put("cvv2", agreeConfirmForm.getCvv2());
        if (agreeConfirmForm.getVailidDate() != null)
            params.put("validdate", agreeConfirmForm.getVailidDate());
        params.put("smscode", agreeConfirmForm.getSmsCode());

        try {
            result = QpayUtil.dorequest(QpayConstants.SYB_APIURL_QPAY + "/agreeconfirm", params, QpayConstants.SYB_APPKEY);
            if (result.get("retcode").equals("SUCCESS") && result.get("trxstatus").equals("0000")) {
                result.put("successUrl", "/common/getIndexPage");
                return new ModelAndView("/common/success", result);

            }
            if(result.get("retcode").equals("FAIL")){
                String msg = result.get("retmsg");
                result.put("errorUrl", "/common/getContractPage");
                result.put("msg", msg);
                return new ModelAndView("/common/errors", result);
            }
            if(result.get("retcode").equals("SUCCESS") && !result.get("trxstatus").equals("0000")) {
                String msg = result.get("errmsg");
                result.put("errorUrl", "/common/getContractPage");
                result.put("msg", msg);
                return new ModelAndView("/common/errors", result);
            }
        } catch (Exception e) {
            String msg = e.getMessage();
            result.put("errorUrl", "/common/getContractPage");
            result.put("msg", msg);
            return new ModelAndView("/common/errors", result);
        }
        return null;
    }
}
