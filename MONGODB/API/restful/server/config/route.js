var Task  = require('../controller/task.js');
module.exports = function(app){
    
    app.get('/tasks', function (req, res){
        Task.showall(req, res);
    })
    app.get('/tasks.:id', function (req, res){
        Task.showById(req, res);
    })
    app.post('/tasks', function (req, res){
        Task.create(req, res);
    })
    app.delete('/tasks/:id', function (req, res){
        Task.deleteById(req, res);
    })

    app.put('/tasks/:id', function (req, res){
        Task.updateById(req, res);
    })
}