<!DOCTYPE html>
<html>
<head>
    <#include "../common/head.ftl"/>
    <link rel="stylesheet" href="/static/css/public.css" media="all">
</head>
<body>
<div class="layui-form layuimini-form">
    <div class="layui-form-item">
        <label class="layui-form-label required">account</label>
        <div class="layui-input-block">
            <input type="text" name="username" lay-verify="required" lay-reqtext="account can not be empty"
                   placeholder="please type in account" value=""
                   class="layui-input">
            <tip> client name , eg: JackMa</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">contact</label>
        <div class="layui-input-block">
            <input type="text" name="contact" lay-verify="required" lay-reqtext="contact can not be empty"
                   placeholder="please type in contact" value=""
                   class="layui-input">
            <tip> mobile or phone number , eg: 16131213213 (mobile) or 86453123 (phone)</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">email</label>
        <div class="layui-input-block">
            <input type="text" name="contact" placeholder="please type in email" value="" class="layui-input">
            <tip> not required . eg: JackMa@ASL.com.hk</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">type</label>
        <div class="layui-input-block">
            <input type="radio" name="type" value="1" title="consult" checked="">
            <input type="radio" name="type" value="2" title="suggestion">
            <input type="radio" name="type" value="3" title="Other">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">purpose</label>
        <div class="layui-input-block">
            <input type="radio" name="purpose" value="1" title="Deposit" checked="">
            <input type="radio" name="purpose" value="2" title="Credit Card">
            <input type="radio" name="purpose" value="3" title="Personal Loan">
            <input type="radio" name="purpose" value="4" title="Mortgage">
            <input type="radio" name="purpose" value="5" title="Investment">
            <input type="radio" name="purpose" value="6" title="Insurance">
            <input type="radio" name="purpose" value="7" title="Other">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label required">description</label>
        <div class="layui-input-block">
            <textarea name="remark" lay-verify="required" class="layui-textarea"
                      placeholder="please type in description"></textarea>
            <tip> descript the situation at least 15 characters and most 500 characters</tip>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn"> submit</button>
        </div>
    </div>
</div>
<#include "../common/js.ftl"/>
<script>
    layui.use(['form'], function () {
        var form = layui.form,
            layer = layui.layer,
            $ = layui.$;

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var index = layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            }, function () {

                // 关闭弹出层
                layer.close(index);

                var iframeIndex = parent.layer.getFrameIndex(window.name);
                parent.layer.close(iframeIndex);

            });

            return false;
        });

    });
</script>
</body>
</html>
