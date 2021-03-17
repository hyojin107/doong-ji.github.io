$(function () {

    //0 메뉴 펼친 상태 | 1 메뉴 접힌 상태
    var button = 0;

    $('.button-toggle-menu').click(function () {

        //button-toggle-menu click시 menu 보이기
        $('.menu').css({
            display: 'block'
        });

        //button-toggle-menu click시 아이콘 바꾸기
        $(this).css({
            display: 'none'
        }).next().css({
            display: 'block'
        });

        //스크롤 막기
        if (button === 0) {

            $('body').css({
                overflow: 'hidden'
            });

            button = 1;

        }

    }); //click

    $('.button-toggle-close').click(function () {

        //button-toggle-close click시 menu 숨기기
        $('.menu').css({
            display: 'none'
        });

        //button-toggle-close click시 아이콘 바꾸기
        $(this).css({
            display: 'none'
        }).prev().css({
            display: 'block'
        });

        //스크롤 막기
        if (button === 1) {

            $('body').css({
                overflow: 'auto'
            });

            button = 0;

        }

    }); //click

    /*$('.menu>li').click(function () {
        
        $(this).find('.sub-menu li').stop().slideDown(200);
        
    }); //click*/



}); //jQuery