if (C4 == null || typeof(C4) != "object") { var C4 = new Object();}
if (C4.util == null || typeof(C4.util) != "object") { C4.util = new Object();}


C4.util = {
    column_propagator : function(selector) {
        return function() { 
            var changed = $(selector).index(this);
            $(selector).slice(changed+1).attr('value', this.value);
        };
    }
}
