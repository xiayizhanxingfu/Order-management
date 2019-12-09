var baseUrl = "http://localhost:8080/test/";

//获取cookie
function getCookie(name) {
    var variates = document.cookie.split(";");
    for (var i = 0; i < variates.length; i++) {
        var s = variates[i].split("=");
        if (s[0] === name) {
            return unescape(s[1]);
        }
    }
    return 'undefined';
}

//设置cookie
function setCookie(name, value, time) {
    console.log(value);
    var nowtime = new Date().getTime();
    nowtime += time;
    document.cookie = name + "=" + escape(value) + ";expires=" + new Date(nowtime) + ";path=/;";
}

//初始化
function init() {
    //账号名
    if (getCookie('users') !== "undefined") {
        $("#user > div:nth-child(2) > p:nth-child(1)").text(getCookie('users'));
    } else {
        $("#user > div:nth-child(2) > p:nth-child(1)").text('请登录');
    }
    //登录
    $("#login").on("click", function () {
        window.location.href = baseUrl + "login.html";
    });
    //注销账号
    $("#exit").on("click", function () {
        setCookie("users", "", -1);
        $("#user > div:nth-child(2) > p:nth-child(1)").text('请登录');
    });
}

//分页视图
function pageinfoView(json) {
    var list = "";
    console.log(json);
    console.log(json.pageinfo.navigatepageNums.length);

    for (var i = 0; i < json.pageinfo.navigatepageNums.length; i++) {
        if (json.pageinfo.navigatepageNums[i] === json.pageinfo.pageNum) {
            list += "<a style='color: black' page='" + json.pageinfo.navigatepageNums[i] + "'>" + json.pageinfo.navigatepageNums[i] + "</a>";
        } else {
            list += "<a page='" + json.pageinfo.navigatepageNums[i] + "'>" + json.pageinfo.navigatepageNums[i] + "</a>";
        }
    }
    var view = "";
    if (json.pageinfo.prePage === 0) {
        view = "<span page='1'>首页</span>";
    } else {
        view = "<span page='" + json.pageinfo.prePage + "'>上一页</span>";
    }
    view += list;
    if (json.pageinfo.nextPage === 0) {
        view += "<span page='" + json.pageinfo.pageNum + "'>尾页</span>";
    } else {
        view += "<span page='" + json.pageinfo.nextPage + "'>下一页</span>";
    }
    return view;
}