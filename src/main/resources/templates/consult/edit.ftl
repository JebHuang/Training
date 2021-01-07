<!DOCTYPE html>
<html>
<head>
    <#include "../common/head.ftl"/>
    <link rel="stylesheet" href="/static/css/public.css" media="all">
</head>
<body>
<div class="layui-form layuimini-form">
    <div class="layui-form-item">
        <label class="layui-form-label ">关联用户</label>
        <div class="layui-input-block">
            <input type="text" name="username"  value="陈先生" class="layui-input" disabled>
            <tip>关联用户不能修改。</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label ">联系方式</label>
        <div class="layui-input-block">
            <input type="text" name="mobile"  value="13645454646" class="layui-input" disabled>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">咨询类型</label>
        <div class="layui-input-block">
            <input type="radio" name="type" value="1" title="咨询" checked="" disabled>
            <input type="radio" name="type" value="2" title="投诉" disabled>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label required">咨询内容</label>
        <div class="layui-input-block">
            <textarea name="remark" lay-verify="required" class="layui-textarea" placeholder="请输入咨询内容" disabled>咨询内容1234567890</textarea>
            <tip>咨询内容不能修改。</tip>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">处理完成</button>
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
