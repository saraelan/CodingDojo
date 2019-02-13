const Tasks=require('./models/.js');
function getAllTAsks(req,res)
{
	Task.find({})
	.then(data=>console.log("you got"||res.json(data));
	.catch(errs=>console.log("you dont"||errs));



}

module exports=getAllTAsks;