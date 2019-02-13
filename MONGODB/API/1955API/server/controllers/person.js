
var mongoose    = require('mongoose');
var Person      = mongoose.model('Person');

module.exports = {
    show: function( req, res ){
        Person.find({}, function (err, people){
            res.json(people);
        })
    },
    create: function( req, res ){
        var person = new Person(req.params);
        person.save(function (err) {
            if (err){
                console.log('Error');
                res.redirect('/');
            } else {
                console.log('Success');
                res.redirect('/');
            }
        })
    },
    showByName: function( req, res ){
        Person.find({name: req.params.name}, function (err, person){
            res.json(person);
        })
    },
    deleteByName: function( req, res ){
        Person.remove({name: req.params.name}, function (err, person){
            if (err){
                console.log('Error');
                res.redirect('/');
            } else {
                console.log('Success');
                res.redirect('/')
            }
        })
    }
}