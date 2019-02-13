var express     = require("express");
var path        = require("path");
var bodyParser  = require("body-parser");
var app         = express();

app.use(bodyParser.urlencoded({ extended:true }));
app.use(express.static(path.join(__dirname, "./static")));
app.set('views', path.join(__dirname, "./views"))
app.set('view engine', 'ejs');


app.get('/', function(req, res) {
    res.render('index',{count:c});
});

var server =app.listen(8000, function() {
    console.log("Listening to port 8000");
});

var c=0;
var io = require('socket.io').listen(server);
io.sockets.on('connection', function (socket) { 
console.log("I am connected");
socket.on('pushed',function()
{
	c++;
	socket.emit('updated',{count:c})
});
socket.on ('reset',function()
{
	c=0;
	socket
	.emit('updated',{count:c})
})

});


