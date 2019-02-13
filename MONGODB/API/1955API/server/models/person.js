

var mongoose = require('mongoose');
var PersonSchema = new mongoose.Schema({
    name: {type: String, required: true, minlength: 3}
},{timestamps: true});
mongoose.model('Person', PersonSchema);