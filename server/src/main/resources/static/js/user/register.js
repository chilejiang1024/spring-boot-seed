function submit() {
    var username = $(".username").val();
    var password = $(".password").val();
    console.log(username + password);
    $.ajax({
        url: "/api/v1/user/add",
        method: "POST",
        data: {
            username: username,
            password: password
        },
        success: function (data) {

        },
        error: function (data) {

        }
    })
}

