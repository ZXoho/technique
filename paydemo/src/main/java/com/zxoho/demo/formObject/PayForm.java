package com.zxoho.demo.formObject;

import lombok.Data;
import lombok.NonNull;

/** 支付确认参数
 * Project: paydemo
 * Created by admin on 2018/12/11 17:26
 */
@Data
public class PayForm {

    /**
     * 订单号
     */
    @NonNull
    private String orderId;

    /**
     * 协议编号
     */
    @NonNull
    private String agreeId;

    /**
     * 短信验证码
     */
    @NonNull
    private String smsCode;

    /**
     * 交易透传信息
     */
    private String thpinfo;
}
