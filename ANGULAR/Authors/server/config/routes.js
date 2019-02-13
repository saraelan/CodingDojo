var mongoose=require('mongoose');
var Author =mongoose.model('Author');
var Quote = mongoose.model('Quote');
var authors =require('../controller/authors.js');

module.exports= function(app)
{

	app.get('/all',function(req,res)
	{
		authors.all(req,res);
	})
	app.get('/:id',function(req,res)
	{
		authors.display(req,res);
	})
	app.post('/new',function(req,res)
	{
		authors.new(req,res);
	})
	app.put('/update/:id',function(req,res)
	{
		authors.update(req,res);
	})
	app.delete('/delete/:id',function(req,res)
	{
		authors.delete(req,res);
	})


	app.post('/new/write/:id',function(req,res)
	{ 	
		console.log("Inside Quotes")
		authors.newQuote(req,res);

	})

	app.delete('/delete/:authorId/:quoteId',function(req,res)
	{	console.log("Inside Quotes")
		authors.deleteQuote(req,res);

	})

	app.put('/quotes/:quoteId/:authorId',function(req,res)
	{
		console.log("Inside Quotes")
		authors.vote(req,res);
	})








};


	







	
