const xp =require("express");
const app=xp();
const path =require('path');
app.set("view engine","ejs");
app.set('views',path.join(__dirname,'./views'));
app.get('/', function(request, response) 
{let ada="aaa";
let rob=['hhh','kkk'];
let condition =false;
let context ={
	"name" : ada,
	"list" : rob,
	"bool" : condition,
}
res.render('index',context);
})
app.listen(8000, function() {
  console.log("listening on port 8000");
})