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
                <form class="form-horizontal" action="/pay/payApply" method="post">
                    <div class="control-group">
                        <label class="control-label" for="inputEmail">订单号</label>
                        <div class="controls">
                            <input id="orderId" name="orderId" type="text"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">协议编号</label>
                        <div class="controls">
                            <input id="agreeId" name="agreeId" type="text" />
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">订单金额</label>
                        <div class="controls">
                            <input id="amount" name="amount" type="text"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">币种</label>
                        <div class="controls">
                            <input id="currency" name="currency" type="text"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">订单内容</label>
                        <div class="controls">
                            <input id="subject" name="subject" type="text"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">有效时间</label>
                        <div class="controls">
                            <input id="validTime" name="validTime" type="text"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">交易备注</label>
                        <div class="controls">
                            <input id="trxReserve" name="trxReserve" type="text" />
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">交易通知地址</label>
                        <div class="controls">
                            <input id="notifyUrl" name="notifyUrl" type="text"/>
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
