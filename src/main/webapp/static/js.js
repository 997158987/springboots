$(function () {
    $("#username").blur(function () {
        var username=$(this).val();
        $.ajax({
            url:"findusername",
            type:"POST",
            data:"username="+username,
            dataType:"json",
            success:function (data){
                alert(data)
                if(data==true){
                    $("#username~span").text("该用户已存在")
                }
                else {
                    $("#username~span").text("")
                }
            }
        })
    })

    $("#delete").click(function () {
        var username=$("#username").val();
        // alert(username)
        // location.href="delete?username="+username
        $.ajax({
            url:"delete",
            type:"POST",
            data:"username="+username,
            dataType:"json",
            success:function (data){
                alert("删除成功")
            }
        })
    })
})