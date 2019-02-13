
var mongoose    = require('mongoose');
var Author     = mongoose.model('Author');
var Quote = mongoose.model('Quote');



module.exports = 
{
	all: function( req, res ){
        Author.find({}, function (err, authors){
            if (err){
            	console.log("No Authors Found",err)
                return res.json(err)
            } else {
            	console.log("All Authors Found")
                res.json(authors);
            }
        })
    },

   new:function( req, res ){
       Author.create(req.body, function(err,authors){
            if(err){
                let error=[];
                for(var key in err.errors)
                error.push(err.errors[key].message)
                console.log("No Author created",err.errors[key].message);
                return res.json({error});      
            }
            console.log("Author Created")
            return res.json(authors);
        })
    
    },

    newQuote:function(req,res)
    {
        console.log("Inside Quotes")
        Quote.create(req.body,function(err,quotes){
            if(err)
            {
                let error=[];
                for(var key in err.errors)
                error.push(err.errors[key].message)
                console.log("No Quote created",err.errors[key].message);
                return res.json({error});      
            }
            else
            {
                Author.findByIdAndUpdate(req.params.id,{$push:{quotes:req.body}},{new:true})
                {
                    if(err)
                    {
                    let error=[];
                    for(var key in err.errors)
                    error.push(err.errors[key].message)
                    console.log("No Author found",err.errors[key].message);
                    return res.json({error});      
                    }
                    else
                    {
                    console.log("Quote Created")
                    return res.json(quotes);
                    }
                }
            }
        })
    },
         

    


    display: function( req, res ){
         Author.findById({_id:req.params.id},function(err, author){
            if(err){
            	console.log("Not Display A single Author")
                return res.json(err);
            }
            console.log("Single Author created")
            return res.json(author);
        })
    },

     delete: function( req, res ){
        Author.findByIdAndRemove(req.params.id,function(err, author){
            if(err){
            	console.log(err)
                return res.json(err);
            }
            console.log("Author Deleted")
            return res.json(author);
        })
    
    },

    deleteQuote(req,res)
   {
        Author.findOneAndUpdate(req.params.authorId,{$pull: {'quotes': { _id: req.params.quoteId}}}, {new:true},function(err, author){
            if(err){
                console.log("Quote not deleted",err)
                return res.json(err);
            }
            console.log("Quote Deleted")
            return res.json(author);
        })
    
    },

    update: function( req, res ){
        
       Author.findByIdAndUpdate(req.params.id,{name:req.body.name},{runValidators: true },function(err,author){
            if(err){
                let error=[];
                for(var key in err.errors)
                error.push(err.errors[key].message)
            	console.log("No Author updated",err.errors[key].message);
                return res.json({error:err.errors[key].message});
            }
            console.log("Author updated");
            return res.json(author);
        })
    },

    vote:function(req,res)
    {
        Author.findOneAndUpdate({_id:req.params.authorId,'quotes_id':req.params.quoteId},{$inc:{'quotes.$.votes':req.body.voting}},{new: true },function(err,author){
    if(err){     
                for(var key in err.errors)
                console.log("No Voting done",err.errors[key].message);
                return res.json({error:err.errors[key].message});
            }
            console.log("Voting updated");
            return res.json(author);
        })
    },



}