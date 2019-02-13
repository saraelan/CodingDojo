
var express     = require("express");
var path        = require("path");
var bodyParser  = require("body-parser");
var session     = require("express-session");
var app         = express();

var mongoose    = require('mongoose');
mongoose.connect('mongodb://localhost/Quote_mongoose');
    var QuoteSchema = new mongoose.Schema({
        name: {type: String, required: true, minlength: 3},
        quote: {type: String, required: true, minlength: 10},
        created : { type: Date, default: Date.now }
        }, {timestamps: true});
    mongoose.model('Quote', QuoteSchema);     
    var Quote = mongoose.model('Quote')       



app.use(session({ secret: "kittykatlicklick" }));
app.use(bodyParser.urlencoded({ extended:true }));
app.use(express.static(path.join(__dirname, "./static")));
app.set('views', path.join(__dirname, "./views"));
app.set('view engine', 'ejs');

app.get('/', function(req, res) {                        
    res.render('index');                               
})

app.get('/quotes', function(req, res) {
    Quote.find({}, function(err,quotes){
        console.log(quotes);
        res.render('quotes', {quotes : quotes});
    }) 
})


app.post('/addquotes', function(req, res){
    console.log("POST DATA:", req.body);
    var quote = new Quote({name: req.body.name, quote: req.body.quote});
    quote.save(function(err){
        if(err){
            console.log("something went wrong");
        } else {
            console.log("successfully added a user!");
            res.redirect('/quotes')
        }
    })
})

app.listen(8000, function() {
    console.log("listening on port 8000");
})