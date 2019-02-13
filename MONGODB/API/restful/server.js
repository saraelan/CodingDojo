
var express     = require("express");
var path        = require("path");
var bodyParser  = require("body-parser");
var session     = require("express-session");
var app         = express();

app.use(session({ secret: "tttttttttteeee" }));

// app.use(bodyParser.urlencoded({ extended:true }));
app.use(bodyParser.json());

app.use(express.static(path.join(__dirname, "./static")));
app.set('views', path.join(__dirname, "./views"));
app.set('view engine', 'ejs');



require('./server/config/mongoose.js');

var routes_setter = require('./server/config/route.js');
routes_setter(app);


app.listen(8000, function() {
    console.log("Connected on PORT 8000");
})