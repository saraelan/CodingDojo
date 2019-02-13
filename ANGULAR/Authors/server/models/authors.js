var mongoose = require('mongoose');
var uniqueValidator = require('mongoose-unique-validator');

var QuoteSchema=new mongoose.Schema({
	content:{type: String, required:[true, 'Quote needs to be present'], minlength:[3, "Has to be longer than three chracters"]},
	votes:{type:Number,default:0}

},{timestamps:true});

var AuthorSchema = new mongoose.Schema({
    name: {type: String, required:[true, 'Name needs to be present'], minlength:[3, "Has to be longer than three chracters"] , unique: true, uniqueCaseInsensitive: true},
	quotes: [QuoteSchema]
},
{timestamps: true});


AuthorSchema.plugin(uniqueValidator);
mongoose.model('Author', AuthorSchema);
mongoose.model('Quote', QuoteSchema);

