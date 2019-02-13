
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


app.get('/', function(req, res) {
    res.render('index');
});


app.post('/user', function(req, res) {
    req.session.info = req.body;   
    console.log("User detail Body", req.body); 
    res.redirect('/result');
});


app.get('/result', function(req, res){

	context={
		
	"name" : req.session.info.username,
	"location":req.session.info.dj,
	"language":req.session.info.fl,
	"comment":req.session.info.comment,

	}
    res.render('result',context);
});


app.listen(8000, function() {
    console.log("Listening to port 8000");
});