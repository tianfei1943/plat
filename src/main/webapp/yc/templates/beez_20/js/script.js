$(function() {
    var $notices = $(".notices");

    if ($notices.children().length) {
        setInterval(function() {
            $notices.animate({
                top: -34
            }, 300, function() {
                $notices.append($notices.children().first()).css("top", 0);
            });
        }, 5e3);
    }

    if ($(".home-banner-2 .banner").length) {
        setInterval(function() {
            $(".home-banner-2 .banner").first().hide().appendTo(".home-banner-2").fadeIn(300);
        }, 5e3);
    }

    if ($(".picnews").length) {
        var $ul = $(".picnews ul");
        var $children = $ul.children();
        var width = $children.length * $children.width();
        var left = 0;
        var timer;

        function handleIn() {
            clearInterval(timer);
        }

        function handleOut() {
            timer = setInterval(function() {
                left--;

                if (left === -width) left = 0;

                $ul.css("left", left);
            }, 30);
        }

        $(".picnews ul").css("width", width * 2);

        $ul.append($children.clone());

        $ul.hover(handleIn, handleOut);

        handleOut();
    }

    function initSlides() {
        var $slides = $(".spotlight .slide");
        var $dots = $(".spotlight .dots span");
        var index = 0;

        function goSlide(n) {
            $slides.eq(n).addClass("active").siblings(".active").removeClass("active");
            $dots.eq(n).addClass("active").siblings(".active").removeClass("active");
            index = n;
        }

        $dots.click(function() {
            goSlide($(this).index());
        });

        setInterval(function() {
            index = (index + 1) % $slides.length;
        }, 5e3);
    }

    if ($(".spotlight").length) initSlides();
});
