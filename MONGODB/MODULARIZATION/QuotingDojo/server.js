
var express     = require("express");
var path        = require("path");
var bodyParser  = require("body-parser");
var session     = require("express-session");
var app         = express();

var mongoose    = require('mongoose');

    

app.use(session({ secret: "kittykatlicklick" }));
app.use(bodyParser.urlencoded({ extended:true }));
app.use(express.static(path.join(__dirname, "./clients/static")));
app.set('views', path.join(__dirname, "./clients/views"));
app.set('view engine', 'ejs');

require('./server/config/mongoose.js');
var routingsetter=require('./server/config/routes.js');
routingsetter(app);

app.listen(8000, function() {
    console.log("listening on port 8000");
})