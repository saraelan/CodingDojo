
var express     = require("express");
var path        = require("path");
var app         = express();



// app.use(express.static(path.join(__dirname, "./static")));
app.set('views', path.join(__dirname, "./views"));
app.set('view engine', 'ejs');



require('./server/config/mongoose.js');

var routes_setter = require('./server/config/route.js');
routes_setter(app);

app.use(express.static( __dirname + '/public/dist/public' ));


app.listen(8000, function() {
    console.log("Hello !! Listening on PORT 8000");
})