
var express     = require("express");
var path        = require("path");
var bodyParser  = require("body-parser");
var session     = require("express-session");
var app         = express();
// var validate = require('mongoose-validator')
const flash     =require('express-flash')


var mongoose    = require('mongoose');
mongoose.connect('mongodb://localhost/Message_mongoose');

// var nameValidator = [
//   validate({
//     validator: 'isLength',
//     arguments: [3, 50],
//     message: 'Name should be between {ARGS[0]} and {ARGS[1]} characters',
//   }),
//   validate({
//     validator: 'isAlphanumeric',
//     passIfEmpty: true,
//     message: 'Name should contain alpha-numeric characters only',
//   }),
// ]


var UserSchema = new mongoose.Schema({
    name: {type: String, required: true, minlength: 3}
   }, {timestamps: true})

   mongoose.model('User', UserSchema); // We are setting this Schema in our Models as 'User'
   var User = mongoose.model('User') // We are retrieving this Schema from our Models, named 'User'

app.use(session({ secret: "kittykatlicklick" }));
app.use(bodyParser.urlencoded({ extended:true }));
app.use(express.static(path.join(__dirname, "./static")));
app.set('views', path.join(__dirname, "./views"));
app.set('view engine', 'ejs');
app.use(flash());




app.post('/users', function (req, res){
    var user = new User(req.body);
    user.save(function(err){
        if(err){
            // if there is an error upon saving, use console.log to see what is in the err object 
            console.log("We have an error!", err);
            // adjust the code below as needed to create a flash message with the tag and content you would like
            for(var key in err.errors){
                req.flash('registration', err.errors[key].message);
            }
            // redirect the user to an appropriate route
            res.redirect('/');
        }
        else {
            res.redirect('/users');
        }
    });
});
	
    	

app.listen(8000, function() {
    console.log("listening on port 8000");
  });