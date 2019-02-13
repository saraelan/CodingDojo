
var cont  = require('../controller/books.js');



module.exports = function(app){

    app.get('/books', function (req, res){
        cont.showBooks(req, res);
    })

    app.get('/authors', function (req, res){
        cont.showAuthors(req, res);
    })

    app.get('/authors/:id', function (req, res){
        cont.showById(req, res);
    })


     app.get('/books/:id', function (req, res){
        cont.showById(req, res);
    })

    app.post('/books', function (req, res){
        cont.create(req, res);
    })

    app.post('/authors', function (req, res){
        cont.create(req, res);
    })

    app.delete('/books/:id', function (req, res){
        cont.deleteById(req, res);
    })

    app.delete('/authors/:id', function (req, res){
        cont.deleteById(req, res);
    })

    app.put('/books/:id', function (req, res){
        cont.deleteById(req, res);
    })

    app.patch('/authors/:id', function (req, res){
        cont.deleteById(req, res);
    })


}