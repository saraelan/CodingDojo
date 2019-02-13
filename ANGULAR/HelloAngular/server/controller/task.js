
var mongoose    = require('mongoose');
var Task      = mongoose.model('Task');
module.exports = {
    showall: function( req, res ){
        Task.find({}, function (err, tasks){
            if (err){
                return res.json(err)
            } else {
                res.json(tasks);
            }
        })
    },
    create: function( req, res ){
        console.log(req.body);
       Task.create(req.body, (err,tasks) => {
            if(err){
                return res.json(err);
            }
            return res.json(tasks);
        })
    
    },
    showById: function( req, res ){
         Task.findById(req.params.id, (err, tasks) => {
            if(err){
                return res.json(err);
            }
            return res.json(tasks);
        })
    },
    deleteById: function( req, res ){
        Task.findByIdAndRemove(req.params.id,(err, tasks) => {
            if(err){
                return res.json(err);
            }
            return res.json(tasks);
        })
    
    },


    updateById: function( req, res ){
        Task.findByIdAndUpdate(req.params.id,req.body,(err, tasks) => {
            if(err){
                return res.json(err);
            }
            return res.json(tasks);
        })
    },


}





