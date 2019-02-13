// Load the express module and store it in the variable express (Where do you think this comes from?)
var express = require("express");
console.log("Let's find out what express is", express);

// invoke express and store the result in the variable app
var app = express();
console.log("Let's find out what app is", app);


//static content
app.use(express.static(__dirname + "/static"));

//ejs views
app.set('views', __dirname + '/views')
app.set('view engine', 'ejs');




app.get("/", function (request, response){
    console.log(require.body);
    response.render('cats');
    
    
})

app.get("/cuddles", function (request, response){
    var cats_array=[
    {name:"Cuddles",ff:"Spaghetti",age:"3" ,ss:"under the bed and in a sun beam" , pic :"/images/c.jpg" }];
     response.render('details', {cat:cats_array});
    
})


app.get("/keen", function (request, response){
    var cats_array=[
    {name:"Keen",ff:"Noodles",age:"5" ,ss:"Grass" , pic :"/images/s.jpg" }];
     response.render('details', {cat:cats_array});
    
})


// tell the express app to listen on port 8000, always put this at the end of your server.js file
app.listen(8000, function() {
  console.log("listening on port 8000");
})
