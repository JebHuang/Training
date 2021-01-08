<!DOCTYPE html>
<html>
<head>
    <#include "../common/head.ftl"/>
    <link rel="stylesheet" href="/static/css/public.css" media="all">
    <style>
        .form_view {
            float: left;
            display: block;
            padding: 9px 0px;
            /* width: 80px; */
            font-weight: 400;
            line-height: 20px;
        }
    </style>
</head>
<body>
<div class="layui-form layuimini-form">
    <div class="layui-form-item">
        <label class="layui-form-label ">account : </label>
        <div class="layui-input-block">
            <label class="form_view">JackMa</label>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label ">contact : </label>
        <div class="layui-input-block">
            <label class="form_view">13610181213</label>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">email : </label>
        <div class="layui-input-block">
            <label class="form_view">JackMa@ASL.com.hk</label>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label ">type : </label>
        <div class="layui-input-block">
            <input type="radio" name="type" value="1" title="consult" checked="" disabled>
            <input type="radio" name="type" value="2" title="suggestion" disabled>
            <input type="radio" name="type" value="3" title="Other" disabled>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label ">purpose : </label>
        <div class="layui-input-block">
            <input type="radio" name="purpose" value="1" title="Deposit" checked="" disabled>
            <input type="radio" name="purpose" value="2" title="Credit Card" disabled>
            <input type="radio" name="purpose" value="3" title="Personal Loan" disabled>
            <input type="radio" name="purpose" value="4" title="Mortgage" disabled>
            <input type="radio" name="purpose" value="5" title="Investment" disabled>
            <input type="radio" name="purpose" value="6" title="Insurance" disabled>
            <input type="radio" name="purpose" value="7" title="Other" disabled>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label ">description : </label>
        <div class="layui-input-block">
            <label class="form_view">descript the situation at least 15 characters and most 500 characters descript the situation at least 15 characters and most 500 characters descript the situation at least 15 characters and most 500 characters descript the situation at least 15 characters and most 500 characters descript the situation at least 15 characters and most 500 characters</label>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn"> deal</button>
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
