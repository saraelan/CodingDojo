var express = require('express');
var bodyParser = require('body-parser');
var mongoose = require('mongoose');
var app = express();


app.use(express.static(__dirname + '/public/dist/public'));
app.use(bodyParser.json());
require('./server/config/mongoose.js');
require('./server/config/routes.js')(app);

app.listen(8000, function(){
    console.log("Listening on port 8000")
});