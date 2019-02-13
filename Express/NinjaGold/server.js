
var express     = require("express");
var path        = require("path");
var bodyParser  = require("body-parser");

var app         = express();

var session     = require("express-session");
app.use(session({ secret: "fff" }));

app.use(bodyParser.urlencoded({ extended:true }));

app.use(express.static(path.join(__dirname, "./static")));

app.set('views', path.join(__dirname, "./views"));
app.set('view engine', 'ejs');


app.get('/', function(req, res) 
{

	if (req.session.gold==null)
	{
		req.session.gold=0;
	}

	context={
		'gold':req.session.gold
	}

	
    res.render('ninja',context);
})


app.post('/gold',function(req,res)
{
	

	if(req.body.place=="farm")
	{	
		console.log(req.body);
		earned=Math.floor(Math.random()*11);
		console.log(earned);
		req.session.gold+=earned;
		console.log(req.session.gold)
	}

	else if(req.body.place=="cave")
	{	

		earned=Math.floor(Math.random()*25)-10;
		console.log(earned);
		req.session.gold+=earned;
		console.log(req.session.gold)
	}

	else if(req.body.place=="house")
	{	

		earned=Math.floor(Math.random()*33)-12;
		console.log(earned);
		req.session.gold+=earned;
		console.log(req.session.gold)
	}

	else if(req.body.place=="casino")
	{	

		earned=Math.floor(Math.random()*100)-50;
		console.log(earned);
		req.session.gold+=earned;
		console.log(req.session.gold)
	}


	res.redirect('/');
})







app.listen(8000, function() {
    console.log("Listening to port 8000");
})