$(function(){

    // アップロードボタンを押下した
    $("#data_upload_form").submit(function(event){
        // 要素規定の動作をキャンセルする
        event.preventDefault();

        var ajaxUrl = "http://localhost:8080/file/upload"

        if(window.FormData){
            var formData = new FormData($(this)[0]);

            $.ajax({
                type : "POST",                  // HTTP通信の種類
                url  : ajaxUrl,                 // リクエストを送信する先のURL
                dataType : "json",              // サーバーから返されるデータの型
                data : formData,                // サーバーに送信するデータ
                processData : false,
                contentType: false,
            }).done(function(data) {        // Ajax通信が成功した時の処理
            	$('#json-viewer').jsonViewer(data);
                console.log(data);
                console.log("ajax通信が成功しました。");
            }).fail(function(jqXHR, textStatus, errorThrown) { // Ajax通信が失敗した時の処理
                console.log("ajax通信に失敗しました");
                console.log("XMLHttpRequest : " + jqXHR.status);
                console.log("XMLHttpRequest : " + jqXHR.responseText);
                console.log("textStatus     : " + textStatus);
                console.log("errorThrown    : " + errorThrown.message);
            });
        }else{
            alert("アップロードに対応できていないブラウザです。");
        }
    });
});
