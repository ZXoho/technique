package com.zxoho.demo.formObject;

import lombok.Data;
import lombok.NonNull;

/**
 * 支付申请参数
 * Project: paydemo
 * Created by admin on 2018/12/11 16:05
 */
@Data
public class PayApplyForm {

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
     * 订单金额
     */
    @NonNull
    private String amount;

    /**
     * 币种
     * 暂时只支持CNY
     */
    @NonNull
    private String currency;

    /**
     * 订单内容
     */
    @NonNull
    private String subject;

    /**
     * 有效时间
     */
    private String validTime;

    /**
     * 交易备注
     */
    private String trxReserve;

    /**
     * 交易通知地址
     */
    @NonNull
    private String notifyUrl;
}
