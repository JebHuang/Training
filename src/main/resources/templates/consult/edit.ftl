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
            font-weight: 400;
            line-height: 20px;
        }
    </style>
</head>
<body>
<input type="hidden" id="id" value="${item.id!'0'}">
<div class="layui-form layuimini-form">
    <div class="layui-form-item">
        <label class="layui-form-label ">account : </label>
        <div class="layui-input-block">
            <label class="form_view">${item.name!'-'}</label>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label ">gender : </label>
        <div class="layui-input-block">
            <label class="form_view">${item.sex!'-'}</label>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label ">contact : </label>
        <div class="layui-input-block">
            <label class="form_view">${item.phone!'-'}</label>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">email : </label>
        <div class="layui-input-block">
            <label class="form_view">${item.email!'-'}</label>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label ">type : </label>
        <div class="layui-input-block">
            <input type="radio" name="type" value="1" title="Consult" disabled <#if item.type=='Consult'>checked</#if>>
            <input type="radio" name="type" value="2" title="Suggestion" disabled <#if item.type=='Suggestion'>checked</#if>>
            <input type="radio" name="type" value="3" title="Other" disabled <#if item.type=='Other'>checked</#if>>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label ">purpose : </label>
        <div class="layui-input-block">
            <input type="radio" name="purpose" value="1" title="Deposit" disabled <#if item.purpose=='Deposit'>checked</#if>>
            <input type="radio" name="purpose" value="2" title="Credit Card" disabled <#if item.purpose=='Credit Card'>checked</#if>>
            <input type="radio" name="purpose" value="3" title="Personal Loan" disabled <#if item.purpose=='Personal Loan'>checked</#if>>
            <input type="radio" name="purpose" value="4" title="Mortgage" disabled <#if item.purpose=='Mortgage'>checked</#if>>
            <input type="radio" name="purpose" value="5" title="Investment" disabled <#if item.purpose=='Investment'>checked</#if>>
            <input type="radio" name="purpose" value="6" title="Insurance" disabled <#if item.purpose=='Insurance'>checked</#if>>
            <input type="radio" name="purpose" value="7" title="Other" disabled <#if item.purpose=='Other'>checked</#if>>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label ">description : </label>
        <div class="layui-input-block">
            <label class="form_view">${item.content!'-'}</label>
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
            $.post("/item/deal", {id: $('#id').val()}, (res) => {
                var {code, data, desc} = res;
                if (0 === code) {
                    layer.msg('submit success', {
                        icon: 1,
                        shade: 0.8,
                        time: 1000 //2秒关闭（如果不配置，默认是3秒）
                    }, function () {
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

    });
</script>
</body>
</html>
