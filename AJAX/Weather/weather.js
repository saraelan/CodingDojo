


      $(document).ready(function() 

      {
        $('form').submit(function(){
        var location = $("input[name='city']").val();
        var api = "65e47e0ed0443eecf085ee4c33479c29";
        var url = "http://api.openweathermap.org/data/2.5/weather?q="+location+"&&appid="+api;

          $.get(url, function(res) 
          {
            console.log(res);
            var name = res.name;
            var temp = res.main.temp;
            var html_str = "<h1>"+name+"</h1><h3>Current Temperature: "+temp+" Kelvin</h3>";

            $('.wrapper').html(html_str);
          }, "json");


          return false;
           })
      });