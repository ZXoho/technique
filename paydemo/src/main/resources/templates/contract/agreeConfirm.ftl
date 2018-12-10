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
                <form class="form-horizontal">
                    <div class="control-group">
                        <label class="control-label" for="inputEmail">商户号</label>
                        <div class="controls">
                            <input id="meruserid" type="text" value="${params[/"meruserid/"]}"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">支付方式</label>
                        <div class="accttype">
                            <input id="accttype" type="text" value="${[/"params.accttype/"]}"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">银行卡号</label>
                        <div class="controls">
                            <input id="acctno" type="text" value="${[/"params.acctno/"]}"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">身份证号</label>
                        <div class="controls">
                            <input id="idno" type="text" value="${[/"params.idno/"]}"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">户名</label>
                        <div class="controls">
                            <input id="acctname" type="text" value="${["/params.acctname/"]}"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">银行预留电话</label>
                        <div class="controls">
                            <input id="mobile" type="text" value="${[/"params.mobile/"]}"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">安全码</label>
                        <div class="controls">
                            <input id="cvv2" type="text" value="${[/"params.cvv2/"]}"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">有效期</label>
                        <div class="controls">
                            <input id="validdate" type="text" value="${[/"params.validdate/"]}"/>
                        </div>
                    </div>
                    <div class="control-group">
                    <label class="control-label" for="inputPassword">验证码</label>
                    <div class="controls">
                    <input id="smscode" type="text"/>
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
