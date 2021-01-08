<!DOCTYPE html>
<html>
<head>
    <#include "../common/head.ftl"/>
    <link rel="stylesheet" href="/static/css/public.css" media="all">
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <#--        <fieldset class="table-search-fieldset">-->
        <#--            <legend>搜索信息</legend>-->
        <#--            <div style="margin: 10px 10px 10px 10px">-->
        <#--                <form class="layui-form layui-form-pane" action="">-->
        <#--                    <div class="layui-form-item">-->
        <#--                        <div class="layui-inline">-->
        <#--                            <label class="layui-form-label">用户姓名</label>-->
        <#--                            <div class="layui-input-inline">-->
        <#--                                <input type="text" name="username" autocomplete="off" class="layui-input">-->
        <#--                            </div>-->
        <#--                        </div>-->
        <#--                        <div class="layui-inline">-->
        <#--                            <button type="submit" class="layui-btn layui-btn-primary" lay-submit-->
        <#--                                    lay-filter="data-search-btn"><i class="layui-icon"></i> 搜 索-->
        <#--                            </button>-->
        <#--                        </div>-->

        <#--                    </div>-->
        <#--                </form>-->
        <#--            </div>-->
        <#--        </fieldset>-->

        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> 添加</button>
            </div>
        </script>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn layui-btn-xs data-count-edit" lay-event="handle">处理</a>
        </script>

    </div>
</div>
<#include "../common/js.ftl"/>
<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        table.render({
            elem: '#currentTableId',
            url: '/static/api/table.json',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {type: "checkbox", width: 50},
                {field: 'id', width: 80, title: 'ID', sort: true},
                {field: 'username', width: 150, title: '关联咨询用户'},
                {field: 'content', width: 200, title: '咨询内容'},
                {field: 'type', width: 130, title: '咨询类型'},
                {field: 'createDate', width: 150, title: '咨询日期'},
                {field: 'updateDate', width: 150, title: '更新日期'},
                {field: 'isDeal', width: 130, title: '处理状态'},
                {field: 'handler', width: 80, title: '处理人'},
                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,
            page: true,
            skin: 'line'
        });

        // 监听搜索操作
        form.on('submit(data-search-btn)', function (data) {
            var result = JSON.stringify(data.field);
            layer.alert(result, {
                title: '最终的搜索信息'
            });

            //执行搜索重载
            table.reload('currentTableId', {
                page: {
                    curr: 1
                }
                , where: {
                    searchParams: result
                }
            }, 'data');

            return false;
        });

        /**
         * toolbar监听事件
         */
        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'add') {  // 监听添加操作
                var index = layer.open({
                    title: '添加',
                    type: 2,
                    shade: 0.2,
                    maxmin: false,
                    maxWidth: 360,
                    maxHeight: 360,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: '/consult/add',
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            } else if (obj.event === 'delete') {  // 监听删除操作
                var checkStatus = table.checkStatus('currentTableId')
                    , data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            }
        });

        //监听表格复选框选择
        table.on('checkbox(currentTableFilter)', function (obj) {
            console.log(obj)
        });

        table.on('tool(currentTableFilter)', function (obj) {
            var data = obj.data;
            if (obj.event === 'handle') {

                var index = layer.open({
                    title: '处理',
                    type: 2,
                    shade: 0.2,
                    maxmin: true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: '/consult/edit',
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
                return false;
            } else if (obj.event === 'delete') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                });
            }
        });

    });
</script>
</body>
</html>