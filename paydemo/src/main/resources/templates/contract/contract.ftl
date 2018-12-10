<!-- 又到了蓝瘦的前端创作时间<div class="container-fluid" -->
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
                <form  role="form" action="/contract/agreeapply" method="post">
                    <div class="control-group">
                        <label class="control-label">商户号</label>
                        <div class="controls">
                            <input name="merUserId" type="text" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">支付方式</label>
                        <div class="controls">
                            <input name="acctType"  type="text"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">银行卡号</label>
                        <div class="controls">
                            <input name="acctno"  type="text"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">身份证号</label>
                        <div class="controls">
                            <input name="idno"  type="text"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">户名</label>
                        <div class="controls">
                            <input name="acctName"  type="text"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" >银行预留电话</label>
                        <div class="controls">
                            <input name="mobile"  type="text"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" >安全码</label>
                        <div class="controls">
                            <input name="cvv2"  type="text"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" >有效期</label>
                        <div class="controls">
                            <input name="validDate"  type="text"/>
                        </div>
                    </div>
                    <#--<div class="control-group">-->
                        <#--<label class="control-label" for="inputPassword">验证码</label>-->
                        <#--<div class="controls">-->
                            <#--<input id="smscode" type="text" />-->
                        <#--</div>-->
                    <#--</div>-->
                    <div class="form-group">
                        <div class="controls">
                            <button type="submit" class="btn">获取验证码</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    </div>
</div>
</body>
</html>

