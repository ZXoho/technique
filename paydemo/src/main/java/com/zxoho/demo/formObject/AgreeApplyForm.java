package com.zxoho.demo.formObject;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

/**
 * Project: paydemo
 * Created by admin on 2018/12/7 19:55
 * 签约申请参数
 */
@Data
public class AgreeApplyForm {

    /**
     * 商户号
     */
    @NotNull
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
    @NotNull
    private String acctno;

    /**
     * 身份证号
     */
    @NotNull
    private String idno;

    /**
     * 持卡人姓名
     */
    @NotNull
    private String acctName;

    /**
     * 银行卡预留电话
     */
    @NotNull
    private String mobile;

    /**
     * 有效期
     * 信用卡不能为空
     */
    private String vailidDate;

    private String cvv2 ;
}
