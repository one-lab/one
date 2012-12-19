/**
 * js模拟div的滚动条
 * moontea
 */

$.fn.scrollBar = function(settings)
{
    settings = $.extend({
        id : 'scrollContainer', // 滚动容器id
        scrollContent : 'scrollContent', // 滚动内容id
        scrollBarParent : 'scrollBarParent', // 滚动条父节点id 
        scrollBar : 'scrollBar' // 滚动条id
    }, settings);
    
    _init();
    
    var scrollContainerHeight = $('#' + settings.id).height();
    var scrollContentHeight = $('#' + settings.scrollContent).outerHeight();
    var scrollBarParentHeight = $('#' + settings.scrollBarParent).height();
    var scrollBarHeight = $('#' + settings.scrollBar).height();
    
    var scrollMaxHeight = scrollBarParentHeight - scrollBarHeight;
    
    var startPosition = {};
    var draggable = false;
    
    _init();
    
    function _init() 
    {
        _mouseDown();
        _mouseMove();
        _mouseUp();
    }
    
    // 给滚动条绑定mousedown事件
    function _mouseDown()
    {
        $('#' + settings.scrollBar).mousedown(function(e) {
            startPosition = _getMouseCoordinate(e);
            draggable = true;
            return false;
        });
    }
    
    // 给滚动条绑定mousemove事件
    function _mouseMove()
    {
        $('#' + settings.scrollBar).mousemove(function(e) {
            if (!draggable) {
                return;
            }
            var currentPosition = _getMouseCoordinate(e);
            var scrollHeight = currentPosition.y - startPosition.y;
            scrollHeight = scrollHeight > 0 ? scrollHeight : 0;
            scrollHeight = scrollHeight > scrollMaxHeight ? scrollMaxHeight : scrollHeight;
            $(this).css({
                left : 0,
                top : scrollHeight + 'px',
                margin : 0
            });
            $('#' + settings.scrollContent).css('margin-top', - (scrollHeight / scrollMaxHeight) * (scrollContentHeight - scrollContainerHeight) + 'px');
            return false;
        });
    }
    
    function _mouseUp()
    {
        $('#' + settings.id).mouseup(function() {
            draggable = false;
        });
    }
    
    // 获取鼠标坐标值，相对于document
    function _getMouseCoordinate(e)
    {
        return {
            x : e.pageX,
            y : e.pageY
        };
    }
}
