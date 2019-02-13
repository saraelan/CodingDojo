

var mongoose = require('mongoose');
var Schema = mongoose.Schema;
const AuthorSchema=new mongoose.Schema({
name: {type: String, required:[true, 'Name needs to be present'], minlength:[3, "Has to be longer than three chracters"]},
age: {type: Number, required: true, min: 3},
books: [{type: Schema.Types.ObjectId, ref: 'Book'}]
    }, {timestamps: true});

const BookSchema=new mongoose.Schema({
    _post: {type: Schema.Types.ObjectId, ref: 'Author'},
    title: {type: String, required:[true, 'Name needs to be present'], minlength:[3, "Has to be longer than three chracters"]},
    description: {type: String, required:[true, 'Name needs to be present'], minlength:[3, "Has to be longer than three chracters"]},
    }, {timestamps: true});

	mongoose.model('Author', AuthorSchema);     
    mongoose.model('Book', BookSchema);     
    