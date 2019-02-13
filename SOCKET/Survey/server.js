
var express     = require("express");
var path        = require("path");
var bodyParser  = require("body-parser");
var app         = express();

app.use(bodyParser.urlencoded({ extended:true }));
app.use(express.static(path.join(__dirname, "./static")));
app.set('views', path.join(__dirname, "./views"))
app.set('view engine', 'ejs');


app.get('/', function(req, res) {
    res.render('index');
});




var server =app.listen(8000, function() {
    console.log("Listening to port 8000");
});

var io = require('socket.io').listen(server);
io.sockets.on('connection', function (socket) { 
console.log("I am connected");
socket.on('posting_form',function(data)
	{ 
var recieved =data;
var temp =Math.floor(Math.random()*1000)+1;
socket.emit('random_number',temp);
socket.emit('updated',recieved);


})

});

