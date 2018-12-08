package com.zxoho.demo.formObject;

import lombok.Data;
import lombok.NonNull;

/**
 * Project: paydemo
 * Created by admin on 2018/12/8 15:53
 */
@Data
public class AgreeConfirmForm {

    /**
     * 商户号
     */
    @NonNull
    private String merUserId;

    /**
     * 银行卡类型
     * 00为借记卡
     * 02位信用卡
     */
    private String acctType;

    /**
     *银行卡号
     */
    @NonNull
    private String acctno;

    /**
     * 身份证号
     */
    @NonNull
    private String idno;

    /**
     * 持卡人姓名
     */
    @NonNull
    private String acctName;

    /**
     * 银行卡预留电话
     */
    @NonNull
    private String mobile;

    /**
     * 有效期
     * 信用卡不能为空
     */
    private String vailidDate;


    /**
     * 短信验证码
     */
    @NonNull
    private String smsCode;

    private String cvv2;
}

