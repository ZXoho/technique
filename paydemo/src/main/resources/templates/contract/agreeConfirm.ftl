<html lang="en">
<#include "../common/header.ftl">
<body>
<div class="container-fluid">
    <div class="row">
        <!-- 导航栏 -->
        <#include "../common/nav.ftl">
        <!-- 表单 -->
        <div class="row-fluid">
            <div class="span12">
                <form class="form-horizontal" action="/contract/agreeConfirm" method="post">
                    <div class="control-group">
                        <label class="control-label" for="inputEmail">商户号</label>
                        <div class="controls">
                            <input id="merUserId" name="merUserId" type="text" value="${meruserid}"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">支付方式</label>
                        <div class="controls">
                            <input id="acctType" name="acctType" type="text" value="${accttype}"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">银行卡号</label>
                        <div class="controls">
                            <input id="acctno" name="acctno" type="text" value="${acctno}"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">身份证号</label>
                        <div class="controls">
                            <input id="idno" name="idno" type="text" value="${idno}"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">户名</label>
                        <div class="controls">
                            <input id="acctName" name="acctName" type="text" value="${acctname}"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">银行预留电话</label>
                        <div class="controls">
                            <input id="mobile" name="mobile" type="text" value="${mobile}"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">安全码</label>
                        <div class="controls">
                            <input id="cvv2" name="cvv2" type="text" <#if cvv2??>value="${cvv2}"</#if>/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">有效期</label>
                        <div class="controls">
                            <input id="validDate" name="validDate" type="text" <#if validdate??> value="${validdate}"</#if>/>
                        </div>
                    </div>
                    <div class="control-group">
                    <label class="control-label" for="inputPassword">验证码</label>
                    <div class="controls">
                    <input id="smsCode" name="smsCode" type="text"/>
                    </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <button type="submit" class="btn">注册</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
