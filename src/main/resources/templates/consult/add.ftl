<!DOCTYPE html>
<html>
<head>
    <#include "../common/head.ftl"/>
    <link rel="stylesheet" href="/static/css/public.css" media="all">
</head>
<body>
<div class="layui-form layuimini-form">
    <div class="layui-form-item">
        <label class="layui-form-label required">Account</label>
        <div class="layui-input-block">
            <input type="text" name="name" lay-verify="name"
                   placeholder="please type in account" value=""
                   class="layui-input">
            <tip> client name , eg: JackMa</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">Gender</label>
        <div class="layui-input-block">
            <input type="radio" name="gender" value="1" title="Male" checked="">
            <input type="radio" name="gender" value="0" title="Female">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">Contact</label>
        <div class="layui-input-block">
            <input type="text" name="phone" lay-verify="contact" value=""
                   placeholder="please type in contact"
                   class="layui-input">
            <tip> mobile or phone number , eg: 16131213213 (mobile) or 86453123 (phone)</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">Email</label>
        <div class="layui-input-block">
            <input type="text" name="email" placeholder="please type in email" lay-verify="myEmail"
                   value="" class="layui-input">
            <tip> not required . eg: JackMa@ASL.com.hk</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">Type</label>
        <div class="layui-input-block">
            <input type="radio" name="type" value="1" title="Consult" checked="">
            <input type="radio" name="type" value="2" title="Suggestion">
            <input type="radio" name="type" value="3" title="Other">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">Purpose</label>
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
        <label class="layui-form-label required">Description</label>
        <div class="layui-input-block">
            <textarea name="content" lay-verify="description" class="layui-textarea"
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
            var formData = data.field;
            $.post("/item", formData, (res) => {
                var {code, data, desc} = res;
                if (0 === code) {
                    layer.msg('submit success', {
                        icon: 1,
                        shade: 0.8,
                        time: 1000 //2秒关闭（如果不配置，默认是3秒）
                    }, function () {
                        //do something
                        var iframeIndex = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(iframeIndex);
                    });
                } else {
                    layer.msg('warning , detail : ' + desc, {
                        icon: 3,
                        time: 2000 //2秒关闭（如果不配置，默认是3秒）
                    }, function () {
                    });
                }
            });
            return false;
        });

        form.verify({
            name: function (value, item) { //value：表单的值、item：表单的DOM对象
                // rule0:can not be empty
                if (!value) {
                    return 'account can not be empty';
                }
                // rule1:no number
                if (/^\d+\d+\d$/.test(value)) {
                    return 'account can not be number';
                }
                // rule2: size 4-20
                var length = value.length;
                if (value && (length > 20 || length < 4)) {
                    return 'account size should be between 4 and 20 characters ';
                }
            },
            contact: function (value, item) { //value：表单的值、item：表单的DOM对象
                // rule0:can not be empty
                if (!value) {
                    return 'contact can not be empty';
                }
                // rule1: number
                if (!(/^\d+\d+\d$/.test(value))) {
                    return 'contact should be number';
                }
                // rule2: size 4-20
                var length = value.length;
                if (value && (length > 20 || length < 4)) {
                    return 'contact size should be between 4 and 20 characters ';
                }
            },
            description: function (value, item) { //value：表单的值、item：表单的DOM对象
                // rule0:can not be empty
                if (!value) {
                    return 'description can not be empty';
                }
                // rule1: size 15-500
                var length = value.length;
                if (value && (length > 500 || length < 15)) {
                    return 'description size should be between 15 and 500 characters ';
                }
            },
            myEmail: function (value, item) {
                var pattern = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
                var flag = pattern.test(value);
                if (value && !flag) {
                    return 'email pattern is xxxx@xxxx.com';
                }
            }
        });

    });
</script>
</body>
</html>
