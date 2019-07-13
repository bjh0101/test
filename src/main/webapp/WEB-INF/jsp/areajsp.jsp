<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/8 0008
  Time: 下午 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <script src="${pageContext.request.contextPath}/res/js/jquery-3.3.1.min.js"></script>

    <script>
        $(function () {

            //发送ajax请求，加载所有省份数据
            $.get("${pageContext.request.contextPath}/selectProvince",{},function (data) {
                //[{"id":1,"name":"北京"},{"id":2,"name":"上海"},{"id":3,"name":"广州"},{"id":4,"name":"陕西"}]
                var obj = JSON.parse(data);

                //1.获取select
                var province = $("#province");

                //2.遍历json数组
                $(obj).each(function () {

                    //3.创建<option>
                    var option = "<option value='"+this.id+"'>"+this.name+"</option>";
                    //4.调用select的append追加option
                    province.append(option);
                });


            });

            $("#province").change(function () {

                $.get("${pageContext.request.contextPath}/selectCity",{id:$(this).val()},function (data) {
                    //[{"id":1,"name":"北京"},{"id":2,"name":"上海"},{"id":3,"name":"广州"},{"id":4,"name":"陕西"}]
                    var obj = JSON.parse(data);

                    //1.获取select
                    var city = $("#city");
                    city.empty();
                    city.append("<option>--请选择城市--</option>")
                    //2.遍历json数组
                    $(obj).each(function () {

                        //3.创建<option>
                        var option = "<option value='"+this.id+"'>"+this.name+"</option>";
                        //4.调用select的append追加option
                        city.append(option);
                    });


                });
            });

            $("#city").change(function () {

                $.get("${pageContext.request.contextPath}/selectCountry",{id:$(this).val()},function (data) {
                    //[{"id":1,"name":"北京"},{"id":2,"name":"上海"},{"id":3,"name":"广州"},{"id":4,"name":"陕西"}]
                    var obj = JSON.parse(data);

                    //1.获取select
                    var country = $("#country");
                    country.empty();
                    country.append("<option>--请选择区县--</option>")
                    //2.遍历json数组
                    $(obj).each(function () {

                        //3.创建<option>
                        var option = "<option value='"+this.id+"'>"+this.name+"</option>";
                        //4.调用select的append追加option
                        country.append(option);
                    });


                });
            })

        });


    </script>

</head>
<body>



<select id="province">
    <option>--请选择省份--</option>

</select>
<select id="city">
    <option>--请选择城市--</option>

</select>
<select id="country">
    <option>--请选择区县--</option>

</select>
</body>
</html>