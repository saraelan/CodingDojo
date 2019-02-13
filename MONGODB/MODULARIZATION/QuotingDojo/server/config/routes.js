
var mongoose    = require('mongoose');
var Quote = mongoose.model('Quote');
var quotes = require('../controller/quotes.js');
module.exports = function(app) {


app.get('/', function(req, res) {                        
    res.render('index');                               
})

app.get('/quotes', function(req, res) {
    quotes.show(req,res);
})


app.post('/addquotes', function(req, res){
   quotes.create(req,res);

})
}