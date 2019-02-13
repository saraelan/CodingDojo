var express     = require("express");
var path        = require("path");
var bodyParser  = require("body-parser");
var session     = require("express-session");
var app         = express();

var mongoose    = require('mongoose');
mongoose.connect('mongodb://localhost/Car_mongoose');


    var CarSchema = new mongoose.Schema({
        model: {type: String, required: true, minlength: 1},
        color: {type: String, required: true, minlength: 1}
        }, {timestamps: true});
    mongoose.model('Car', CarSchema);     
    var Car = mongoose.model('Car')       



app.use(session({ secret: "kittykatlicklick" }));
app.use(bodyParser.urlencoded({ extended:true }));
app.use(express.static(path.join(__dirname, "./static")));
app.set('views', path.join(__dirname, "./views"));
app.set('view engine', 'ejs');

// app.get('/', function(req, res) {                        
//     res.render('index');                               
// })


//Displays all of the cars.
app.get('/cars',function(req, res) {
    Car.find({}, function(err,cars){
        if(err){
        console.log("Something went wrong");
      }
      else{
        console.log("Car landed  successfully");
        console.log(cars);
        res.render('car', {cars : cars});
    }
    }) 
})

//Displays information about one cars.
app.get ('/cars/:id',function(req, res)
{
	Car.findOne(req.params.id, function(err, cars) {
		 if(err){
            console.log("something went wrong");
        } else {
            console.log("Car landed successfullly!");
            res.redirect('/cars')
        }
    })	
	console.log(cars);
	res.render('show',{cars:cars})

})

app.get('/cars/new', function(req, res){
  console.log("Car Form");
  res.render('car');
});


//Displays a form for making a new mongoose.
app.post('/cars',function(req, res){
    console.log("POST DATA:", req.body);
    var car = new Car({color: req.body.color, model: req.body.model});
    model.save(function(err){
        if(err){
            console.log("something went wrong");
        } else {
            console.log("successfully added a user!");
            res.redirect('/cars')
        }
    })
})


// Should show a form to edit an existing cars
app.get('/cars/edit/:id',function(req,res){
Car.findById(req.params.id, function (err,cars)
{		console.log(req.params.id);
		if(err){
            console.log("something went wrong");
        } else {
            console.log("successfully added a user!");
            res.render('edit', {cars : cars});
        }
    })
})

//Should be the action attribute for the form in the above route (GET '/cars/edit/:id').
app.post('/cars/:id',function(req,res){
	console.log(req.body);
    console.log(req.params.id);
    Car.findOneAndUpdate({_id: req.params.id}, req.body, {upsert:false}, function(err, cars){
        if (err) return handleError(err);
        console.log(cars);
        res.redirect('/cars');
    })
})

//Should delete the mongoose from the database by ID.
app.post('/cars/destroy/:id',function(req, res){
	Car.findByIdAndRemove(req.params.id, function (err){
		if(err){
            console.log("something went wrong");
        } else {
            console.log("successfully added a cars!");
            res.redirect('/cars')
        }
    })
})

app.listen(8000, function() {
    console.log("listening on port 8000");
})