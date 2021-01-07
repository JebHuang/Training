<!DOCTYPE html>
<html>
<head>
    <#include "./common/head.ftl"/>
    <style>
        .my-body {
            left: 0;
        }
    </style>
</head>
<body class="layui-layout-body layuimini-all">
<div class="layui-body my-body">
    <h1>Welcome</h1>
</div>
<#include "./common/js.ftl"/>
<script>
    layui.use(['jquery', 'layer'], function () {
        var $ = layui.jquery,
            layer = layui.layer;

    });
</script>
</body>
</html>
