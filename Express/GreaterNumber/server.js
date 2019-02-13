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


var random = Math.floor(Math.random() * 101);

app.get("/", function(req, res){
	
	if(!req.session.guess){
		var context = {
			status: "hidden",
			msg: "",
			showForm: "hidden"
		}
	}
	else{
		if(req.session.guess > random){
			var context = {
				status: "block red",
				msg: "Too High!",
				showForm: "hidden"	
			}
		}

		else if(req.session.guess < random){
			var context = {
				status: "block red",
				msg: "Too low!",
				showForm: "hidden"
			}
		}
		else{
			var context = {
				status: "block green",
				msg: "You guessed the number!",
				showForm: "show"
			}
		}
	}

	res.render("index", {context: context});
})



app.post("/guess", function(req, res){
	req.session.guess = req.body.aGuess;
	res.redirect("/");
})


app.post("/reset", function(req, res){
	random = Math.floor(Math.random() * 101);
	req.session.guess = undefined;
	res.redirect("/");
})

app.listen(8000, function(){
console.log("Listening on port 8000");
})










