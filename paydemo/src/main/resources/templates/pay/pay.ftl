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
                <form class="form-horizontal" action="/pay/pay" method="post">
                    <div class="control-group">
                        <label class="control-label" for="inputEmail">订单号</label>
                        <div class="controls">
                            <input id="orderId" name="orderId" type="text" <#if orderid??>value="${orderid}"</#if>/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">协议编号</label>
                        <div class="controls">
                            <input id="agreeId" name="agreeId" type="text" <#if agree??>value="${agreeid}"</#if>/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">短信验证码</label>
                        <div class="controls">
                            <input id="smsCode" name="smsCode" type="text"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="inputPassword">交易透传信息</label>
                        <div class="controls">
                            <input id="thpInfo" name="thpInfo" type="text" <#if thpinfo??>value="${thpinfo}"</#if>/>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <button type="submit" class="btn">支付</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>