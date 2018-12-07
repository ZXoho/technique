package com.zxoho.demo.formObject;

import lombok.Data;
import lombok.NonNull;

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

    private String cvv2;
}
