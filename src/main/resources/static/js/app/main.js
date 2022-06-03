let main = {
    init : function(){
        let _this = this;
        $('#submit').on('click', function () {
            _this.submit();
        });
    },
    submit : function() {
        let _this = this;
        let address = $('#address').val();

        $.ajax({
            type: 'GET',
            url: '/oembed?url=' + address,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function(data) {
            _this.print(data);
        }).fail(function (error) {
            console.log(error.responseJSON.message);
        });
    },
    print : function(printData){
        document.querySelector("#resultTable").innerHTML = "";
        for(let data in printData){
            if(data === "thumbnail_url"){
                document.querySelector("#resultTable").innerHTML += "<tr><td>" + data + "</td><td><img src=" + printData[data] + "></td></tr>";
                continue;
            }
            document.querySelector("#resultTable").innerHTML += "<tr><td>" + data + "</td><td>" + printData[data] + "</td></tr>";
        }
    }
};

main.init();