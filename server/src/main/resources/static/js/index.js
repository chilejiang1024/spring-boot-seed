function testException() {
    $.ajax({
        url: "/api/v1/first/get",
        type: "GET",
        success: function (data) {
            console.log(data);
        },
        error: function (data) {
            var response = data.responseText.split("\n")[0];
            var responseJson = JSON.parse(response);
            console.log(responseJson);
        }
    })
}


