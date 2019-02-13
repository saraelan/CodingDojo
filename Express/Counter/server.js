// Load the express module and store it in the variable express (Where do you think this comes from?)
var express = require("express");
console.log("Let's find out what express is", express);

//path 
var path = require("path");


// invoke express and store the result in the variable app
var app = express();
console.log("Let's find out what app is", app);

//session
var session = require('express-session');
app.use(session({ secret: "sssjdj" }));


var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({extended: true}));


//static content
app.use(express.static(__dirname + "/static"));

//ejs views
app.set('views', __dirname + '/views')
app.set('view engine', 'ejs');


//count By 1
app.get('/', function(request, response) 
{
	if(request.session.count==null)
	{
		request.session.count=1;
	}
	else
	{
		request.session.count++;
	}
  
   	console.log(request.session.count);
    response.render("index.ejs", { count:request.session.count });
})

app.get('/second', function(request, response) 
{	
	request.session.count+=1;
 	console.log(request.session.count);
    response.redirect('/');
})

app.get('/reset', function(request, response) 
{	
	request.session.count=0;
 	console.log(request.session.count);
    response.redirect('/');
})


app.listen(8000, function() {
 console.log("listening on port 8000");
});