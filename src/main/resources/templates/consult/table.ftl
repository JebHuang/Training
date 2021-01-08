<!DOCTYPE html>
<html>
<head>
    <#include "../common/head.ftl"/>
    <link rel="stylesheet" href="/static/css/public.css" media="all">
    <style>
        .layui-card {
            border: 1px solid #f2f2f2;
            border-radius: 5px;
        }

        .icon {
            margin-right: 10px;
            color: #1aa094;
        }

        .layuimini-qiuck-module a i {
            display: inline-block;
            width: 100%;
            height: 60px;
            line-height: 60px;
            text-align: center;
            border-radius: 2px;
            font-size: 30px;
            background-color: #F8F8F8;
            color: #333;
            transition: all .3s;
            -webkit-transition: all .3s;
        }

        .layuimini-qiuck-module a cite {
            position: relative;
            top: 2px;
            display: block;
            color: #666;
            text-overflow: ellipsis;
            overflow: hidden;
            white-space: nowrap;
            font-size: 14px;
        }

        .welcome-module {
            width: 100%;
            height: 80px;
        }

        .panel {
            background-color: #fff;
            border: 1px solid transparent;
            border-radius: 3px;
            -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 1px rgba(0, 0, 0, .05)
        }

        .panel-body {
            padding: 10px
        }

        .panel-title {
            margin-top: 0;
            margin-bottom: 0;
            font-size: 12px;
            color: inherit
        }

        .label {
            display: inline;
            padding: .2em .6em .3em;
            font-size: 75%;
            font-weight: 700;
            line-height: 1;
            color: #fff;
            text-align: center;
            white-space: nowrap;
            vertical-align: baseline;
            border-radius: .25em;
            margin-top: .3em;
        }

        .main_btn > p {
            height: 40px;
        }

        .layui-bg-number {
            background-color: #F8F8F8;
        }

        .layui-form-item {
            margin-bottom: 0px;
        }

        #fieldset {
            padding-bottom: 10px;
        }

    </style>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">
        <fieldset class="table-search-fieldset" id="fieldset">
            <div class="layui-card">
                <div class="layui-card-header"><i class="fa fa-warning icon"></i> Data Panel</div>
                <div class="layui-card-body">
                    <div class="welcome-module">
                        <div class="layui-row layui-col-space10">
                            <div class="layui-col-xs6">
                                <div class="panel layui-bg-number">
                                    <div class="panel-body">
                                        <div class="panel-title">
                                            <span class="label pull-right layui-bg-blue">now</span>
                                            <h5>In Process Count</h5>
                                        </div>
                                        <div class="panel-content">
                                            <h1 class="no-margins" id="inProcessCount">-</h1>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="layui-col-xs6">
                                <div class="panel layui-bg-number">
                                    <div class="panel-body">
                                        <div class="panel-title">
                                            <span class="label pull-right layui-bg-green">now</span>
                                            <h5>Accomplish Count</h5>
                                        </div>
                                        <div class="panel-content">
                                            <h1 class="no-margins" id="accomplishCount">-</h1>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-card">
                <div class="layui-card-header"><i class="fa fa-search icon"></i> Search Panel</div>
                <div class="layui-card-body">
                    <form class="layui-form layui-form-pane" action="">
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">client</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="name" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <button type="submit" class="layui-btn layui-btn-primary" lay-submit
                                        lay-filter="data-search-btn"><i class="layui-icon"></i> search
                                </button>
                            </div>

                        </div>
                    </form>
                </div>
            </div>
        </fieldset>
        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <#if roles?contains("role_admin") || roles?contains("role_create")>
                    <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> new consult
                        <i class="layui-icon">&#xe654;</i>
                    </button>
                </#if>
            </div>
        </script>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <script type="text/html" id="currentTableBar">
            <#if roles?contains("role_admin") || roles?contains("role_process")>
                <a class="layui-btn layui-btn layui-btn-xs data-count-edit" lay-event="handle"> handle
                    <i class="layui-icon">&#xe702;</i>
                </a>
            </#if>
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
            url: '/item',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print'],
            cols: [[
                {type: "checkbox", width: 50},
                {field: 'id', width: 80, title: 'ID', sort: true},
                {field: 'name', title: 'client'},
                {field: 'phone', title: 'contact'},
                {field: 'email', width: 200, title: 'email'},
                {field: 'content', width: 300, title: 'description'},
                {field: 'type', title: 'type'},
                {field: 'createDate', width: 150, title: 'created date'},
                {field: 'updateDate', width: 150, title: 'updated date'},
                {field: 'deal', title: 'status'},
                {field: 'handlerName', width: 80, title: 'handler'},
                {title: 'operations', toolbar: '#currentTableBar', align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,
            page: true,
            request: {
                name: "text"
            },
            skin: 'line'
        });

        // //上述方法等价于
        // table.reload('currentTableId', {
        //     where: { //设定异步数据接口的额外参数，任意设
        //         name: 'xxx'
        //     }
        //     ,page: {
        //         curr: 1 //重新从第 1 页开始
        //     }
        // }); //只重载数据

        // 监听搜索操作
        form.on('submit(data-search-btn)', function (data) {
            //执行搜索重载
            table.reload('currentTableId', {
                page: {
                    curr: 1
                }
                , where: {
                    name: data.field.name
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
                    title: 'new  consult',
                    type: 2,
                    shade: 0.2,
                    maxmin: false,
                    area: ['800px', '800px'],
                    shadeClose: true,
                    content: '/consult/add',
                    end: function () {
                        refreshTableAndData();
                    }
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
                    title: 'handle',
                    type: 2,
                    shade: 0.2,
                    maxmin: false,
                    shadeClose: true,
                    area: ['800px', '800px'],
                    content: '/consult/edit?id=' + data.id,
                    end: function () {
                        refreshTableAndData();
                    }
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

        refreshData();

        function refreshData() {
            $.get("/consult/data", null, (res) => {
                var inProcessCount = res.inProcessCount ? res.inProcessCount : '-';
                var accomplishCount = res.accomplishCount ? res.accomplishCount : '-';
                $("#inProcessCount").text(inProcessCount);
                $("#accomplishCount").text(accomplishCount);
            })
        }

        function refreshTableAndData() {
            //执行搜索重载
            table.reload('currentTableId', {
                page: {
                    curr: 1
                }
                , where: {
                    name: ""
                }
            }, 'data');
            refreshData();
        }

    });

</script>
</body>
</html>
