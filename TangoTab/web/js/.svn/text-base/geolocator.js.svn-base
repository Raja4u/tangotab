function geolocate(timezone, cityPrecision){
    var key = 'c40724c36d392e354fe444ffc69c3cfd9e9e999c8df1c1ad7e9c8a9b4c5186d4';
    var api = (cityPrecision) ? "ip-city" : "ip-country";
    var domain = 'api.ipinfodb.com';
    var version = 'v3';
    var url = "http://" + domain + "/" + version + "/" + api + "/?key=" + key + "&format=json" + "&callback=?";
    var geodata;
    var JSON = JSON || {};
    
    // implement JSON.stringify serialization
    JSON.stringify = JSON.stringify ||
    function(obj){
        var t = typeof(obj);
        if (t != "object" || obj === null) {
            // simple data type
            if (t == "string") 
                obj = '"' + obj + '"';
            return String(obj);
        }
        else {
            // recurse array or object
            var n, v, json = [], arr = (obj && obj.constructor == Array);
            for (n in obj) {
                v = obj[n];
                t = typeof(v);
                if (t == "string") 
                    v = '"' + v + '"';
                else 
                    if (t == "object" && v !== null) 
                        v = JSON.stringify(v);
                json.push((arr ? "" : '"' + n + '":') + String(v));
            }
            return (arr ? "[" : "{") + String(json) + (arr ? "]" : "}");
        }
    };
    
    // implement JSON.parse de-serialization
    JSON.parse = JSON.parse ||
    function(str){
        if (str === "") 
            str = '""';
        eval("var p=" + str + ";");
        return p;
    };
    
    //Check if cookie already exist. If not, query IPInfoDB
    this.checkcookie = function(callback){
        geolocationCookie = getCookie('geolocation');
        //console.log(geolocationCookie);
        if (!geolocationCookie) {
            getGeolocation(callback);
        }
        else {
            geodata = JSON.parse(geolocationCookie);
            //console.log(geodata);
            callback();
        }
    }
    
    //Return a geolocation field
    this.getField = function(field){
        try {
            return geodata[field];
        } 
        catch (err) {
        }
    }
    
    //Request to IPInfoDB
    function getGeolocation(callback){
        try {
            $.getJSON(url, function(data){
                if (data['statusCode'] == 'OK') {
                    geodata = data;
                    //console.log(geodata);
                    JSONString = JSON.stringify(geodata);
                    //console.log(JSONString);
                    setCookie('geolocation', JSONString, 365);
                    callback();
                }
            });
        } 
        catch (err) {
        }
    }
    
    //Set the cookie
    function setCookie(c_name, value, expire){
        var exdate = new Date();
        exdate.setDate(exdate.getDate() + expire);
        document.cookie = c_name + "=" + escape(value) + ((expire == null) ? "" : ";expires=" + exdate.toGMTString());
    }
    
    //Get the cookie content
    function getCookie(c_name){
        if (document.cookie.length > 0) {
            c_start = document.cookie.indexOf(c_name + "=");
            if (c_start != -1) {
                c_start = c_start + c_name.length + 1;
                c_end = document.cookie.indexOf(";", c_start);
                if (c_end == -1) {
                    c_end = document.cookie.length;
                }
                return unescape(document.cookie.substring(c_start, c_end));
            }
        }
        return '';
    }
}
