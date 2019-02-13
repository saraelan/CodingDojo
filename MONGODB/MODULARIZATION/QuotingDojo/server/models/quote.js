var mongoose    = require('mongoose');
 var QuoteSchema = new mongoose.Schema({
        name: {type: String, required: true, minlength: 3},
        quote: {type: String, required: true, minlength: 10},
        created : { type: Date, default: Date.now }
        }, {timestamps: true});
mongoose.model('Quote', QuoteSchema);  
var Quote = mongoose.model('Quote');
