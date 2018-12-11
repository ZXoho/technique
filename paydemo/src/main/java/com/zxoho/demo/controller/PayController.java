package com.zxoho.demo.controller;

import com.zxoho.demo.Util.CommonParam;
import com.zxoho.demo.Util.QpayConstants;
import com.zxoho.demo.Util.QpayUtil;
import com.zxoho.demo.formObject.PayApplyForm;
import com.zxoho.demo.formObject.PayForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static com.zxoho.demo.Util.QuickPayTest.buildBasicMap;

/**
 * Project: paydemo
 * Created by admin on 2018/12/11 16:14
 */

@Controller
@RequestMapping("/pay")
public class PayController {

    @PostMapping("/payApply")
    public ModelAndView payApply(@Valid PayApplyForm payApplyForm,
                                 BindingResult bindingResult,
                                 Map<String, String>map){
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/pay/payApply");
            return new ModelAndView("/common/error", map);
        }

        Map<String, String> params = CommonParam.buildCommonParamMap();
        params.put("orderid", payApplyForm.getOrderId()+System.currentTimeMillis());
        params.put("amount", payApplyForm.getAmount());
        params.put("subject", payApplyForm.getSubject());
        params.put("trxreserve", payApplyForm.getTrxReserve());
        params.put("currency", payApplyForm.getCurrency());
        params.put("validtime", payApplyForm.getValidTime());
        params.put("agreeid", payApplyForm.getAgreeId());

        try {
            Map<String, String> result = new HashMap<>();
            result = QpayUtil.dorequest(QpayConstants.SYB_APIURL_QPAY+"/payapplyagree", params,QpayConstants.SYB_APPKEY);
            if(result.get("retcode").equals("SUCCESS") && result.get("trxstatus").equals("0000")){
                String url = "/common/getPayPage";
                map.put("orderid", params.get("orderid"));
                map.put("agreeid", params.get("agreeid"));
                map.put("url", url);
                if(result.containsKey("thinfo"))
                    map.put("thpinfo", result.get("thpinfo"));
                return new ModelAndView("/common/success", map);
            }
            if(result.get("retcode").equals("SUCCESS") && !result.get("trxstatus").equals("0000")){
                String url = "/common/getPayApplyPage";
                String msg = result.get("errmsg");
                map.put("url", url);
                map.put("msg", msg);
                return new ModelAndView("/common/error", map);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String msg = e.getMessage();
            String url = "/common/getPayApplyPage";
            map.put("msg", msg);
            map.put("url", url);
            return new ModelAndView("/common/errors", map);
        }
        return null;
    }

    @PostMapping("/pay")
    public ModelAndView pay(@Valid PayForm payForm,
                            BindingResult bindingResult,
                            Map<String, String>map){
        Map<String, String> params = buildBasicMap();
        params.put("orderid", payForm.getOrderId());//payapply的单号
        params.put("agreeid",payForm.getAgreeId());//绑卡返回的agreeid
        params.put("smscode", payForm.getSmsCode());
        if(payForm.getThpinfo() != null)
            params.put("thpinfo", payForm.getThpinfo());

        try {
            Map<String, String> result = new HashMap<>();
            result = QpayUtil.dorequest(QpayConstants.SYB_APIURL_QPAY+"/payagreeconfirm", params,QpayConstants.SYB_APPKEY);
            if(result.get("retcode").equals("SUCCESS") && result.get("trxstatus").equals("0000")){
                String url = "/common/getIndexPage"; //支付成功返回首页
                map.put("url", url);
                return new ModelAndView("/common/success", map);
            }
            if(result.get("retcode").equals("SUCCESS") && !result.get("trxstatus").equals("0000")){
                String url = "/common/getPayPage"; //支付失败返回支付信息页
                String msg = result.get("errmsg");
                map.put("url", url);
                map.put("msg", msg);
                return new ModelAndView("/common/error", map);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String msg = e.getMessage();
            String url = "/common/getPayPage"; //支付失败返回支付信息页
            map.put("msg", msg);
            map.put("url", url);
            return new ModelAndView("/common/errors", map);
        }
        return null;
    }
}
