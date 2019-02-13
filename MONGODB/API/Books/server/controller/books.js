
var mongoose = require('mongoose');
var Book     = mongoose.model('Book');
var Author = mongoose.model('Author');


module.exports = {
    showAuthors: function( req, res ){
        Author.find({}, function (err, auth){
            res.json(auth);
        })
    },


     showBooks: function( req, res ){
        Author.find({}, function (err, boo){
            res.json(boo);
        })
    },

}










//     create: function( req, res ){
//         var author = new Author(req.params);
//        author.save(function (err) {
//             if (err){
//                 console.log('Error');
//                 res.redirect('/');
//             } else {
//                 console.log('Success');
//                 res.redirect('/');
//             }
//         })
//     },
// }
//     showByName: function( req, res ){
//         Person.find({name: req.params.name}, function (err, person){
//             res.json(person);
//         })
//     },
//     deleteByName: function( req, res ){
//         Person.remove({name: req.params.name}, function (err, person){
//             if (err){
//                 console.log('Error');
//                 res.redirect('/');
//             } else {
//                 console.log('Success');
//                 res.redirect('/')
//             }
//         })
//     }
// }