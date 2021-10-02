$(document).ready(function(){
    $("#sign-up").click(function(){
        $('.sign-in').css('margin-left','-34rem')
        $(this).css('margin-top',"-5rem");
        $('.sign-in-img').css('margin-left','0rem')

    })
    $("#sign-in").click(function(){
        $('.sign-in').css('margin-left','0rem')
        $("#sign-up").css('margin-top',"0.8rem");
        $('.sign-in-img').css('margin-left','-35rem')

    })
})
