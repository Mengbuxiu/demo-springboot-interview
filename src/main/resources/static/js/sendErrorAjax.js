$.ajax({
    url: "/error/getAjaxError",
    type: "post",
    success: function (data) {
        if (data.status == 200 && data.msg == "OK") {
            alert("success");
        } else
            alert("failed: " + data.msg);
    },
    error: function (response, ajaxOptions, thrownError) {
        debugger;
        alert("error");
    }
});
