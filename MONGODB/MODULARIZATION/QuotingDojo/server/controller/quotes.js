var mongoose = require('mongoose');
var Quote = mongoose.model('Quote');
module.exports=
{
	

	show:function(req,res)
	{
		Quote.find({}, function(err,quotes)
			{
		        console.log(quotes);
		        res.render('quotes', {quotes : quotes});
		    }) 
	},

	create:function(req,res)
	{
		console.log("POST DATA:", req.body);
	    var quote = new Quote({name: req.body.name, quote: req.body.quote});
	    quote.save(function(err)
	    {
	        if(err)
	        {
	            console.log("something went wrong");
	        } else 

	        {
	            console.log("successfully added a quote!");
	            res.redirect('/quotes')
	        }
	    })

	}
}